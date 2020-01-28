package com.moon.sms.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.moon.sms.dao.DeptDAO;
import com.moon.sms.dto.DeptVO;
import com.moon.sms.util.DBManager;

public class DeptDAOImpl  implements DeptDAO{



	@Override
	public void regist(DeptVO dVo) throws Exception {
		String sql = "insert into tb_dept("
				+ "dept_sq, code, deptNm,) "
				+ "values(9999, ?, ?,)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dVo.getDeptSq());
			pstmt.setString(2, dVo.getCode());
			pstmt.setString(3, dVo.getDeptNm());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
		

	@Override
	public DeptVO read(int deptSq) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modify(DeptVO dVo) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
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

}
