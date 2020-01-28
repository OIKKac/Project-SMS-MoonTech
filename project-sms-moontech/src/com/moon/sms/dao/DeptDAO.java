package com.moon.sms.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.moon.sms.dto.DeptVO;
import com.moon.sms.util.DBManager;



public class DeptDAO {


	public void regist(DeptVO dVo) throws Exception {
		String sql = "insert into tb_dept("
				+ "dept_sq, code, deptNm,) "
				+ "values(?, ?, ?,)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dVo.getDeptSq());
			pstmt.setString(2, dVo.getCode());
			pstmt.setString(3, dVo.getDeptNm());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
		


	public DeptVO read(int deptSq) throws Exception {
		String sql = "SELECT * FROM TB_DEPT WHERE DEPT_SQ == ?";
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
				dVo.setDeptSq(rs.getInt("deptSq"));
				dVo.setCode(rs.getString("code"));
				dVo.setDeptNm(rs.getString("deptNm"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}		
		
		return dVo;
		
	}

	public void modify(DeptVO dVo) throws Exception {
		String sql = "UPDATE TB_DEPT SET "
				+ "DEPT_SQ = ?, CODE = ?, DEPT_NM = ? ";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dVo.getDeptSq());
			pstmt.setString(2, dVo.getCode());
			pstmt.setString(3, dVo.getDeptNm());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}

	}


	public void delete(int deptSq) throws Exception {
		String sql = "delete tb_dept where num=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptSq);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public List<DeptVO> listAll() {
		String sql = "SELECT * FROM TB_EMP ORDER BY EMPNO DESC";
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
				dVo.setDeptSq(rs.getInt("deptSq"));
				dVo.setCode(rs.getString("code"));
				dVo.setDeptNm(rs.getString("deptNm"));				
				list.add(dVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}
}
