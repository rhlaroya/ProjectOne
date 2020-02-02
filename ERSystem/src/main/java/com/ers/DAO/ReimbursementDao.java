package com.ers.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
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
	
	public ArrayList<Reimbursement> getReimbEmp(int id) throws ClassNotFoundException, SQLException {
			Class.forName("org.postgresql.Driver");
	        Connection con = DriverManager.getConnection("jdbc:postgresql://regaedb.ce8a70kibcmu.us-east-2.rds.amazonaws.com:5432/projectone","admin", "password");
		ArrayList<Reimbursement> reimb = new ArrayList<>();
		try {
			PreparedStatement ps = con.prepareStatement("select *  from ersystem.\"ers-reimbursement\" join ersystem.\"ers-users\" on "
					+ "ersystem.\"ers-reimbursement\".reimb_author = ersystem.\"ers-users\".ers_users_id where reimb_author = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				reimb.add( new Reimbursement(rs.getInt(1),rs.getInt(2),rs.getTimestamp(3),rs.getTimestamp(4),
						rs.getString(5),rs.getByte(6),rs.getInt(7),rs.getInt(8),rs.getInt(9),rs.getInt(10)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return reimb;
	}

	@Override
	public int update(Reimbursement t) {
		try {
			Connection conn = ConnectionUtil.connect();
			PreparedStatement ps = conn.prepareStatement("update \"ers-reimbursement\" set \r\n" + 
					"reimb_resolved = ?, reimb_resolver = ?, reimb_status_id = ? \r\n" + 
					"where reimb_id = ?;");
			
			ps.setTimestamp(1, t.getResolved());
			ps.setInt(2, t.getResolver());
			ps.setInt(3, t.getStatus_id());
			ps.setInt(4, t.getId());
			System.out.println(t.getSubmitted());
			System.out.println(t.getResolved());
			int up = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int insert(Reimbursement t) throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://regaedb.ce8a70kibcmu.us-east-2.rds.amazonaws.com:5432/projectone","admin", "password");
		try {
			System.out.println(t);
			Connection conn = ConnectionUtil.connect();
			PreparedStatement ps = conn.prepareStatement("insert into ersystem.\"ers-reimbursement\" (\"reimb_amount\", \"reimb_submitted\", \"reimb_description\", \"reimb_author\", \"reimb_status_id\", \"reimb_type_id\") values (?,?,?,?,?,?)");
			ps.setInt(1, t.getAmount());
			ps.setTimestamp(2, t.getSubmitted());
			ps.setString(3,t.getDescription());
			ps.setInt(4, t.getAuthor());
			ps.setInt(5, t.getStatus_id());
			ps.setInt(6, t.getType_id());
			ps.execute();
		} catch (SQLException e) {
				e.printStackTrace();
		}
		return 0;
			
	}

//	int amount, Timestamp time, String description, int id, int status, int type 
		

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
