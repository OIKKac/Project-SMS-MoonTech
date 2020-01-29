package com.moon.sms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.moon.sms.dto.MatBuyReqVO;
import com.moon.sms.util.DBManager;

public class MatBuyReqDAO {

	
	private static MatBuyReqDAO instance = new MatBuyReqDAO();
	public static  MatBuyReqDAO getInstance() {
		return instance;
	}
	
	public Connection getConnection() throws Exception {
		Connection conn = null;
		Context initContext = new InitialContext();
		Context envContext  = (Context)initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
		conn = ds.getConnection();
		
		return conn;		
	}
	
	public int nextvalMatBuyReqSq() {
		
		String sql = "SELECT * FROM "
					+"(SELECT REQ_SQ FROM TB_MAT_BUY_REQ ORDER BY ROWNUM DESC)" 
					+"WHERE ROWNUM = 1";
		
		Integer nextvalMatBuyReqSq = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {				
				nextvalMatBuyReqSq = (rs.getInt("REQ_SQ"));								
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}	
		return nextvalMatBuyReqSq + 1;
	}
	
	  public void regist(MatBuyReqVO mBRVo) {
		  
		  String sql = "INSERT INTO "
				  		+ "TB_MAT_BUY_REQ(REQ_SQ, EMP_NO) "
				  		+ "VALUES(? ,?)";
		  
		  Connection conn = null;
		  PreparedStatement pstmt = null;
			
		  try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
			  
				pstmt.setInt(1, mBRVo.getReqSq());
				pstmt.setInt(2, mBRVo.getEmpNo());
				
				pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
				
			} finally {
				DBManager.close(conn, pstmt);
			}
	  }		  
	  
	 
	public void delete(int matSq){
		
		String sql = "DELETE TB_MAT_BUY_REQ WHERE REQ_SQ = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, matSq);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
