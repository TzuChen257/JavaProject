package dao;

import java.util.List;

import model.Administrator;

public interface AdminDao {
	//create
	void add(Administrator Admin);
	//read
	List<Administrator> selectAll();
	List<Administrator> selectByUser(String online_user);
	//update
	void update(Administrator Admin);
	//delete
	void deleteByUser(String online_user);
}
