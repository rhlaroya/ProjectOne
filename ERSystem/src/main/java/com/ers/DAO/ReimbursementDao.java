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
	public List<String[]> getAll() {
		List<String[]> list = new ArrayList<>();
		try {
			Connection conn = ConnectionUtil.connect();
			String sql = "select reimb_id, reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_type, reimb_status, concat(ers_first_name,\' \',user_last_name)  as name, (select concat(ers_first_name,' ',user_last_name) from \"ers-users\" join \"ers_reimbursement-roles\" on ers_users_id = ers_user_role_id where user_role_id = 1) from ersystem.\"ers-reimbursement\" join ersystem.\"ers-users\" on "
					+ "ersystem.\"ers-reimbursement\".reimb_author = ersystem.\"ers-users\".ers_users_id join ersystem.\"ers-reimbursement-status\" on ersystem.\"ers-reimbursement-status\".reimb_status_id = ersystem.\"ers-reimbursement\".reimb_status_id"
					+ " join ersystem.\"ers-reimbursement-type\" on ersystem.\"ers-reimbursement-type\".reimb_type_id = ersystem.\"ers-reimbursement\".reimb_type_id";
			
		
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String[] p = new String[10];
				p[0] = Integer.toString(rs.getInt(1));
				p[1] = Integer.toString(rs.getInt(2));
				p[2] = rs.getString(3);
				p[3] = rs.getString(4);
				p[4] = rs.getString(5);
				p[5] = rs.getString(6);
				p[6] = rs.getString(7);
				p[7] = rs.getString(8);
				p[8] = rs.getString(9);
				
				list.add(p);
			}
			return list;
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
			
		return list;
	}

	@Override
	public Reimbursement getById(int id) {
		try {
			Connection conn = ConnectionUtil.connect();
			PreparedStatement ps = conn.prepareStatement("select reimb_id, reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_type, reimb_status, reimb_resolver  from ersystem.\"ers-reimbursement\" join ersystem.\"ers-users\" on "
					+ "ersystem.\"ers-reimbursement\".reimb_author = ersystem.\"ers-users\".ers_users_id join ersystem.\"ers-reimbursement-status\" on ersystem.\"ers-reimbursement-status\".reimb_status_id = ersystem.\"ers-reimbursement\".reimb_status_id"
					+ " join ersystem.\"ers-reimbursement-type\" on ersystem.\"ers-reimbursement-type\".reimb_type_id = ersystem.\"ers-reimbursement\".reimb_status_id where reimb_author = ?");
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
	
	public ArrayList<String[]> getReimbEmp(int id) throws ClassNotFoundException, SQLException {
			Class.forName("org.postgresql.Driver");
	        Connection con = DriverManager.getConnection("jdbc:postgresql://regaedb.ce8a70kibcmu.us-east-2.rds.amazonaws.com:5432/projectone","admin", "password");
		ArrayList<String[]> reimb = new ArrayList<>();
		
		try {
	
			PreparedStatement ps = con.prepareStatement("select reimb_id, reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_type, reimb_status, reimb_resolver  from ersystem.\"ers-reimbursement\" join ersystem.\"ers-users\" on "
					+ "ersystem.\"ers-reimbursement\".reimb_author = ersystem.\"ers-users\".ers_users_id join ersystem.\"ers-reimbursement-status\" on ersystem.\"ers-reimbursement-status\".reimb_status_id = ersystem.\"ers-reimbursement\".reimb_status_id"
					+ " join ersystem.\"ers-reimbursement-type\" on ersystem.\"ers-reimbursement-type\".reimb_type_id = ersystem.\"ers-reimbursement\".reimb_type_id where reimb_author = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String[] arr = new String[10];
				/**
				reimb.add( new Reimbursement(rs.getInt(1),rs.getInt(2),rs.getTimestamp(3),rs.getTimestamp(4),
						rs.getString(5),rs.getByte(6),rs.getInt(7),rs.getInt(8),rs.getInt(9),rs.getInt(10)));
						*/
				arr[0] = Integer.toString(rs.getInt(1));
				arr[1] = Integer.toString(rs.getInt(2));
				
				//SimpleDateFormat dateFormatSub = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
				//String string  = dateFormatSub.format(new Date());

				arr[2] = rs.getString(3);
				arr[3] = rs.getString(4);
				arr[4] = rs.getString(5);
				arr[5] = rs.getString(6);
				arr[6] = rs.getString(7);
				arr[7] = Integer.toString(8);
				
				reimb.add(arr);
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
