package service;

import java.util.List;

import model.Account;

public interface AccountService {
	//create
	boolean addAccount(Account account);
	//read
	List<Account> allAccount();
	List<Account> findByAccount(String account);
	List<Account> findByOnlineUser(String online_username);
	//update
	boolean updateTransPassword(Account account, String passwordAgain);
	//boolean updateOnlinePassword(Account account, String passwordAgain);重寫
	boolean updateData(Account account);
	//delete
	boolean deleteByAccount(String account, String root_password);
}
