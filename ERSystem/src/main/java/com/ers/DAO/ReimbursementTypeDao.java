package com.ers.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ers.model.ReimbursementType;
import com.ers.util.ConnectionUtil;

public class ReimbursementTypeDao implements DaoContract<ReimbursementType> {

	@Override
	public List<ReimbursementType> getAll() {
		try {
			Connection conn = ConnectionUtil.connect();
			String sql = "select * from \"ers-reimbursement-type\" order by \"ers_type_id\" asc";
			List<ReimbursementType> list = new ArrayList<>();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new ReimbursementType(rs.getInt(1),rs.getString(2)));
			}
			return list;
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
			
		return null;
	}

	@Override
	public ReimbursementType getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(ReimbursementType t) {
		return 0;
		// TODO Auto-generated method stub
		
	}

	@Override
	public int insert(ReimbursementType t) {
		return 0;
		// TODO Auto-generated method stub
		
	}

	@Override
	public int delete(ReimbursementType t) {
		return 0;
		// TODO Auto-generated method stub
		
	}

}
