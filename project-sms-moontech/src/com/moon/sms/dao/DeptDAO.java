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

import com.moon.sms.dto.DeptVO;
import com.moon.sms.util.DBManager;



public class DeptDAO {

	private static DeptDAO instance = new DeptDAO();
	public static  DeptDAO getInstance() {
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
	
	

	public void regist(DeptVO dVo)  {
		String sql = "insert into tb_dept("
				+ "dept_Sq, dept_Nm) "
				+ "values(seq_dept.nextval,  ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dVo.getDeptNm());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
		


	public DeptVO read(int deptSq)  {
		String sql = "SELECT * FROM TB_DEPT WHERE DEPT_SQ = ?";
		DeptVO dVo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptSq);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dVo = new DeptVO();
				dVo.setDeptSq(rs.getInt("dept_Sq"));
				dVo.setDeptNm(rs.getString("dept_Nm"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}		
		
		return dVo;
		
	}

	public void modify(DeptVO dVo) {
		String sql = "UPDATE TB_DEPT SET "
				+ " DEPT_NM = ? " + "WHERE DEPT_SQ=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dVo.getDeptNm());
			pstmt.setInt(2, dVo.getDeptSq());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}

	}


	public void delete(String deptSq)  {
		String sql = "delete tb_dept where dept_sq=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, deptSq);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public List<DeptVO> listAll() {
		String sql = "SELECT * FROM TB_DEPT ORDER BY DEPT_SQ DESC";
		List<DeptVO> list = new ArrayList<DeptVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				DeptVO dVo = new DeptVO();
				dVo.setDeptSq(rs.getInt("dept_Sq"));
				dVo.setDeptNm(rs.getString("dept_Nm"));				
				list.add(dVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}
	
	public List<DeptVO> selectDeptNm(String deptNm) {
		String sql = "select * from tb_dept where dept_nm like '%"+deptNm+"%'";
		List<DeptVO> list = new ArrayList<DeptVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, deptNm);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				DeptVO dVo = new DeptVO();
				dVo.setDeptSq(rs.getInt("dept_Sq"));
				dVo.setDeptNm(rs.getString("dept_Nm"));				
				list.add(dVo);			
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return list;
	}
	
}
