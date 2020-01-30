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
				+ "PART_SQ, PART_NM, PART_SIZE, STAN_PRICE, WEIGHT, PICTURE, MAT_SQ) "
				+ "VALUES(?, ?, ? , ?, ?, ?)";
		
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, pVo.getPartSq());
			pstmt.setString(2, pVo.getPartNm());
			pstmt.setString(3, pVo.getPartSize());
			pstmt.setString(4, pVo.getStanPrice());
			pstmt.setString(5, pVo.getWeight());
			pstmt.setString(6, pVo.getPicture());
			pstmt.setInt(7, pVo.getMatSq());
			pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			DBManager.close(conn, pstmt);
		}
		
	}
		
	
	public PartVO read(int partSq){
		
		String sql = "SELECT * FROM TB_PART WHERE PART_SQ = ?";
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
				pVo.setPartSq(rs.getInt("PART_SQ"));
				pVo.setPartNm(rs.getString("PART_NM"));
				pVo.setPartSize(rs.getString("PART_SIZE"));
				pVo.setStanPrice(rs.getString("STAN_PRICE"));
				pVo.setWeight(rs.getString("WEIGHT"));
				pVo.setPicture(rs.getString("PICTURE"));				
				pVo.setMatSq(rs.getInt("MAT_SQ"));				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}		
		
		return pVo;
		
	}
	
	public void modify(PartVO pVo){

		Connection conn = null;
		PreparedStatement pstmt = null;		
		
		
		
		String sql = "UPDATE TB_PART SET " 
					+"PART_NM = ?, PART_SIZE = ?, STAN_PRICE = ?, WEIGHT = ?, picture = ?, MAT_SQ = ? "
					+"WHERE PART_SQ = ?";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);			
			
			pstmt.setString(1, pVo.getPartNm());
			pstmt.setString(2, pVo.getPartSize());
			pstmt.setString(3, pVo.getStanPrice());
			pstmt.setString(4, pVo.getWeight());
			pstmt.setString(5, pVo.getPicture());
			pstmt.setInt(6, pVo.getMatSq());
			pstmt.setInt(7, pVo.getPartSq());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		

	}		
		
		

	
	public void delete(int partSq){
		String sql = "DELETE TB_PART WHERE PART_SQ = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, partSq);
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
				pVo.setPartSq(rs.getInt("PART_SQ"));
				pVo.setPartNm(rs.getString("PART_NM"));
				pVo.setPartSize(rs.getString("PART_SIZE"));
				pVo.setStanPrice(rs.getString("STAN_PRICE"));
				pVo.setWeight(rs.getString("WEIGHT"));
				pVo.setPicture(rs.getString("PICTURE"));	
				pVo.setMatSq(rs.getInt("MAT_SQ"));	
				
				list.add(pVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}
	
	

	
	
}
