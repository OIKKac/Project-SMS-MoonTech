package com.moon.sms.dao;



import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.moon.sms.dto.MatVO;


public class MatDAO {
	
	
	private static MatDAO instance = new MatDAO();
	public static  MatDAO getInstance() {
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
	
	public void regist(MatVO mVo) throws Exception{
		
		String sql = "INSERT INTO TB_MAT(MAT_SQ, MAT_NM, MAT_SIZE, STAN_PRICE, WEIGHT, PICTURE) "
				+ "VALUES(?, ?, ? , ?, ?, ?)";
		
		getParameter("MAT_SQ");
		
		W
		
	}
		
	
	public MatVO read(int matSq) throws Exception{
		
		String sql = "SELECT * FROM TB_MAT WHERE MAT_SQ == ?";
		
	}
	
	public void modify(MatVO mVo) throws Exception{
		
		String sql = "UPDATE TB_MAT SET MAT_SQ = ?, MAT_NM = ?, MAT_SIZE = ?, STAN_PRICE = ? WEIGHT =?, PIRCTURE = ?";
		
	}
	
	public void delete(int matSq) throws Exception{
		
	}
	
}
