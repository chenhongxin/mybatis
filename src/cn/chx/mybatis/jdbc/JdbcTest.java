package cn.chx.mybatis.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcTest {

	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis?characterEncoding=utf-8", "root", "root");
			String sql = "select * from user where username = ?";
			statement = connection.prepareStatement(sql);
			statement.setString(1, "ÍõÎå");
			resultSet = statement.executeQuery();
			while(resultSet.next()){
				System.out.println(resultSet.getString("id") + "-" + resultSet.getString("username"));
			}
		} catch (Exception e) {
			
		}finally {
			try {
				if(connection != null){
					connection.close();
				}
				if(statement != null){
					statement.close();
				}
				if(resultSet != null){
					resultSet.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
