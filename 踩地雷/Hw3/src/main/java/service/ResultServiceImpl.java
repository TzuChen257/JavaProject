package service;

import java.util.List;
import dao.ResultDaoImpl;
import model.Result;

interface ResultService
{
	//c
	boolean newResult(Result result);
	//r
	List<Result> allUser();
	List<Result> findByUser(String username);//個人可藉由自己的紀錄(table)刪除
	//d
	//boolean delResultById(int id);//個人可刪除自己的紀錄
}

public class ResultServiceImpl implements ResultService{
	//test main
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//連線方法用物件
	ResultDaoImpl resultDaoImpl=new ResultDaoImpl();
	//method
	@Override
	public boolean newResult(Result result) {
		boolean isNew=false;
		resultDaoImpl.add(result);
		isNew=true;
		return isNew;
	}
	@Override
	public List<Result> allUser() {
		return resultDaoImpl.selectAll();
	}
	@Override
	public List<Result> findByUser(String username) {
		return resultDaoImpl.selectByUser(username);
	}
}
