package com.moon.sms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.moon.sms.dto.MatBuyVO;
import com.moon.sms.util.DBManager;


public class MatBuyDAO {
	
	private static MatBuyDAO instance = new MatBuyDAO();
	public static  MatBuyDAO getInstance() {
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
	
public int nextvalBuySq() {
		
		
		String sql = "SELECT * FROM (SELECT BUY_SQ FROM TB_MAT_BUY ORDER BY ROWNUM DESC) WHERE ROWNUM = 1";
		
		Integer nextvalBuySq = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				
				nextvalBuySq = (rs.getInt("BUY_SQ"));
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}		
		
		return nextvalBuySq+1;
		
	}	
	
	
	
	

	public void regist(MatBuyVO mBVo) throws Exception {
	}
	
	public MatBuyVO read(int buySq) throws Exception {
		return null;
	}

	public List<MatBuyVO> listAll() {
		String sql = "SELECT * FROM TB_MAT ORDER BY MAT_SQ DESC";
		List<MatBuyVO> list = new ArrayList<MatBuyVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			
			while (rs.next()) {
				MatBuyVO mbVo = new MatBuyVO();
				
				mbVo.setBuySq(rs.getInt("BUY_SQ"));
				mbVo.setBuyDt(rs.getDate("BUY_DT"));
				mbVo.setEmpNo(rs.getInt("EMP_NO"));
				mbVo.setPurSq(rs.getInt("PUR_SQ"));
				
				
				list.add(mbVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}
	
	
}
