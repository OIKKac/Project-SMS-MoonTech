package com.moon.sms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.moon.sms.dto.MatInVO;
import com.moon.sms.util.DBManager;


public class MatInDAO {
	
	
	
	
	
	private static MatInDAO instance = new MatInDAO();
	public static  MatInDAO getInstance() {
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
	
	public int nextvalMatInSq() {
		
		String sql = "SELECT * FROM (SELECT IN_SQ FROM TB_MAT_IN ORDER BY ROWNUM DESC) WHERE ROWNUM = 1";
		
		Integer nextvalMatInSq = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				
				nextvalMatInSq = (rs.getInt("IN_SQ"));
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}		
		
		return nextvalMatInSq + 1;
	}	
	
	public void regist(MatInVO mIVo) {
		


		
	}
	
	public void read(int inSq) {
		

	}

	public void delete(int inSq) {
		
	}
	
   



	
}
