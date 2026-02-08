package service.Impl;

import java.util.ArrayList;
import java.util.List;

import dao.Impl.TransDetailDaoImpl;
import model.Account;
import model.TransactionDetail;
import service.TransDService;

public class TransDServiceImpl implements TransDService{
	//test main
	public static void main(String[] args) {
		//System.out.println(new TransDServiceImpl().addActivity1Withdraw(new TransactionDetail("13246546546",1,80000)));
		//System.out.println(new TransDServiceImpl().addActivity2Deposit(new TransactionDetail("13246546546",2,80000)));
		//System.out.println(new TransDServiceImpl().addActivity3Trans(new TransactionDetail("13246546546",3,30000,"88145649511")));
	}
	//要用的物件
	TransDetailDaoImpl transDetailDaoImpl=new TransDetailDaoImpl();//明細連線
	AccountServiceImpl accountServiceImpl=new AccountServiceImpl();//帳戶物件
	//method
	@Override
	public boolean addActivity1Withdraw(TransactionDetail transDetail) {
		boolean isadd=false;
		Account subject=accountServiceImpl.findByAccount(transDetail.getSubject_account()).get(0);
		if(subject.getBalance()>=transDetail.getExpenses())//如果有錢
		{
			transDetail.setBalance_now(subject.getBalance()-transDetail.getExpenses());
			subject.setBalance(transDetail.getBalance_now());
			transDetailDaoImpl.addExpenses(transDetail);
			accountServiceImpl.updateData(subject);
			isadd=true;
		}
		return isadd;
	}
	@Override
	public boolean addActivity2Deposit(TransactionDetail transDetail) {
		boolean isadd=false;
		Account subject=accountServiceImpl.findByAccount(transDetail.getSubject_account()).get(0);
		transDetail.setBalance_now(subject.getBalance()+transDetail.getIncome());
		subject.setBalance(transDetail.getBalance_now());
		transDetailDaoImpl.addIncome(transDetail);
		accountServiceImpl.updateData(subject);
		isadd=true;
		return isadd;
	}
	@Override
	public String addActivity3Trans(TransactionDetail transDetail) {
		String show="";
		List<Account> l=accountServiceImpl.findByAccount(transDetail.getObject_account());
		if(!l.isEmpty())//有object帳號
		{
			Account subject=accountServiceImpl.findByAccount(transDetail.getSubject_account()).get(0);
			Account object=l.get(0);
			if(subject.getBalance()>=transDetail.getExpenses())//如果有錢
			{
				//subject account
				transDetail.setBalance_now(subject.getBalance()-transDetail.getExpenses());
				subject.setBalance(transDetail.getBalance_now());
				transDetailDaoImpl.addExpenses(transDetail);
				accountServiceImpl.updateData(subject);
				//object account
				TransactionDetail objectDetail=new TransactionDetail(transDetail.getObject_account(),transDetail.getExpenses(),transDetail.getSubject_account());
				objectDetail.setBalance_now(object.getBalance()+objectDetail.getIncome());
				object.setBalance(objectDetail.getBalance_now());
				transDetailDaoImpl.addIncome(objectDetail);
				accountServiceImpl.updateData(object);
				//結束
				show="轉帳成功";
			}
			else
			{
				show="餘額不足";
			}
		}
		else
		{
			show="查無此帳號";
		}
		return show;
	}
	@Override
	public List<TransactionDetail> selectAllDetail() {
		return transDetailDaoImpl.selectAll();
	}
	@Override
	public List<TransactionDetail> selectDetailByAccount(String bank_account) {
		return transDetailDaoImpl.selectByAccount(bank_account);
	}
	
}
