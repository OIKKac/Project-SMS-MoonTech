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

import com.moon.sms.dto.PartBuyReqVO;
import com.moon.sms.dto.PartPdcOrdVO;
import com.moon.sms.util.DBManager;

public class PartBuyReqDAO {

	private static PartBuyReqDAO instance = new PartBuyReqDAO();
	public static  PartBuyReqDAO getInstance() {
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
	
	public int countPartBuyReq() {
		
		String sql = "SELECT COUNT(*) AS CNT " + 
				"FROM TB_PART_BUY_REQ " + 
				"WHERE REQ_FL = '0'";
		
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

	public List<PartBuyReqVO> listAll() {
		String sql = "SELECT pbr.REQ_SQ, pbr.REQ_DT, e.EMP_NM,  " + 
				"    (SELECT COUNT(*) " + 
				"    FROM TB_PART_BUY_REQ_DE pbrd " + 
				"    WHERE pbr.REQ_SQ = pbrd.REQ_SQ " + 
				"    GROUP BY pbr.REQ_SQ) AS CNT " + 
				"FROM TB_PART_BUY_REQ pbr, TB_EMP e " + 
				"WHERE e.EMP_NO = pbr.EMP_NO " + 
				"AND pbr.REQ_FL = '0' " + 
				"ORDER BY pbr.REQ_SQ";
		List<PartBuyReqVO> list = new ArrayList<PartBuyReqVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				PartBuyReqVO pbrVo = new PartBuyReqVO();
				pbrVo.setReqSq(rs.getInt("REQ_SQ"));
				pbrVo.setReqDt(rs.getDate("REQ_DT"));
				pbrVo.setEmpNm(rs.getString("EMP_NM"));
				pbrVo.setCnt(rs.getInt("CNT"));
				list.add(pbrVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}

	
}
