package service;

import java.util.ArrayList;
import java.util.List;

import model.Account;

public interface AccountService {
	//create
	boolean[] addAccount(Account account);
	//read
	List<Account> allAccount();
	List<Account> findByAccount(String bank_account);
	List<Account> findByOnlineUser(String online_username);
	//update
	int updateAccess(String bank_account, String newPassword, String passwordAgain);
	int updateOnlinePassword(Account account, String newPassword, String passwordAgain);
	boolean[] updateData(Account account);
	void updateBalance(Account account);
	//delete
	boolean deleteByAccount(String bank_account);
}
