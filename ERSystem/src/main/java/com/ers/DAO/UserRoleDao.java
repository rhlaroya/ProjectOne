package com.ers.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.ers.model.UserRole;
import com.ers.util.ConnectionUtil;

public class UserRoleDao implements DaoContract<UserRole> {

	@Override
	public List<String[]> getAll() {
		try {
			Connection conn = ConnectionUtil.connect();
			String sql = "select * from \"ers_reimbursement-roles\" order by \"ers_users_id\" asc";
			List<String[]> list = new ArrayList<>();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				list.addAll((Collection<? extends String[]>) new UserRole(rs.getInt(1),rs.getString(2)));
			}
			return list;
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
			
		return null;
	}

	@Override
	public UserRole getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(UserRole t) {
		return 0;
		// TODO Auto-generated method stub
		
	}

	@Override
	public int insert(UserRole t) {
		return 0;
		// TODO Auto-generated method stub
		
	}

	@Override
	public int delete(UserRole t) {
		return 0;
		// TODO Auto-generated method stub
		
	}

}
