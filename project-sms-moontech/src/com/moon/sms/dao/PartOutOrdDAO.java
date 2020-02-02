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

import com.moon.sms.dto.PartOutOrdVO;
import com.moon.sms.dto.PartOutVO;
import com.moon.sms.dto.PartPdcOrdVO;
import com.moon.sms.util.DBManager;

public class PartOutOrdDAO {

	private static PartOutOrdDAO instance = new PartOutOrdDAO();
	public static  PartOutOrdDAO getInstance() {
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
	
	public int countPartOutOrd() {
		
		String sql = "SELECT COUNT(*) AS CNT  " + 
				"FROM TB_PART_OUT_ORD  " + 
				"WHERE ORD_FL = '0' ";
		
		int count = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {				
				count = rs.getInt("CNT");								
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}	
		return count;
	}

	public List<PartOutOrdVO> listAll() {
		String sql = "SELECT poo.ORD_SQ, poo.ORD_DT, s.SEL_NM, e.EMP_NM,  " + 
				"    (SELECT COUNT(*) " + 
				"    FROM TB_PART_OUT_ORD_DE pood " + 
				"    WHERE poo.ORD_SQ = pood.ORD_SQ " + 
				"    GROUP BY poo.ORD_SQ) AS CNT " + 
				"FROM TB_PART_OUT_ORD poo, TB_SELLING s, TB_EMP e " + 
				"WHERE e.EMP_NO = poo.EMP_NO " + 
				"AND poo.ORD_FL = '0' " + 
				"AND s.SEL_SQ = poo.SEL_SQ";
		List<PartOutOrdVO> list = new ArrayList<PartOutOrdVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				PartOutOrdVO pooVo = new PartOutOrdVO();
				pooVo.setOrdSq(rs.getInt("ORD_SQ"));
				pooVo.setOrdDt(rs.getDate("ORD_DT"));
				pooVo.setSelNm(rs.getString("SEL_NM"));
				pooVo.setEmpNm(rs.getString("EMP_NM"));
				pooVo.setCnt(rs.getInt("CNT"));
				list.add(pooVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}
	
}
