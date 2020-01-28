package com.moon.sms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.moon.sms.dto.EmpVO;
import com.moon.sms.util.DBManager;



public class EmpDAO {
	
	
	public void regist(EmpVO eVo) throws Exception {
		String sql = "INSERT INTO TB_EMP("
				+ "emp_no, emp_nm, hp, dept_sq, posi, address, picture, email, pwd) "
				+ "VALUES(9999, ?, ?, ?, ?, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, eVo.getEmpNo());
			pstmt.setString(2, eVo.getEmpNm());
			pstmt.setString(3, eVo.getHp());
			pstmt.setInt(4, eVo.getDeptSq());
			pstmt.setString(5, eVo.getPosi());
			pstmt.setString(6, eVo.getAddress());
			pstmt.setString(7, eVo.getPicture());
			pstmt.setString(8, eVo.getEmail());
			pstmt.setString(9, eVo.getPwd());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
		


	public EmpVO read(int empNo) throws Exception {
		String sql = "SELECT * FROM TB_EMP WHERE EMP_NO == ?";
		EmpVO pVo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, empNo);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				pVo = new EmpVO();
				pVo.setEmpNo(rs.getInt("empNo"));
				pVo.setEmpNm(rs.getString("empNm"));
				pVo.setHp(rs.getString("hp"));
				pVo.setDeptSq(rs.getInt("deptSq"));
				pVo.setPosi(rs.getString("posi"));
				pVo.setAddress(rs.getString("address"));
				pVo.setPicture(rs.getString("picture"));			
				pVo.setEmail(rs.getString("email"));
				pVo.setPwd(rs.getString("pwd"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}		
		
		return pVo;
		
	}

	
	public void modify(EmpVO pVo) throws Exception {
		String sql = "UPDATE TB_EMP SET "
				+ "EMP_NO = ?, EMP_NM = ?, HP = ?, DEPT_SQ = ? , POSI =?, ADDRESS = ?, picture=?, EMAIL=? , PWD=? ";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pVo.getEmpNo());
			pstmt.setString(2, pVo.getEmpNm());
			pstmt.setString(3, pVo.getHp());
			pstmt.setInt(4, pVo.getDeptSq());
			pstmt.setString(5, pVo.getPosi());
			pstmt.setString(6, pVo.getAddress());
			pstmt.setString(7, pVo.getPicture());
			pstmt.setString(8, pVo.getEmail());
			pstmt.setString(9, pVo.getPwd());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}

	}

	
	public void delete(int empNo) throws Exception {
		String sql = "delete emp_Sq where num=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, empNo);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public List<EmpVO> listAll() {
		String sql = "SELECT * FROM TB_EMP ORDER BY EMPNO DESC";
		List<EmpVO> list = new ArrayList<EmpVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				EmpVO pVo = new EmpVO();
				pVo.setEmpNo(rs.getInt("empNo"));
				pVo.setEmpNm(rs.getString("empNm"));
				pVo.setHp(rs.getString("hp"));
				pVo.setDeptSq(rs.getInt("deptSq"));
				pVo.setPosi(rs.getString("posi"));
				pVo.setAddress(rs.getString("address"));
				pVo.setPicture(rs.getString("picture"));			
				pVo.setEmail(rs.getString("email"));
				pVo.setPwd(rs.getString("pwd"));
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