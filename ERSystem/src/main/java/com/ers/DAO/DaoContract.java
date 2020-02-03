package com.ers.DAO;

import java.sql.SQLException;
import java.util.List;

/**
 * This is the DAO API
 */
public interface DaoContract <T> {
	
	List<String[]> getAll();
	
	T getById(int id);
	
	int update(T t) throws ClassNotFoundException, SQLException;
	
	int insert(T t) throws SQLException, ClassNotFoundException;
	
	int delete(T t);
}