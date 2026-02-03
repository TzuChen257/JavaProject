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
	public boolean addAccount(Account account) {
		boolean isAdd=false;		
		if(account.getBalance()>=1000)
		{
			accountDaoImpl.add(account);
			isAdd=true;
			return isAdd;
		}
		else
		{
			return isAdd;
		}
	}
	@Override
	public List<Account> allAccount() {
		return accountDaoImpl.selectAll();
	}
	@Override
	public List<Account> findByAccount(String account) {
		return accountDaoImpl.selectByAccount(account);
	}
	@Override
	public List<Account> findByOnlineUser(String online_username) {
		return accountDaoImpl.selectByUser(online_username);
	}
	@Override
	public boolean updateTransPassword(Account account, String passwordAgain) {
		boolean isUpdate=false;
		if(account.getTrans_password().equals(passwordAgain))
		{
			accountDaoImpl.update(account);
			isUpdate=true;
			return isUpdate;
		}
		else
		{
			return isUpdate;
		}
	}
	@Override
	public boolean updateOnlinePassword(Account account, String passwordAgain) {
		boolean isUpdate=false;
		if(account.getOnline_password().equals(passwordAgain))
		{
			accountDaoImpl.update(account);
			isUpdate=true;
			return isUpdate;
		}
		else
		{
			return isUpdate;
		}
	}
	//沒有想到篩選條件??感覺無法在這裡篩選因為不一定有填入???
	@Override
	public boolean updateData(Account account) {
		boolean isUpdate=false;
		accountDaoImpl.update(account);
		isUpdate=true;
		return isUpdate;
	}
	@Override
	public boolean deleteByAccount(String bank_account) {
		boolean isDelete=false;
		accountDaoImpl.deleteByAccount(bank_account);
		isDelete=true;
		return isDelete;
		/*
		if(root_password.equals("root1234"))//最高權限同意刪除
		{
			accountDaoImpl.deleteByAccount(account);
			isDelete=true;
			return isDelete;
		}
		else
		{
			System.out.println("無權限刪除帳號");//顯示在UI?
			return isDelete;
		}
		*/
	}
}
