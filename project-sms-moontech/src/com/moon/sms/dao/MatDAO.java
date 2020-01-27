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
		
		String sql = "INSERT INTO TB_MAT VALUES(
	}
		
	
	public MatVO read(int matSq) throws Exception{
		
	}
	
	public void modify(MatVO mVo) throws Exception{
		
	}
	
	public void delete(int matSq) throws Exception{
		
	}
	
}
