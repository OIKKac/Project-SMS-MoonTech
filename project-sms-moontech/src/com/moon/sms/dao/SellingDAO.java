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

import com.moon.sms.dto.SellingVO;
import com.moon.sms.util.DBManager;

//매입처
public class SellingDAO {
	
	private static SellingDAO instance = new SellingDAO();
	public static  SellingDAO getInstance() {
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

	public void regist(SellingVO selVo) throws Exception {
	
	String sql = "INSERT INTO TB_SELLING("
			+ "SEL_SQ, SEL_NM, REP_NM, ADDRESS, HP, EMAIL, BUNUM) "
			+ "VALUES(?, ?, ?, ?, ?, ?, ?)";
	Connection conn = null;
	PreparedStatement pstmt = null;
	try {
		conn = DBManager.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, selVo.getSelSq());
		pstmt.setString(2, selVo.getSelNm());
		pstmt.setString(4, selVo.getRepNm());
		pstmt.setString(5, selVo.getAddress());
		pstmt.setString(3, selVo.getHp());
		pstmt.setString(6, selVo.getAddress());
		pstmt.setString(8, selVo.getEmail());
		pstmt.setString(7, selVo.getBunum());
		pstmt.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		DBManager.close(conn, pstmt);
	}
}
	
	public SellingVO read(int selSq) throws Exception {
		String sql = "SELECT * FROM TB_SELLING WHERE SEL_SQ = ?";
		SellingVO selVo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, selSq);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				selVo = new SellingVO();
				selVo.setSelSq(rs.getInt("sel_Sq"));
				selVo.setSelNm(rs.getString("sel_Nm"));
				selVo.setRepNm(rs.getString("rep_Nm"));
				selVo.setAddress(rs.getString("address"));
				selVo.setHp(rs.getString("hp"));
				selVo.setEmail(rs.getString("email"));
				selVo.setBunum(rs.getString("bunum"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}		
		
		return selVo;
		
	}
	
	public void modify(SellingVO selVo) throws Exception {
	}
	
	public void delete(int selSq) throws Exception {
	}
	public List<SellingVO> listAll() {
		String sql = "SELECT * FROM TB_SELLING ORDER BY SEL_SQ DESC";
		List<SellingVO> list = new ArrayList<SellingVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				SellingVO selVo = new SellingVO();
				selVo.setSelSq(rs.getInt("sel_Sq"));
				selVo.setSelNm(rs.getString("sel_Nm"));
				selVo.setRepNm(rs.getString("rep_Nm"));
				selVo.setAddress(rs.getString("address"));
				selVo.setHp(rs.getString("hp"));
				selVo.setEmail(rs.getString("email"));
				selVo.setBunum(rs.getString("bunum"));
				list.add(selVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}
}
