package dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.OnlineAccountDao;
import model.OnlineAccount;
import util.Tool;

public class OAccountDaoImpl implements OnlineAccountDao{
	//main測試
	public static void main(String[] args) {
		//add
		//new OAccountDaoImpl().add(new OnlineAccount("tom","1234",1));
		//select
		//System.out.println(new OAccountDaoImpl().selectAll());
		//System.out.println(new OAccountDaoImpl().selectByUser("dw"));
		//update
		/*
		List<OnlineAccount> list=new OAccountDaoImpl().selectByUser("sa");
		OnlineAccount admin=list.get(0);
		admin.setOnline_password("0150");
		new OAccountDaoImpl().updatePassword(admin);
		*/
		//delete
		//new OAccountDaoImpl().deleteByUser("ghuj");
	}
	//所有method都要用的
	Connection conn=Tool.getDb();
	//method
	@Override
	public void add(OnlineAccount oAccount) {
		String sql="insert into online_account(online_user,online_password,access) values(?,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, oAccount.getOnline_user());
			ps.setString(2, oAccount.getOnline_password());
			ps.setInt(3, oAccount.getAccess());
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("wrong SQL");
			e.printStackTrace();
		}
	}

	@Override
	public List<OnlineAccount> selectAll() {
		List<OnlineAccount> listOAccount=new ArrayList<>();
		String sql="select * from online_account";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				OnlineAccount oAccount=new OnlineAccount();
				oAccount.setId(rs.getInt("id"));
				oAccount.setOnline_user(rs.getString("online_user"));
				oAccount.setOnline_password(rs.getString("online_password"));
				oAccount.setAccess(rs.getInt("access"));
				listOAccount.add(oAccount);
			}
		} catch (SQLException e) {
			System.out.println("wrong SQL");
			e.printStackTrace();
		}
		return listOAccount;
	}

	@Override
	public List<OnlineAccount> selectByUser(String online_user) {
		List<OnlineAccount> listOAccount=new ArrayList<>();
		String sql="select * from online_account where online_user=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, online_user);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				OnlineAccount oAccount=new OnlineAccount();
				oAccount.setId(rs.getInt("id"));
				oAccount.setOnline_user(rs.getString("online_user"));
				oAccount.setOnline_password(rs.getString("online_password"));
				oAccount.setAccess(rs.getInt("access"));
				listOAccount.add(oAccount);
			}
		} catch (SQLException e) {
			System.out.println("wrong SQL");
			e.printStackTrace();
		}
		return listOAccount;
	}

	@Override
	public void updatePassword(OnlineAccount oAccount) {
		String sql="update online_account set online_password=? where online_user=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, oAccount.getOnline_password());
			ps.setString(2, oAccount.getOnline_user());
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("wrong SQL");
			e.printStackTrace();
		}
	}

	@Override
	public void deleteByUser(String online_user) {
		String sql="delete from online_account where online_user=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, online_user);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("wrong SQL");
			e.printStackTrace();
		}
	}
}
