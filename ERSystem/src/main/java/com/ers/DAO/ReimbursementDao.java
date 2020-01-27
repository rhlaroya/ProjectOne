package com.ers.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ers.model.Reimbursement;
import com.ers.util.ConnectionUtil;

public class ReimbursementDao implements DaoContract<Reimbursement> {

	@Override
	public List<Reimbursement> getAll() {
		try {
			Connection conn = ConnectionUtil.connect();
			String sql = "select * from \"ers-reimbursement\" order by \"reimb_id\" asc";
			List<Reimbursement> list = new ArrayList<>();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new Reimbursement(rs.getInt(1),rs.getInt(2),rs.getTimestamp(3),rs.getTimestamp(4),
						rs.getString(5),rs.getByte(6),rs.getInt(7),rs.getInt(8),rs.getInt(9),rs.getInt(10)));
			}
			return list;
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
			
		return null;
	}

	@Override
	public Reimbursement getById(int id) {
		try {
			Connection conn = ConnectionUtil.connect();
			PreparedStatement ps = conn.prepareStatement("select * from \"ers-reimbursement\" where reimb_id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				return new Reimbursement(rs.getInt(1),rs.getInt(2),rs.getTimestamp(3),rs.getTimestamp(4),
						rs.getString(5),rs.getByte(6),rs.getInt(7),rs.getInt(8),rs.getInt(9),rs.getInt(10));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int update(Reimbursement t) {
		try {
			Connection conn = ConnectionUtil.connect();
			PreparedStatement ps = conn.prepareStatement("update \"ers-reimbursement\" set reimb_amount = ?, reimb_submitted = ?, reimb_resolved = ?,\r\n" + 
					"reimb_description = ?, reimb_receipt = ?, reimb_author = ?, reimb_resolved = ?, reimb_resolver = ?, reimb_status_id = ?,\r\n" + 
					"reimb_type_id = ? where reimb_id = ?;");
			ps.setInt(1, t.getAmount());
			ps.setTimestamp(2, t.getSubmitted());
			ps.setTimestamp(3, t.getResolved());
			ps.setString(4,t.getDescription());
			ps.setByte(5, t.getReceipt());
			ps.setInt(6, t.getAuthor());
			ps.setTimestamp(7, t.getResolved());
			ps.setInt(8, t.getResolver());
			ps.setInt(9, t.getStatus_id());
			ps.setInt(10, t.getType_id());
			int up = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int insert(Reimbursement t) {
		try {

			Connection conn = ConnectionUtil.connect();
			PreparedStatement ps = conn.prepareStatement("insert into \"ers-reimbursement\" values (?,?,?,?,?,?,?,?,?,?);");
			ps.setInt(1, t.getId());
			ps.setInt(2, t.getAmount());
			ps.setTimestamp(3, t.getSubmitted());
			ps.setTimestamp(4, t.getResolved());
			ps.setString(5,t.getDescription());
			ps.setByte(6, t.getReceipt());
			ps.setInt(7, t.getAuthor());
			ps.setTimestamp(8, t.getResolved());
			ps.setInt(8, t.getResolver());
			ps.setInt(9, t.getStatus_id());
			ps.setInt(10, t.getType_id());
			int ins = ps.executeUpdate();
		} catch (SQLException e) {
				e.printStackTrace();
		}
		return 0;
			
	}
		

	@Override
	public int delete(Reimbursement t) {
		try {
			Connection conn = ConnectionUtil.connect();
			PreparedStatement ps = conn.prepareStatement("delete from \"ers-reimbursement\" where reimb_id = ?");
			ps.setInt(1, t.getId());
			int del = ps.executeUpdate();
		} catch (SQLException e) {
				e.printStackTrace();
		}
		return 0;
		
	}

}
