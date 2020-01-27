package com.ers.DAO;

import java.util.List;

/**
 * This is the DAO API
 */
public interface DaoContract <T> {
	
	List <T> getAll();
	
	T getById(int id);
	
	int update(T t);
	
	int insert(T t);
	
	int delete(T t);
}