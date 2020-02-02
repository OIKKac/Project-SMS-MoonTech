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
import com.moon.sms.dto.MatBuyReqVO;
import com.moon.sms.dto.MatVO;
import com.moon.sms.dto.PartBuyReqVO;
import com.moon.sms.util.DBManager;

public class MatBuyReqDAO {

	
	private static MatBuyReqDAO instance = new MatBuyReqDAO();
	public static  MatBuyReqDAO getInstance() {
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
	
	public int countMatBuyReqSq() {
		
		int count = 0;

		String sql = "SELECT COUNT(*) AS COUNT " + 
				"FROM TB_MAT_BUY_REQ " + 
				"WHERE REQ_FL = '0'";
		
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {				
				count = rs.getInt("COUNT");		
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}	
		return count;
	}
	
	public int nextvalMatBuyReqSq() {
		
		String sql = "SELECT * FROM "
					+"(SELECT REQ_SQ FROM TB_MAT_BUY_REQ ORDER BY ROWNUM DESC)" 
					+"WHERE ROWNUM = 1";
		
		Integer nextvalMatBuyReqSq = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {				
				nextvalMatBuyReqSq = (rs.getInt("REQ_SQ"));								
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}	
		return nextvalMatBuyReqSq + 1;
	}
	
	  public void regist(MatBuyReqVO mBRVo) {
		  
		  String sql = "INSERT INTO "
				  		+ "TB_MAT_BUY_REQ(REQ_SQ, EMP_NO) "
				  		+ "VALUES(? ,?)";
		  
		  Connection conn = null;
		  PreparedStatement pstmt = null;
			
		  try {
				conn = DBManager.getConnection();
				pstmt = conn.prepareStatement(sql);
			  
				pstmt.setInt(1, mBRVo.getReqSq());
				pstmt.setInt(2, mBRVo.getEmpNo());
				
				pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
				
			} finally {
				DBManager.close(conn, pstmt);
			}
	  }		  
	  
	 
	public void delete(int matSq){
		
		String sql = "DELETE TB_MAT_BUY_REQ WHERE REQ_SQ = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, matSq);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<MatBuyReqVO> listAll() {
		String sql = "SELECT mbr.REQ_SQ, mbr.REQ_DT, e.EMP_NM, " + 
				"    (SELECT COUNT(*)  " + 
				"    FROM TB_MAT_BUY_REQ_DE mbrd " + 
				"    WHERE mbr.REQ_SQ = mbrd.REQ_SQ " + 
				"    GROUP BY mbr.REQ_SQ) AS CNT " + 
				"FROM TB_MAT_BUY_REQ mbr, TB_EMP e " + 
				"WHERE e.EMP_NO = mbr.EMP_NO " + 
				"AND mbr.REQ_FL = '0' " + 
				"ORDER BY mbr.REQ_SQ";
		List<MatBuyReqVO> list = new ArrayList<MatBuyReqVO>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				MatBuyReqVO mbrVo = new MatBuyReqVO();
				mbrVo.setReqSq(rs.getInt("REQ_SQ"));
				mbrVo.setReqDt(rs.getDate("REQ_DT"));
				mbrVo.setEmpNm(rs.getString("EMP_NM"));
				mbrVo.setCnt(rs.getInt("CNT"));
				list.add(mbrVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
	}
	
	public List<MatBuyReqVO> read(int reqSq) {
		String sql = "select mbrd.req_sq, mbrd.de_sq, mbrd.req_amt, m.mat_nm  " + 
				"from tb_mat_buy_req_de mbrd, tb_mat m  " + 
				"where  m.mat_sq = mbrd.mat_sq " + 
				"and req_sq = ?";
		List<MatBuyReqVO> list = new ArrayList<MatBuyReqVO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reqSq);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				MatBuyReqVO mbrVo = new MatBuyReqVO();
				mbrVo = new MatBuyReqVO();
				mbrVo.setReqSq(rs.getInt("REQ_SQ"));
				mbrVo.setDeSq(rs.getInt("DE_SQ"));
				mbrVo.setReqAmt(rs.getInt("REQ_AMT"));
				mbrVo.setMatNm(rs.getString("MAT_NM"));
				list.add(mbrVo);
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
	
public void registIn(MatBuyReqVO reqVo) {
		
		String sql = "INSERT INTO TB_MAT_BUY_REQ(REQ_SQ, EMP_NO) VALUES(?, ?)";

		Connection conn = null;
		PreparedStatement pstmt = null;
		
	
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, reqVo.getReqSq());
			pstmt.setInt(2, reqVo.getEmpNo());
			
			pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			DBManager.close(conn, pstmt);
		}
	}

public void registDe(MatBuyReqVO reqVo) {
	
	String sql = "INSERT INTO TB_MAT_BUY_REQ_DE(DE_SQ, REQ_SQ, MAT_SQ, REQ_AMT) VALUES(SEQ_MAT_BUY_REQ_DE.NEXTVAL, ?, ?, ?)";

	Connection conn = null;
	PreparedStatement pstmt = null;
	

	try {
		conn = DBManager.getConnection();
		pstmt = conn.prepareStatement(sql);
		
		pstmt.setInt(1, reqVo.getReqSq());
		pstmt.setInt(2, reqVo.getMatNo());
		pstmt.setInt(3, reqVo.getReqAmt());
		
		pstmt.executeUpdate();
		
		
	} catch (SQLException e) {
		e.printStackTrace();
		
	} finally {
		DBManager.close(conn, pstmt);
	}
}
	
	
	
}
