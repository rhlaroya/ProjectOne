package com.ers.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import jdbc.util.config.plain.PlainTextConfig;

public class ConnectionUtil {
	
	public static Connection connect() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(PlainTextConfig.getUrl(),
					PlainTextConfig.getUsername(), PlainTextConfig.getPassword());
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
