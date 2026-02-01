package dao;

import java.util.List;

import model.Account;

public interface AccountDao {
	//create
	void add(Account account);
	//void addAccountGetOnline(Account account);//先開戶，再線上開戶
	//read
	List<Account> selectAll();//admin後臺使用
	List<Account> selectByAccount(String bankAccount);//後台、使用者皆可使用
	List<Account> selectByUser(String online_username);//使用者線上登入用
	//update
	void update(Account account);
	//delete
	void deleteByAccount(String bankAccount);
}
