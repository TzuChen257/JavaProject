package service;

import java.util.List;

import model.Administrator;

public interface AdminService {
	//create
	boolean addAdmin(Administrator admin);
	//read
	List<Administrator> allAdmin();
	List<Administrator> findByUser(String online_user);
	//update
	boolean updateAdmin(Administrator admin);
	//delete
	boolean deleteAdminByUser(String online_user);
}
