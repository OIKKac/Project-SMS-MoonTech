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

import com.moon.sms.dto.MatBuyReqVO;
import com.moon.sms.dto.PartPdcOrdVO;
import com.moon.sms.util.DBManager;

public class PartPdcOrdDAO {

	private static PartPdcOrdDAO instance = new PartPdcOrdDAO();
	public static  PartPdcOrdDAO getInstance() {
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
	
	public int countPartPdcOrd() {
		
		String sql = "SELECT COUNT(*) " + 
				"FROM TB_PART_PDC_ORD " + 
				"WHERE ORD_FL = '0'";
		
		int count = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {				
				count = rs.getInt("COUNT(*)");								
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}	
		return count;
	}
	
	public List<PartPdcOrdVO> listAll() {
		String sql = "SELECT ppo.ORD_SQ, ppo.ORD_DT, e.EMP_NM,  " + 
				"    (SELECT COUNT(*) " + 
				"    FROM TB_PART_PDC_ORD_DE ppod " + 
				"    WHERE ppo.ORD_SQ = ppod.ORD_SQ " + 
				"    GROUP BY ppo.ORD_SQ) AS CNT " + 
				"FROM TB_PART_PDC_ORD ppo, TB_EMP e " + 
				"WHERE e.EMP_NO = ppo.EMP_NO " + 
				"AND ppo.ORD_FL = '0' " + 
				"ORDER BY ppo.ORD_SQ";
		List<PartPdcOrdVO> list = new ArrayList<PartPdcOrdVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				PartPdcOrdVO ppoVo = new PartPdcOrdVO();
				ppoVo.setOrdSq(rs.getInt("ORD_SQ"));
				ppoVo.setOrdDt(rs.getDate("ORD_DT"));
				ppoVo.setEmpNm(rs.getString("EMP_NM"));
				ppoVo.setCnt(rs.getInt("CNT"));
				list.add(ppoVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}

}
