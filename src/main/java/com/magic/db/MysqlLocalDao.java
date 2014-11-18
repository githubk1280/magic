package com.magic.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MysqlLocalDao {
	public static Connection getLocalConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:" + 3306
					+ "/test", "root", "");
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			
		}
	}
	
	final static String INSERT_SQL = "INSERT INTO test.kuai3 (termId,num1,num2,num3,sum,time) VALUES(%d,%d,%d,%d,%d,%s)";
	public static void insert163(int [] nums,Date time,int termId) throws SQLException{
		Connection conn = getLocalConnection();
		String sql = String.format(INSERT_SQL, termId,nums[0],nums[1],nums[2],(nums[0]+nums[1]+nums[2]),getDate(time));
		System.out.println(sql);
		PreparedStatement psmt = conn.prepareStatement(sql);
		psmt.execute();
		
	}
	private static String getDate(Date time) {
		return new SimpleDateFormat("yyyyMMdd").format(time);
	}
}
