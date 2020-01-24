package com.ers.DAO;

import java.util.List;

/**
 * This is the DAO API
 */
public interface DaoContract <T> {
	
	List <T> getAll();
	
	T getById(int id);
	
	void update(T t);
	
	void insert(T t);
	
	void delete(T t);
}