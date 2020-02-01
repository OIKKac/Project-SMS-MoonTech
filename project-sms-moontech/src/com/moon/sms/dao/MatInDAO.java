package com.moon.sms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

	public void registIn(MatInVO mIVo) {
		
		String sql = "INSERT INTO TB_MAT_IN(IN_SQ, EMP_NO, PUR_SQ) VALUES(?, ?, ?)";

		Connection conn = null;
		PreparedStatement pstmt = null;
		
	
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, mIVo.getInSq());
			pstmt.setInt(2, mIVo.getEmpNo());
			pstmt.setInt(3, mIVo.getPurSq());
			
			pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	public void registDe(MatInVO mIVo) {
		
		String selectAmtSql = "SELECT stock_amt FROM (SELECT * FROM TB_MAT_STOCK ORDER BY ROWNUM DESC) A, TB_MAT B WHERE A.MAT_SQ = ? AND A.MAT_SQ = B.MAT_SQ AND ROWNUM =1";
		String deSql = "INSERT INTO tb_mat_in_de(DE_SQ, IN_SQ, MAT_SQ, IN_AMT) VALUES(SEQ_MAT_IN_DE.NEXTVAL, ?, ?, ?)";
		String stockSql = "INSERT INTO TB_MAT_STOCK(STOCK_SQ, MAT_SQ, STOCK_AMT, IN_AMT) VALUES(SEQ_MAT_STOCK.NEXTVAL, ?, ?, ?)" ;
		
		Integer matSq = null;
		Integer stockAmt = null;
		Integer inAmt = null;
		
		Connection conn = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		

		
		try {
			conn = DBManager.getConnection();
			pstmt1 = conn.prepareStatement(selectAmtSql);
			pstmt2 = conn.prepareStatement(deSql);
			pstmt3 = conn.prepareStatement(stockSql);
			
			//Get matSq, inAmt - Action 
			matSq = mIVo.getMatSq();
			inAmt = mIVo.getInAmt();
			
			//Get matSq, StockAmt - DB
			pstmt1.setInt(1, matSq);
			rs1 = pstmt1.executeQuery();
				
			if(rs1.next()) {
				stockAmt = rs1.getInt("STOCK_AMT");
				
				//Insert TB_MAT_IN_DE
				pstmt2.setInt(1, mIVo.getInSq());
				pstmt2.setInt(2, matSq);
				pstmt2.setInt(3, inAmt);
				pstmt2.executeUpdate();
				
				//Insert TB_MAT_STOCK
				stockAmt = stockAmt + inAmt;
				
				pstmt3.setInt(1, matSq);
				pstmt3.setInt(2, stockAmt);
				pstmt3.setInt(3, inAmt);
				pstmt3.executeUpdate();
				
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			DBManager.closeForUpdateStock(conn, pstmt1, pstmt2, pstmt3, rs1, rs2);
		}
		
	}
			
	
	
	public void read(int inSq) {
		

	}

	public void delete(int inSq) {
		
	}
	
   



	
}
