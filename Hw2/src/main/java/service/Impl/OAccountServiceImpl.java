package service.Impl;

import java.util.ArrayList;
import java.util.List;

import dao.Impl.OAccountDaoImpl;
import model.OnlineAccount;
import service.OAccountService;

public class OAccountServiceImpl implements OAccountService{
	//teat main
	public static void main(String[] args) {
		//add
		//System.out.println(new OAccountServiceImpl().addOAccount(new OnlineAccount("man","0000",1)));
		//all
		//System.out.println(new OAccountServiceImpl().allOAccount());
		//findBy
		//????有問題尚未解決(篩選條件)
		//update
		//System.out.println(new OAccountServiceImpl().updateOAccount(new OnlineAccount("sally","4578",2), "4578"));
		//delete
		//System.out.println(new OAccountServiceImpl().deleteOAccountByUser("an", "root1234"));
	}
	//method都需要使用的方法
	OAccountDaoImpl oAccountDaoImpl=new OAccountDaoImpl();
	//method
	@SuppressWarnings("finally")
	@Override
	public boolean addOAccount(OnlineAccount oAccount) {
		boolean isAdd=false;
		try {
			String existAdmin=oAccountDaoImpl.selectByUser(oAccount.getOnline_user()).get(0).getOnline_user();
			//UIwarning:username重複
		}
		catch(IndexOutOfBoundsException e)//可能沒有建立
		{
			oAccountDaoImpl.add(oAccount);
			isAdd=true;
		}
		finally
		{
			return isAdd;
		}
	}
	@Override
	public List<OnlineAccount> allOAccount() {
		return oAccountDaoImpl.selectAll();
	}
	@Override
	public List<OnlineAccount> findByUser(String online_user) {
		return oAccountDaoImpl.selectByUser(online_user);
	}
	@Override
	public boolean updateOAccount(OnlineAccount oAccount, String passwordAgain) {
		boolean isUpdate=false;
		if(oAccount.getOnline_password().equals(passwordAgain))//重新輸入一次正確
		{
			oAccountDaoImpl.updatePassword(oAccount);
			isUpdate=true;
			return isUpdate;
		}
		else
		{
			System.out.println("密碼輸入有誤，請重新輸入");//顯示在UI?
			return isUpdate;
		}
	}
	@Override
	public boolean deleteOAccountByUser(String online_user, String root_password) {
		boolean isDelete=false;
		if(root_password.equals("root1234"))//最高權限同意刪除
		{
			oAccountDaoImpl.deleteByUser(online_user);
			isDelete=true;
			return isDelete;
		}
		else
		{
			System.out.println("無權限刪除帳號");//顯示在UI?
			return isDelete;
		}
	}
}
