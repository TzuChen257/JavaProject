package dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.AccountDao;
import model.Account;
import util.Tool;

public class AccountDaoImpl implements AccountDao{
	//main
	public static void main(String[] args) {
		//add
		//new AccountDaoImpl().add(new Account("13246546546","541234",1000,"77.04.05","S156515451","Tainan","09132456748"));
		//select
		//System.out.println(new AccountDaoImpl().selectAll());
		//selectByAccountA
		//System.out.println(new AccountDaoImpl().selectByAccount(new Account("13245646546")));
		//System.out.println(new AccountDaoImpl().selectByAccount("13245646546"));
		//update
		/*
		List<Account> list=new AccountDaoImpl().selectByAccount("13246546546");
		Account account=list.get(0);
		account.setBalance(200000);
		new AccountDaoImpl().update(account);
		*/
		//delete
		//new AccountDaoImpl().deleteByAccount("88145649512");
	}
	//每個method都要使用的物件
	Connection conn=Tool.getDb();
	//method
	@Override
	public void add(Account account) {
		String sql="insert into account(bank_account,trans_password,access_level,online_user,online_password,balance,name,birthday,national_id,address,phone)"
				+ "values(?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, account.getBank_account());
			ps.setString(2, account.getTrans_password());
			ps.setInt(3, account.getAccess_level());
			ps.setString(4, account.getOnline_user());
			ps.setString(5, account.getOnline_password());
			ps.setInt(6, account.getBalance());
			ps.setString(7, account.getName());
			ps.setString(8, account.getBirthday());
			ps.setString(9, account.getNational_id());
			ps.setString(10, account.getAddress());
			ps.setString(11, account.getPhone());
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("wrong SQL");
			e.printStackTrace();
		}
	}
	@Override
	public List<Account> selectAll() {
		String sql="select * from account";
		List<Account> listAccount=new ArrayList<>();
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Account account=new Account();
				account.setId(rs.getInt("id"));
				account.setBank_account(rs.getString("bank_account"));
				account.setTrans_password(rs.getString("trans_password"));
				account.setAccess_level(rs.getInt("access_level"));
				account.setOnline_user(rs.getString("online_user"));
				account.setOnline_password(rs.getString("online_password"));
				account.setBalance(rs.getInt("balance"));
				account.setName(rs.getString("name"));
				account.setBirthday(rs.getString("birthday"));
				account.setNational_id(rs.getString("national_id"));
				account.setAddress(rs.getString("address"));
				account.setPhone(rs.getString("phone"));
				listAccount.add(account);				
			}
		} catch (SQLException e) {
			System.out.println("wrong SQL");
			e.printStackTrace();
		}
		return listAccount;
	}
	@Override
	public List<Account> selectByAccount(String bankAccount) {
		String sql="select * from account where bank_account=?";
		List<Account> listAccount=new ArrayList<>();
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, bankAccount);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				Account account=new Account();
				account.setId(rs.getInt("id"));
				account.setBank_account(rs.getString("bank_account"));
				account.setTrans_password(rs.getString("trans_password"));
				account.setAccess_level(rs.getInt("access_level"));
				account.setOnline_user(rs.getString("online_user"));
				account.setOnline_password(rs.getString("online_password"));
				account.setBalance(rs.getInt("balance"));
				account.setName(rs.getString("name"));
				account.setBirthday(rs.getString("birthday"));
				account.setNational_id(rs.getString("national_id"));
				account.setAddress(rs.getString("address"));
				account.setPhone(rs.getString("phone"));
				listAccount.add(account);
			}
		} catch (SQLException e) {
			System.out.println("wrong SQL");
			e.printStackTrace();
		}
		return listAccount;
	}
	@Override
	public List<Account> selectByUser(String online_user) {
		String sql="select * from account where online_user=?";
		List<Account> listAccount=new ArrayList<>();
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, online_user);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				Account account=new Account();
				account.setId(rs.getInt("id"));
				account.setBank_account(rs.getString("bank_account"));
				account.setTrans_password(rs.getString("trans_password"));
				account.setAccess_level(rs.getInt("access_level"));
				account.setOnline_user(rs.getString("online_user"));
				account.setOnline_password(rs.getString("online_password"));
				account.setBalance(rs.getInt("balance"));
				account.setName(rs.getString("name"));
				account.setBirthday(rs.getString("birthday"));
				account.setNational_id(rs.getString("national_id"));
				account.setAddress(rs.getString("address"));
				account.setPhone(rs.getString("phone"));
				listAccount.add(account);
			}
		} catch (SQLException e) {
			System.out.println("wrong SQL");
			e.printStackTrace();
		}
		return listAccount;
	}
	@Override
	public void update(Account account) {
		String sql="update account set trans_password=?,access_level=?,online_password=?,balance=?,name=?,address=?,phone=? where bank_account=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, account.getTrans_password());
			ps.setInt(2, account.getAccess_level());
			ps.setString(3, account.getOnline_password());
			ps.setInt(4, account.getBalance());
			ps.setString(5, account.getName());
			ps.setString(6, account.getAddress());
			ps.setString(7, account.getPhone());
			ps.setString(8, account.getBank_account());
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("wrong SQL");
			e.printStackTrace();
		}
	}
	@Override
	public void deleteByAccount(String bankAccount) {
		String sql="delete from account where bank_account=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, bankAccount);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("wrong SQL");
			e.printStackTrace();
		}
	}
	//bank_account流水號產生器
	//update的set balance是否有需要
}
