package service.Impl;

import java.util.ArrayList;
import java.util.List;

import dao.Impl.AdminDaoImpl;
import model.Administrator;
import service.AdminService;

public class AdminServiceImpl implements AdminService{
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
	AdminDaoImpl adminDaoImpl=new AdminDaoImpl();
	//method
	@SuppressWarnings("finally")
	@Override
	public boolean addAdmin(Administrator admin) {
		boolean isAdd=false;
		try {
			String existAdmin=adminDaoImpl.selectByUser(admin.getOnline_user()).get(0).getOnline_user();
			//UIwarning:username重複
		}
		catch(IndexOutOfBoundsException e)//可能沒有建立
		{
			adminDaoImpl.add(admin);
			isAdd=true;
		}
		finally
		{
			return isAdd;
		}
	}
	@Override
	public List<Administrator> allAdmin() {
		return adminDaoImpl.selectAll();
	}
	@Override
	public List<Administrator> findByUser(String online_user) {
		return adminDaoImpl.selectByUser(online_user);
	}
	@Override
	public boolean updateAdmin(Administrator admin) {
		boolean isUpdate=false;
		adminDaoImpl.update(admin);
		isUpdate=true;
		return isUpdate;
	}
	@Override
	public boolean deleteAdminByUser(String online_user) {
		boolean isDelete=false;
		adminDaoImpl.deleteByUser(online_user);
		isDelete=true;
		return isDelete;
	}
}
