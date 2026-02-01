package dao;

import java.util.List;

import model.TransactionDetail;

public interface TransDetailDao {
	//create
	void add(TransactionDetail transDetail);
	void addTrans(TransactionDetail transDetail);
	void addGetTrans(String subject_account, int trading_amount, String object_account);
	//read
	List<TransactionDetail> selectAll();//只有administrator頁面可用
	List<TransactionDetail> selectByAccount(String bank_account);//使用者以及admin查閱一人
	//List<TransactionDetail> selectByWeek();//一周內紀錄
	//List<TransactionDetail> selectByMonth();//一個月內紀錄
	//List<TransactionDetail> selectBySeason();//三個月內紀錄
	//update
	//void update(TransactionDetail transDetail);//???是否沒必要??還沒做關聯如果A表改變資料B表是否需更改??
	//delete
	//void deleteById(int id);//資料庫有顯示過多問題嗎，會不會太久的紀錄需要用這個方法去刪除
}
