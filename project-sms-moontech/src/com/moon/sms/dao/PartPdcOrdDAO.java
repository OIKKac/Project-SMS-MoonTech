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
	
	public int nextvalPartPdcOrdSq() {
		
		String sql = "SELECT * FROM "
					+"(SELECT ORD_SQ FROM TB_PART_PDC_ORD ORDER BY ROWNUM DESC)" 
					+"WHERE ROWNUM = 1";
		
		Integer nextvalPartPdcOrdSq = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {				
				nextvalPartPdcOrdSq = (rs.getInt("ORD_SQ"));								
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}	
		return nextvalPartPdcOrdSq + 1;
	}
	
	
public void registIn(PartPdcOrdVO ordVo) {
		
		String sql = "INSERT INTO TB_PART_PDC_ORD(ORD_SQ, EMP_NO) VALUES(?, ?)";

		Connection conn = null;
		PreparedStatement pstmt = null;
		
	
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, ordVo.getOrdSq());
			pstmt.setInt(2, ordVo.getEmpNo());
			
			pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			DBManager.close(conn, pstmt);
		}
	}
	

public void registDe(PartPdcOrdVO ordVo2) {
	
	String sql = "INSERT INTO TB_PART_PDC_ORD_DE(DE_SQ, REQ_SQ, PART_SQ, ORD_AMT) VALUES(SEQ_PART_PDC_ORD_DE.NEXTVAL, ?, ?, ?)";

	Connection conn = null;
	PreparedStatement pstmt = null;
	

	try {
		conn = DBManager.getConnection();
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, ordVo2.getOrdSq());
		pstmt.setInt(2, ordVo2.getPartSq());
		pstmt.setInt(3, ordVo2.getOrdAmt());
		
		pstmt.executeUpdate();
		
		
	} catch (SQLException e) {
		e.printStackTrace();
		
	} finally {
		DBManager.close(conn, pstmt);
	}
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
	public List<PartPdcOrdVO> read(int ordSq) {
		String sql = "sSELECT O.ORD_SQ, O.DE_SQ, O.ORD_AMT, P.PART_NM FROM TB_PART_PDC_ORD_DE O, TB_PART P WHERE P.PART_SQ = O.PART_SQ AND O.ORD_SQ = ?";
		List<PartPdcOrdVO> list = new ArrayList<PartPdcOrdVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ordSq);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				PartPdcOrdVO ordVo = new PartPdcOrdVO();
				
				ordVo.setOrdSq(rs.getInt("ORD_SQ"));
				ordVo.setDeSq(rs.getInt("DE_SQ"));
				ordVo.setOrdAmt(rs.getInt("ORD_AMT"));
				ordVo.setPartNm(rs.getString("PART_NM"));
				
				list.add(ordVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return list;
	}
	
	public void modify(MatBuyReqVO mbrVo){

		Connection conn = null;
		PreparedStatement pstmt = null;		
		
		String sql = "update tb_mat_buy_req_de " + 
				"set req_amt = ? " + 
				"where de_sq= ? ";

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);			
			
			pstmt.setInt(1, mbrVo.getReqAmt());
			pstmt.setInt(2, mbrVo.getDeSq());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

}
