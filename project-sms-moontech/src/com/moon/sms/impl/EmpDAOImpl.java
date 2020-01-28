package com.moon.sms.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.moon.sms.dao.EmpDAO;
import com.moon.sms.dto.EmpVO;
import com.moon.sms.util.DBManager;

public class EmpDAOImpl implements EmpDAO{



	@Override
	public void regist(EmpVO eVo) throws Exception {
		String sql = "insert into tb_emp("
				+ "emp_no, emp_nm, hp, dept_sq, posi, address, picture, email, pwd) "
				+ "values(9999, ?, ?, ?, ?, ?, ?, ?, ?)";
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
		

	@Override
	public EmpVO read(int empSq) throws Exception {
		String sql = "select * from tb_emp where empSq?";
		return null;
	}

	@Override
	public void modify(EmpVO dVo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int empSq) throws Exception {
		String sql = "delete empSq where num=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, empSq);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
	}


