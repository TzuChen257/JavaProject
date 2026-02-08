package service.Impl;

import java.util.ArrayList;
import java.util.List;

import dao.Impl.AccountDaoImpl;
import model.Account;
import service.AccountService;
import util.Tool;

public class AccountServiceImpl implements AccountService{
	//test main
	public static void main(String[] args) {
		
	}
	//method都需要使用的物件
	AccountDaoImpl accountDaoImpl=new AccountDaoImpl();
	//method
	@Override
	public boolean[] addAccount(Account account) {
		boolean[] isCorrect={true,true,true,true,true,true};
		//確認是否有該資料
		List<Account> isUsed=new AccountServiceImpl().findByAccount(account.getBank_account());
		//確認所有資料格式
		if(!account.getTrans_password().matches("\\d{6}"))//6位數字
		{
			isCorrect[1]=false;
			isCorrect[0]=false;//回傳不得新增
		}
		if(!isUsed.isEmpty())//重複使用者名稱
		{
			isCorrect[2]=false;
			isCorrect[0]=false;//回傳不得新增
		}
		if(!account.getNational_id().matches("[A-Z]\\d{9}"))//大寫字母+/d{9}
		{
			isCorrect[3]=false;
			isCorrect[0]=false;//回傳不得新增
		}
		if(!account.getPhone().matches("09\\d{8}"))//手機請填09-
		{
			isCorrect[4]=false;
			isCorrect[0]=false;//回傳不得新增
		}
		if(!(account.getBalance()>=1000))//開戶至少存入1000
		{
			isCorrect[5]=false;
			isCorrect[0]=false;//回傳不得新增
		}
		//判斷是否所有都是true才上傳
		if(isCorrect[0])
		{
			accountDaoImpl.add(account);
		}
		return isCorrect;
	}
	@Override
	public List<Account> allAccount() {
		return accountDaoImpl.selectAll();
	}
	@Override
	public List<Account> findByAccount(String bank_account) {
		return accountDaoImpl.selectByAccount(bank_account);
	}
	@Override
	public List<Account> findByOnlineUser(String online_username) {
		return accountDaoImpl.selectByUser(online_username);
	}
	@Override
	public int updateAccess(String bank_account, String newPassword, String passwordAgain) {
		int isUpdate=0;//密碼重新輸入有誤
		List<Account> list=new AccountServiceImpl().findByAccount(bank_account);
		if(list.isEmpty())//查無此帳
		{
			isUpdate=1;
		}
		else//有帳號
		{
			Account client=list.get(0);
			if(!newPassword.matches("\\d{6}"))//應為六位數字
			{
				isUpdate=2;
			}
			else if(newPassword.equals(passwordAgain))//密碼correct
			{
				client.setTrans_password(newPassword);
				client.setAccess_level(3);
				accountDaoImpl.update(client);
				isUpdate=3;
			}
		}
		return isUpdate;
	}
	@Override
	public int updateOnlinePassword(Account account, String newPassword, String passwordAgain) {
		int isUpdate=0;//密碼重新輸入有誤
		if(account.getOnline_password().equals(newPassword))//與前密碼同
		{
			isUpdate=1;
		}
		else if(newPassword.equals(passwordAgain))//密碼correct
		{
			account.setOnline_password(newPassword);
			accountDaoImpl.update(account);
			isUpdate=2;
			
		}
		return isUpdate;
	}
	@Override
	public boolean[] updateData(Account account) {
		boolean[] isCorrect={true,true,true};
		//確認所有資料格式
		if(!account.getOnline_password().equals("")&&!account.getAddress().equals("")&&!account.getName().equals(""))//資料不得為空
		{
			isCorrect[1]=false;
			isCorrect[0]=false;//回傳不得修改
		}
		if(!account.getPhone().matches("09\\d{8}"))//手機請填09-
		{
			isCorrect[2]=false;
			isCorrect[0]=false;//回傳不得修改
		}
		//判斷是否所有都是true才上傳
		if(isCorrect[0])
		{
			accountDaoImpl.update(account);
		}
		return isCorrect;
	}
	@Override
	public boolean deleteByAccount(String bank_account) {
		boolean isDelete=false;
		accountDaoImpl.deleteByAccount(bank_account);
		isDelete=true;
		return isDelete;
	}
	
}
