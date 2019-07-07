package vn.msita.usermanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import vn.msita.usermanagement.bo.User;
import vn.msita.usermanagement.utils.ConnectionFactory;

public class UserDAO {
			
	private static User convertToUser(ResultSet rs) throws SQLException{
			User user = new User();
			user.setId(rs.getInt(1));
			user.setUserName(rs.getString(2));
			user.setPassword(rs.getString(3));
			user.setAge(rs.getInt(4));
			return user;
	}
	
	// Add user into database
	public void addUserViaPreparedStatement(User user) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String insertSQL = "INSERT INTO user (userName,password,age) VALUES (?,?,?)";
		try {
			connection = ConnectionFactory.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, user.getUserName());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setInt(3, user.getAge());
			preparedStatement.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(preparedStatement!= null) {
				try {
					preparedStatement.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(connection != null) {
				try {
					connection.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}	
	
	// Search in the database the users with the same userName entered.
	public ArrayList <User> findUserByUsername(String userName){
		Connection connection =null;
		ResultSet resultSet =null;
		PreparedStatement preparedStatement = null;
		ArrayList <User> userList = new ArrayList <User>();
		try {
			connection = ConnectionFactory.getConnection();
			String sql = "SELECT * FROM user WHERE userName = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, userName);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				userList.add(convertToUser(resultSet));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			if(resultSet != null) {
				try {
					resultSet.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(preparedStatement != null) {
				try {
					preparedStatement.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(connection != null) {
				try {
					connection.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return userList;
	}
	
	//update password
	public void updateUserPassword(String password,String userName){
		Connection connection =null;
		Statement statement = null;
		String updateSQL = "UPDATE user SET password = '"+password+"' WHERE userName = '"+userName+"'";
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			statement.execute(updateSQL);
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			
			if(statement != null) {
				try {
					statement.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(connection != null) {
				try {
					connection.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	//delete user	
	public void deleteUser(String userName){
		Connection connection =null;
		Statement statement = null;
		String deleteSQL = "DELETE u1 FROM user u1,user u2 WHERE u1.userName = u2.userName AND u1.id > u2.id";
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.createStatement();
			statement.execute(deleteSQL);
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			
			if(statement != null) {
				try {
					statement.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(connection != null) {
				try {
					connection.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
}
