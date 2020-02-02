package com.ers.ERSystem;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import com.ers.DAO.ReimbursementDao;



/**
 * DAO Tester!
 *
 */
public class App 
{
    public static void main( String[] args ) throws NoSuchAlgorithmException, ClassNotFoundException, SQLException
    {
//    	User usr = new User();
//		List<User> list = usr.getList();
//		String liststr = list.toString().replace(",", "");
//		System.out.println(liststr);
    	
//    	ReimbursementDao rd = new ReimbursementDao();
//    	rd.getById(2);
    	
    	ReimbursementDao rd = new ReimbursementDao();
    	System.out.println(rd.getReimbEmp(2));

//    	ReimbursementDao r = new ReimbursementDao();
//    	List<Reimbursement> list = r.getAll();
//    	System.out.println(list);
    	
//    	String username = "manager";
//    	String password = "pass1234";
//    	String enc = md5("pass",password,"password");
//    	UserDao ud = new UserDao();
//    	List<User> list = ud.getAll();
//    	System.out.println(list);
//    	System.out.println(list.get(0));
//    	
//    	ud.getById(1);
//    	System.out.println(ud.getById(1));
//    	User usr = new User(2,"staremployee","starenter","BoJack","Horseman","bh@mail.com",2);
//    	ud.insert(usr);
    }
}
