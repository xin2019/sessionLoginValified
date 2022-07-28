package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import model.User;

public  class AccessSqlite {
	private static Connection conn = null;

	public AccessSqlite() {
		try {
			if (conn == null) {
				String path = this.getClass().getClassLoader().getResource("")
						.getPath();
				path = path.substring(1, path.lastIndexOf("classes"));
				Class.forName("org.sqlite.JDBC");
				String url = "jdbc:sqlite:" + path + "login.db";
				System.out.println(url);
				conn = DriverManager.getConnection(url);
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConn() {
		if(conn==null){
			return new AccessSqlite().conn;
		}
		return conn;
	}

	public static void setConn(Connection conn) {
		AccessSqlite.conn = conn;
	}
	

}
