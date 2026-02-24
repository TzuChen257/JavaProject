package service;

import java.util.List;

import model.TransactionDetail;

public interface TransDService {
	//create
	boolean addActivity1Withdraw(TransactionDetail transDetail);
	boolean addActivity2Deposit(TransactionDetail transDetail);
	String  addActivity3Trans(TransactionDetail transDetail);
	//boolean addActivity4GetTrans(TransactionDetail transDetail);//跟使用者無關??
	//read
	List<TransactionDetail> selectAllDetail();//只有administrator頁面可用
	List<TransactionDetail> selectDetailByAccount(String bank_account);//使用者以及admin查閱一人
	//List<TransactionDetail> selectDetailByTime(String from_time, String to_time);
	//update
	//是否不進行新增??
	//delete
	//是否不能刪除
}
