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

import com.moon.sms.dto.MatVO;
import com.moon.sms.util.DBManager;



public class MatDAO {
	
	
	private static MatDAO instance = new MatDAO();
	public static  MatDAO getInstance() {
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
	
	public void regist(MatVO mVo) {
		
		String sql = "INSERT INTO TB_MAT("
				+ "MAT_SQ, MAT_NM, MAT_SIZE, STAN_PRICE, WEIGHT, PICTURE) "
				+ "VALUES(mat_seq.netval, ?, ? , ?, ?, ?)";
		
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, mVo.getMatSq());
			pstmt.setString(2, mVo.getMatNm());
			pstmt.setString(3, mVo.getMatSize());
			pstmt.setString(4, mVo.getStanPrice());
			pstmt.setString(5, mVo.getWeight());
			pstmt.setString(6, mVo.getPicture());
			pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			DBManager.close(conn, pstmt);
		}
		
	}
		
	
	public MatVO read(int matSq){
		
		String sql = "SELECT * FROM TB_MAT WHERE MAT_SQ = ?";
		MatVO mVo = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, matSq);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				mVo = new MatVO();
				mVo.setMatSq(rs.getInt("MAT_SQ"));
				mVo.setMatNm(rs.getString("MAT_NM"));
				mVo.setMatSize(rs.getString("MAT_SIZE"));
				mVo.setStanPrice(rs.getString("STAN_PRICE"));
				mVo.setWeight(rs.getString("WEIGHT"));
				mVo.setPicture(rs.getString("PICTURE"));				
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}		
		
		return mVo;
		
	}
	
	public void modify(MatVO mVo){

		Connection conn = null;
		PreparedStatement pstmt = null;		
		
		
		String sql = "UPDATE TB_MAT SET "
				+ "MAT_NM = ?, MAT_SIZE = ?, STAN_PRICE = ? WEIGHT =?, PICTURE = ?"
				+ "WHERE MAT_SQ = ?" ;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);			
			
			pstmt.setString(1, mVo.getMatNm());
			pstmt.setString(2, mVo.getMatSize());
			pstmt.setString(3, mVo.getStanPrice());
			pstmt.setString(4, mVo.getWeight());
			pstmt.setString(5, mVo.getPicture());
			pstmt.setInt(6, mVo.getMatSq());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		

	}		
		
		

	
	public void delete(int matSq){
		String sql = "DELETE TB_MAT WHERE MAT_SQ = ?";
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
	
	public List<MatVO> listAll() {
		String sql = "SELECT * FROM TB_MAT ORDER BY MAT_SQ DESC";
		List<MatVO> list = new ArrayList<MatVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				MatVO mVo = new MatVO();
				mVo.setMatSq(rs.getInt("MAT_SQ"));
				mVo.setMatNm(rs.getString("MAT_NM"));
				mVo.setMatSize(rs.getString("MAT_SIZE"));
				mVo.setStanPrice(rs.getString("STAN_PRICE"));
				mVo.setWeight(rs.getString("WEIGHT"));
				mVo.setPicture(rs.getString("PICTURE"));	
				
				list.add(mVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}
	
	

	
	
}
