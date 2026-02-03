package dao;

import java.util.List;

import model.TransactionDetail;

public interface TransDetailDao {
	//create
	void add1Withdraw(TransactionDetail transDetail);
	void add2Deposit(TransactionDetail transDetail);
	void add3Trans(TransactionDetail transDetail);
	void add4GetTrans(TransactionDetail transDetail);
	//void add(TransactionDetail transDetail);
	//void addTrans(TransactionDetail transDetail);
	//void addGetTrans(String subject_account, int trading_amount, String object_account);
	//read
	List<TransactionDetail> selectAll();//只有administrator頁面可用
	List<TransactionDetail> selectByAccount(String bank_account);//使用者以及admin查閱一人
	//update
	//void update(TransactionDetail transDetail);//???是否沒必要??
	//delete
	//void deleteById(int id);//資料庫有顯示過多問題嗎，會不會太久的紀錄需要用這個方法去刪除
}
