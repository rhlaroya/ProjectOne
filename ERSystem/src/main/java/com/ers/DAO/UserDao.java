package com.ers.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.ers.model.User;
import com.ers.util.ConnectionUtil;

public class UserDao implements DaoContract<User> {

	@Override
	public List<String[]> getAll() {
		try {
			Connection conn = ConnectionUtil.connect();
			String sql = "select * from \"ers-users\" order by \"ers_users_id\" asc";
			List<String[]> list = new ArrayList<>();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				list.addAll((Collection<? extends String[]>) new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),
						rs.getString(5),rs.getString(6),rs.getInt(7)));
			}
			return list;
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
			
		return null;
	}

	@Override
	public User getById(int id) {
		try {
			Connection conn = ConnectionUtil.connect();
			PreparedStatement ps = conn.prepareStatement("select * from \"ers-users\" where ers_users_id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				return new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),
						rs.getString(5),rs.getString(6),rs.getInt(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int update(User t) {
		try {
			Connection conn = ConnectionUtil.connect();
			PreparedStatement ps = conn.prepareStatement("insert into \"ers-users\" (ers_users_id,ers_username,ers_password,ers_first_name,user_last_name,user_email,user_role_id) \r\n" + 
					"values (?,?,?,?,?,?,?);");
			ps.setInt(1, t.getUser_id());
			ps.setString(2, t.getUsername());
			ps.setString(3, t.getPassword());
			ps.setString(4, t.getFirst_name());
			ps.setString(5, t.getLast_name());
			ps.setString(6, t.getEmail());
			ps.setInt(7, t.getRole_id());
			int up = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
		
	}

	@Override
	public int insert(User t) throws ClassNotFoundException {
		try {
			Class.forName("org.postgresql.Driver");
	        Connection conn = DriverManager.getConnection("jdbc:postgresql://regaedb.ce8a70kibcmu.us-east-2.rds.amazonaws.com:5432/projectone","admin", "password");
			//Connection conn = ConnectionUtil.connect();
			PreparedStatement ps = conn.prepareStatement("insert into ersystem.\"ers-users\" (ers_username,ers_password,ers_first_name,user_last_name,user_email,user_role_id) values (?,?,?,?,?,?);");
			ps.setString(1, t.getUsername());
			ps.setString(2, t.getPassword());
			ps.setString(3, t.getFirst_name());
			ps.setString(4, t.getLast_name());
			ps.setString(5, t.getEmail());
			ps.setInt(6, 2);
			int ins = ps.executeUpdate();
		} catch (SQLException e) {
				e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int delete(User t) {
		try {
			Connection conn = ConnectionUtil.connect();
			PreparedStatement ps = conn.prepareStatement("delete from \"ers-users\" where reimb_id = ?");
			ps.setInt(1, t.getUser_id());
			int del = ps.executeUpdate();
		} catch (SQLException e) {
				e.printStackTrace();
		}
		return 0;
	}

}
