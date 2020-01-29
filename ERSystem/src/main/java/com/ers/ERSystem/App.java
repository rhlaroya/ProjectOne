package com.ers.ERSystem;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.xml.bind.DatatypeConverter;

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
    public static void main( String[] args ) throws NoSuchAlgorithmException
    {
//    	User usr = new User();
//		List<User> list = usr.getList();
//		String liststr = list.toString().replace(",", "");
//		System.out.println(liststr);
    	
//    	ReimbursementDao rd = new ReimbursementDao();
//    	rd.getById(2);


//    	ReimbursementDao r = new ReimbursementDao();
//    	List<Reimbursement> list = r.getAll();
//    	System.out.println(list);
    	String username = "manager";
    	String password = "pass1234";
    	String enc = md5("pass",password,"password");
    	UserDao ud = new UserDao();
    	List<User> list = ud.getAll();
    	System.out.println(list);
    	for(User e: list) {
    		System.out.println("input pass:"+enc  +" the pass:"+e.getPassword());
    		if(e.getUsername().equals(username) && e.getPassword().equals(enc)) {
    			System.out.print("it worked");
    		}
    	}
    	
//    	ud.getById(1);
//    	System.out.println(ud.getById(1));
//    	User usr = new User(2,"staremployee","starenter","BoJack","Horseman","bh@mail.com",2);
//    	ud.insert(usr);
    }
    public static String encrypt(String password) 
			  throws NoSuchAlgorithmException {
			    String hash = "create trigger hashPass\r\n" + 
			    		"before insert or update on ersystem.\"ers-users\"\r\n" + 
			    		"for each row\r\n" + 
			    		"execute function hashPassword();"
			    		
			    		+ ";create or replace function hashPassword()\r\n" + 
			    		"returns trigger\r\n" + 
			    		"as $$\r\n" + 
			    		"	begin	\r\n" + 
			    		"		if(new.ers_password = old.ers_password)then\r\n" + 
			    		"		return new;\r\n" + 
			    		"	end if;\r\n" + 
			    		"	new.ers_password :=\r\n" + 
			    		"md5(new.ers_username||new.ers_password||'password');\r\n" + 
			    		"	return new;\r\n" + 
			    		"	end;\r\n" + 
			    		"$$ language plpgsql;";
			    
			         
			    MessageDigest md = MessageDigest.getInstance("MD5");
			    md.update(password.getBytes());
			    byte[] digest = md.digest();
			    String myHash = DatatypeConverter
			      .printHexBinary(digest).toUpperCase();
			    
			    return myHash;
			}
    
    public static String md5(String salt, String plainText, String salts)
            throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        salts = "password";
        if (salt != null) {
            md.update(salt.getBytes());
        }
        md.update(plainText.getBytes());

        byte byteData[] = md.digest();

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
            sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16)
                    .substring(1));
        }
        return sb.toString();
}
}
