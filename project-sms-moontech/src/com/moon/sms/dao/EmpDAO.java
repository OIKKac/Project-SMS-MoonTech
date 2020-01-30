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

import com.moon.sms.dto.EmpVO;
import com.moon.sms.util.DBManager;



public class EmpDAO {
	
	private static EmpDAO instance = new EmpDAO();
	public static  EmpDAO getInstance() {
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
	
	
	public void regist(EmpVO eVo) {
		String sql = "INSERT INTO TB_EMP("
				+ "emp_no, emp_nm, hp, dept_sq, posi, address, picture, email, pwd) "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
		


	public EmpVO read(int empNo) {
		String sql = "SELECT * FROM TB_EMP WHERE EMP_NO = ?";
		EmpVO eVo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, empNo);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				eVo = new EmpVO();
				eVo.setEmpNo(rs.getInt("emp_No"));
				eVo.setEmpNm(rs.getString("emp_Nm"));
				eVo.setHp(rs.getString("hp"));
				eVo.setDeptSq(rs.getInt("dept_Sq"));
				eVo.setPosi(rs.getString("posi"));
				eVo.setAddress(rs.getString("address"));
				eVo.setPicture(rs.getString("picture"));			
				eVo.setEmail(rs.getString("email"));
				eVo.setPwd(rs.getString("pwd"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}		
		
		return eVo;
		
	}

	
	public void modify(EmpVO eVo)  {
		String sql = "UPDATE TB_EMP SET "
				+ "EMP_NM = ?, HP = ?, DEPT_SQ = ? , POSI =?, ADDRESS = ?, picture=?, EMAIL=? , PWD=? "
				+ "WHERE EMP_NO =?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, eVo.getEmpNm());
			pstmt.setString(2, eVo.getHp());
			pstmt.setInt(3, eVo.getDeptSq());
			pstmt.setString(4, eVo.getPosi());
			pstmt.setString(5, eVo.getAddress());
			pstmt.setString(6, eVo.getPicture());
			pstmt.setString(7, eVo.getEmail());
			pstmt.setString(8, eVo.getPwd());
			pstmt.setInt(9, eVo.getEmpNo());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}

	}

	
	public void delete(String empNo)  {
		String sql = "delete TB_EMP where EMP_NO =?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, empNo);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public List<EmpVO> listAll() {
		String sql = "SELECT * FROM TB_EMP ORDER BY EMP_NO DESC";
		List<EmpVO> list = new ArrayList<EmpVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				EmpVO eVo = new EmpVO();
				eVo.setEmpNo(rs.getInt("EMP_NO"));
				eVo.setEmpNm(rs.getString("EMP_NM"));
				eVo.setHp(rs.getString("HP"));
				eVo.setDeptSq(rs.getInt("DEPT_SQ"));
				eVo.setPosi(rs.getString("POSI"));
				eVo.setAddress(rs.getString("ADDRESS"));
				eVo.setPicture(rs.getString("PICTURE"));			
				eVo.setEmail(rs.getString("EMAIL"));
				eVo.setPwd(rs.getString("PWD"));
				list.add(eVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}
	public int userCheck(int empNo, String pwd){
		int result = -1;
		String sql = "select pwd from tb_emp where emp_No=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, empNo);
			rs = pstmt.executeQuery();
			if(rs.next()){
				if(rs.getString("pwd")!=null && rs.getString("pwd").equals(pwd)){
					result = 1;
				} else {
					result = 0;
				}
			} else{
				result = -1;
			}
		} catch (Exception e){
			e.printStackTrace();
		}finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	public EmpVO getEmp(int empNo){
		EmpVO eVo = null;
		String sql = "select * from tb_emp where emp_No=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, empNo);
			rs = pstmt.executeQuery();
			if (rs.next()){
				eVo = new EmpVO();
				eVo.setEmpNo(rs.getInt("emp_No"));
				eVo.setEmpNm(rs.getString("emp_Nm"));
				eVo.setHp(rs.getString("hp"));
				eVo.setDeptSq(rs.getInt("dept_Sq"));
				eVo.setPosi(rs.getString("posi"));
				eVo.setAddress(rs.getString("address"));
				eVo.setPicture(rs.getString("picture"));
				eVo.setEmail(rs.getString("email"));
				eVo.setPwd(rs.getString("pwd"));
			}
		} catch (Exception e){
			e.printStackTrace();
		} finally{
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
		return eVo;
	}
		
	}