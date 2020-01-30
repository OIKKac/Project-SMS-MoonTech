package com.moon.sms.dao;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.moon.sms.dto.MatInVO;


public class MatInDAO {
	
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
	
	public void regist(MatInVO mIVo) {
		
	}
	
	public MatInVO read(int inSq) {
		
		
		return MatInVO;
	}

	public void delete(int inSq) {
		
	}
	
   



	
}
