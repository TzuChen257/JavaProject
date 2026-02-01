package service;

import java.util.List;

import model.OnlineAccount;

public interface OAccountService {
	//create
	boolean addOAccount(OnlineAccount oAccount);
	//read
	List<OnlineAccount> allOAccount();
	List<OnlineAccount> findByUser(String online_user);
	//update
	boolean updateOAccount(OnlineAccount oAccount, String passwordAgain);
	//delete
	boolean deleteOAccountByUser(String online_user, String root_password);
}
