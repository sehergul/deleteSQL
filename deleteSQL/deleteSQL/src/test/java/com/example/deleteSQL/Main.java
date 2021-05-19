package com.example.deleteSQL;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Main {
	public static void main(String[] args) throws SQLException {
		
		Connection connection = null;
		DbHelper dbHelper = new DbHelper();
		Statement statement= null;
		ResultSet resultSet;
		PreparedStatement preparedStatement = null;

		try {
			connection = dbHelper.getConnection();
			String sql = "delete from musteri where id=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, 13); 
			int result = preparedStatement.executeUpdate();
			System.out.println("Kayit silindi");
		}catch(SQLException sqlException) {
			dbHelper.showErrorMessage(sqlException);
		}finally {
			preparedStatement.close();
			connection.close();
		}
		
	}
}


