package com.ers.ERSystem;

import java.util.List;

import com.ers.DAO.ReimbursementDao;
import com.ers.DAO.UserDao;
import com.ers.model.Reimbursement;
import com.ers.model.User;



/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//    	User usr = new User();
//		List<User> list = usr.getList();
//		String liststr = list.toString().replace(",", "");
//		System.out.println(liststr);
    	
//    	ReimbursementDao rd = new ReimbursementDao();
//    	rd.getById(2);


    	ReimbursementDao r = new ReimbursementDao();
    	List<Reimbursement> list = r.getAll();
    	System.out.println(list);
    	
//    	UserDao ud = new UserDao();
//    	List<User> list = ud.getAll();
//    	System.out.println(list);
//    	ud.getById(1);
//    	System.out.println(ud.getById(1));
//    	User usr = new User(2,"staremployee","starenter","BoJack","Horseman","bh@mail.com",2);
//    	ud.insert(usr);
    }
}
