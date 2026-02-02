package dao;

import java.util.List;

import model.Account;

public interface AccountDao {
	//create
	void add(Account account);
	//read
	List<Account> selectAll();//admin後臺使用
	List<Account> selectByAccount(String bankAccount);//後台、使用者皆可使用
	List<Account> selectByUser(String online_user);//使用者線上登入用
	//update
	void update(Account account);
	//delete
	void deleteByAccount(String bankAccount);
}
