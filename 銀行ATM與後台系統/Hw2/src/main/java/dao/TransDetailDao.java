package dao;

import java.util.List;

import model.TransactionDetail;

public interface TransDetailDao {
	//create
	void addIncome(TransactionDetail transDetail);
	void addExpenses(TransactionDetail transDetail);
	//read
	List<TransactionDetail> selectAll();//只有administrator頁面可用
	List<TransactionDetail> selectByAccount(String bank_account);//使用者以及admin查閱一人
}
