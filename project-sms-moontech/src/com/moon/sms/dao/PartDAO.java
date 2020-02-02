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

import com.moon.sms.dto.PartVO;
import com.moon.sms.util.DBManager;

public class PartDAO {

	private static PartDAO instance = new PartDAO();
	public static  PartDAO getInstance() {
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
	
public int nextvalPartSq() {
		
		
		String sql = "SELECT * FROM "
					+"(SELECT PART_SQ FROM TB_PART ORDER BY ROWNUM DESC) "
					+"WHERE ROWNUM = 1";
		
		Integer nextvalPartSq = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				
				nextvalPartSq = (rs.getInt("PART_SQ"));
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}		
		
		return nextvalPartSq+1;
		
	}	

		
	
	public void regist(PartVO pVo) {
		String sql = "INSERT INTO TB_PART("
				+ "PART_SQ, PART_NM, PART_SIZE, WEIGHT, picture, STAN_PRICE, PART_SQ) "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pVo.getPartSq());
			pstmt.setString(2, pVo.getPartNm());
			pstmt.setString(3, pVo.getPartSize());
			pstmt.setInt(4, pVo.getWeight());
			pstmt.setString(5, pVo.getPicture());
			pstmt.setInt(6, pVo.getStanPrice());
			pstmt.setInt(7, pVo.getPartSq());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
		


	public PartVO read(int partSq) {
		String sql = "SELECT p.part_Sq, p.part_Nm, p.part_Size, p.weight, p.picture,p.stan_Price, m.PART_SQ, m.mat_nm " + 
				"FROM TB_PART p , TB_PART m WHERE p.PART_SQ = m.PART_SQ AND PART_SQ = ?";
		PartVO pVo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, partSq);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				pVo = new PartVO();
				pVo.setPartSq(rs.getInt("part_Sq"));
				pVo.setPartNm(rs.getString("part_Nm"));
				pVo.setPartSize(rs.getString("part_Size"));
				pVo.setWeight(rs.getInt("weight"));
				pVo.setPicture(rs.getString("picture"));
				pVo.setStanPrice(rs.getInt("stan_Price"));
				pVo.setPartSq(rs.getInt("PART_SQ"));		
				pVo.setMatNm(rs.getString("mat_nm"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}		
		
		return pVo;
		
	}

	
	public void modify(PartVO pVo)  {
		String sql = "UPDATE TB_PART SET "
				+ "PART_NM = ?, PART_SIZE = ?, WEIGHT = ? , PICTURE =?, STAN_PRICE = ?, PART_SQ=? "
				+ "WHERE PART_SQ =?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pVo.getPartNm());
			pstmt.setString(2, pVo.getPartSize());
			pstmt.setInt(3, pVo.getWeight());
			pstmt.setString(4, pVo.getPicture());
			pstmt.setInt(5, pVo.getStanPrice());
			pstmt.setInt(6, pVo.getPartSq());
			pstmt.setInt(7, pVo.getPartSq());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}

	}

	
	public void delete(String partSq)  {
		String sql = "delete TB_PART where PART_SQ =?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, partSq);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public List<PartVO> listAll() {
		String sql = "SELECT * FROM TB_PART ORDER BY PART_SQ DESC";
		List<PartVO> list = new ArrayList<PartVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				PartVO pVo = new PartVO();
				pVo.setPartSq(rs.getInt("part_Sq"));
				pVo.setPartNm(rs.getString("part_Nm"));
				pVo.setPartSize(rs.getString("part_Size"));
				pVo.setWeight(rs.getInt("weight"));
				pVo.setPicture(rs.getString("picture"));
				pVo.setStanPrice(rs.getInt("stan_Price"));
				pVo.setPartSq(rs.getInt("PART_SQ"));		
				list.add(pVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}
	
	public List<PartVO> stockList(){
		List<PartVO> stockList = new ArrayList<PartVO>();
		
		String sql1 = "SELECT DISTINCT PART_SQ FROM (SELECT * FROM TB_PART_STOCK ORDER BY STOCK_SQ DESC)";
		String sql2 = "SELECT * FROM (SELECT * FROM TB_PART_STOCK ORDER BY ROWNUM DESC) A, TB_PART B WHERE A.PART_SQ = ? AND A.PART_SQ = B.PART_SQ AND ROWNUM =1";
		
		PartVO pVo = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs1 = null;
		ResultSet rs2 = null;
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs1 = stmt.executeQuery(sql1);
			pstmt = conn.prepareStatement(sql2);
			while(rs1.next()) {
				
				int matSq = rs1.getInt("PART_SQ");
			
				pstmt.setInt(1, matSq);
				
				rs2 = pstmt.executeQuery();
				
				
				pVo = new PartVO();
				if(rs2.next()) {
					
					pVo.setPartSq(rs2.getInt("PART_SQ"));
					pVo.setMatNm(rs2.getString("PART_NM"));
					pVo.setPicture(rs2.getString("PICTURE"));			
					pVo.setStockAmt(rs2.getString("STOCK_AMT"));			
					stockList.add(pVo);
				}
			}	
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.closeForStock(conn, stmt, rs1, rs2);
		}		
		
		return stockList;
		
	}
	
	
	
}