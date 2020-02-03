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

import com.moon.sms.dto.MatInVO;
import com.moon.sms.dto.PartPdcInVO;
import com.moon.sms.dto.PartVO;
import com.moon.sms.util.DBManager;


public class PartPdcInDAO {
	
	
	
	
	
	private static PartPdcInDAO instance = new PartPdcInDAO();
	public static  PartPdcInDAO getInstance() {
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
	
	public int nextvalPartPdcInSq() {
		
		String sql = "SELECT * FROM (SELECT IN_SQ FROM TB_PART_PDC_IN ORDER BY ROWNUM DESC) WHERE ROWNUM = 1";
		
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

	public void registIn(PartPdcInVO inVo) {
		
		String sql = "INSERT INTO TB_MAT_IN(IN_SQ, EMP_NO) VALUES(?, ?)";

		Connection conn = null;
		PreparedStatement pstmt = null;
		
	
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, inVo.getInSq());
			pstmt.setInt(2, inVo.getEmpNo());
			
			
			pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

	public void registDe(PartPdcInVO inVo) {
		
		String selectAmtSql = "SELECT stock_amt FROM (SELECT * FROM TB_PART_STOCK ORDER BY ROWNUM DESC) A, TB_PART B WHERE A.PART_SQ = ? AND A.PART_SQ = B.PART_SQ AND ROWNUM =1";
		String deSql = "INSERT INTO tb_PART_PDC_in_de(DE_SQ, IN_SQ, PART_SQ, IN_AMT) VALUES(SEQ_PART_PDC_IN_DE.NEXTVAL, ?, ?, ?)";
		String stockSql = "INSERT INTO TB_PART_STOCK(STOCK_SQ, PART_SQ, STOCK_AMT, IN_AMT) VALUES(SEQ_PART_STOCK.NEXTVAL, ?, ?, ?)" ;
		
		Integer partSq = null;
		Integer stockAmt = null;
		Integer inAmt = null;
		
		Connection conn = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		ResultSet rs1 = null;
		

		
		try {
			conn = DBManager.getConnection();
			pstmt1 = conn.prepareStatement(selectAmtSql);
			pstmt2 = conn.prepareStatement(deSql);
			pstmt3 = conn.prepareStatement(stockSql);
			
			//Get matSq, inAmt - Action 
			partSq = inVo.getPartSq();
			inAmt = inVo.getInAmt();
			
			//Get matSq, StockAmt - DB
			pstmt1.setInt(1, partSq);
			rs1 = pstmt1.executeQuery();
				
			if(rs1.next()) {
				stockAmt = rs1.getInt("STOCK_AMT");
				
				//Insert TB_MAT_IN_DE
				pstmt2.setInt(1, inVo.getInSq());
				pstmt2.setInt(2, partSq);
				pstmt2.setInt(3, inAmt);
				pstmt2.executeUpdate();
				
				//Insert TB_MAT_STOCK
				stockAmt = stockAmt + inAmt;
				
				pstmt3.setInt(1, partSq);
				pstmt3.setInt(2, stockAmt);
				pstmt3.setInt(3, inAmt);
				pstmt3.executeUpdate();
				
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			DBManager.closeForUpdateStock(conn, pstmt1, pstmt2, pstmt3, rs1);
		}
		
	}
			
	
	
	public MatInVO read(int inSq) {
		System.out.println("-Start Method: read");
		
		String sql = "";
		
		MatInVO mIVo = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, inSq);
			rs = pstmt.executeQuery();
		
			if (rs.next()) {
				mIVo = new MatInVO();
				mIVo.setMatSq(rs.getInt("MAT_SQ"));
				mIVo.setInAmt(rs.getInt("IN_AMT"));
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return mIVo;	
	}
	
	public List<PartPdcInVO> readDe(int inSq){
		System.out.println("-Start Method: readDe");
		
		String sqlReadDe = "SELECT A.part_sq, A.part_NM, A.PICTURE, B.IN_SQ, B.IN_AMT FROM TB_part A, TB_PART_PDC_IN_DE B WHERE B.PART_SQ = A.PART_SQ AND B.IN_SQ = ?";

		List<PartPdcInVO> selectStockList = new ArrayList<PartPdcInVO>();
		PartPdcInVO inVo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sqlReadDe);
			
			pstmt.setInt(1, inSq);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				inVo = new PartPdcInVO();
				
				inVo.setPartSq(rs.getInt("PART_SQ")); 
				inVo.setPartNm(rs.getString("PART_NM")); 
				inVo.setPicture(rs.getString("PICTURE")); 
				inVo.setInAmt(rs.getInt("IN_AMT")); 
				
				selectStockList.add(inVo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}		
		
		System.out.println("-End ");	
		
		return selectStockList;
	}
		
		
		
		
	public List<MatInVO> inListAll() {
		System.out.println("-Start Method : inListAll");
		
		String sqlList = "SELECT c.*, p1.EMP_NM FROM TB_PART_PDC_IN C, TB_EMP P1 WHERE c.emp_no = p1.emp_no ORDER BY IN_SQ DESC" ;
		String sqlCountDe = "SELECT COUNT(C.IN_SQ) AS CNT_DE FROM TB_MAT_IN_DE C, TB_MAT_IN P WHERE C.IN_SQ = P.IN_SQ AND C.IN_SQ = ?";
		MatInVO mIVo = null;
		
		List<MatInVO> list = new ArrayList<MatInVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs1 = stmt.executeQuery(sqlList);
			pstmt = conn.prepareStatement(sqlCountDe);
			
			while (rs1.next()) {
				
				 mIVo = new MatInVO();
				
				int inSq = rs1.getInt("IN_SQ");
				pstmt.setInt(1, inSq);
				rs2 = pstmt.executeQuery();
				
					if(rs2.next()) {
					mIVo.setInSq(inSq);
					mIVo.setInDt(rs1.getDate("IN_DT")); 
					mIVo.setEmpNo(rs1.getInt("EMP_NO"));
					mIVo.setEmpNm(rs1.getString("EMP_NM"));
					mIVo.setPurNm(rs1.getString("PUR_NM"));
					
					mIVo.setCntDe(rs2.getInt("CNT_DE"));
					
					list.add(mIVo);
			
					}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs1);
		}
		System.out.println("List : "+ list);
		System.out.println("-End Method");
		return list;
	}


	
}