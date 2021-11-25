package cybersoft.javabackend.java14.crm.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import cybersoft.javabackend.java14.crm.model.User;
import cybersoft.javabackend.java14.crm.servlet.UserServlet;

public class UserRepository {
	MySQLConnection connection = null;
	public static int ids = 0;
	public List<User> getUser(){
		
		List<User> users = new LinkedList<>();
		Connection  connection= null;
		try {
			connection = MySQLConnection.getConnection();
			String query = "SELECT * FROM users";
			PreparedStatement pt = connection.prepareStatement(query);
			ResultSet rs = pt.executeQuery();
			while(rs.next()) {
				User user = new User();
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				users.add(user);
			}
			
		}catch(SQLException e){
			System.out.println("Không thể kết");
			e.printStackTrace();
		}
		return users;
	}
	public void addUser(User user) {
		Connection connection = null;
		try {
			
			connection = MySQLConnection.getConnection();
			String query = "Insert into productdb.users(id,email,password,fullname,role_id) values(?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, ids++);
			statement.setString(2, user.getEmail());
			statement.setString(3, user.getPassword());
			statement.setString(4, user.getFullname());
		
			statement.setInt(5, 0);
			statement.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
