package com.ers.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ers.model.ReimbursementStatus;
import com.ers.util.ConnectionUtil;

public class ReimbursementStatusDao implements DaoContract<ReimbursementStatus> {

	@Override
	public List<ReimbursementStatus> getAll() {
		try {
			Connection conn = ConnectionUtil.connect();
			String sql = "select * from \"ers-reimbursement-status\" order by \"ers_status_id\" asc";
			List<ReimbursementStatus> list = new ArrayList<>();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new ReimbursementStatus(rs.getInt(1),rs.getString(2)));
			}
			return list;
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
			
		return null;
	}

	@Override
	public ReimbursementStatus getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(ReimbursementStatus t) {
		return 0;
		// TODO Auto-generated method stub
		
	}

	@Override
	public int insert(ReimbursementStatus t) {
		return 0;
		// TODO Auto-generated method stub
		
	}

	@Override
	public int delete(ReimbursementStatus t) {
		return 0;
		// TODO Auto-generated method stub
		
	}



}
