package dao;

import java.util.List;

import model.OnlineAccount;

public interface OnlineAccountDao {
	//create
	void add(OnlineAccount oAccount);
	//read
	List<OnlineAccount> selectAll();
	List<OnlineAccount> selectByUser(String online_user);
	//update
	void updatePassword(OnlineAccount oAccount);
	//delete
	void deleteByUser(String online_user);
}
