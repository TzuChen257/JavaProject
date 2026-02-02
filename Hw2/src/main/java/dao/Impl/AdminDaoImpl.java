package dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.AdminDao;
import model.Administrator;
import util.Tool;

public class AdminDaoImpl implements AdminDao{
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
	public void add(Administrator Admin) {
		String sql="insert into administrator(online_user,online_password,access) values(?,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, Admin.getOnline_user());
			ps.setString(2, Admin.getOnline_password());
			ps.setInt(3, Admin.getAccess());
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("wrong SQL");
			e.printStackTrace();
		}
	}
	@Override
	public List<Administrator> selectAll() {
		List<Administrator> listAdmin=new ArrayList<>();
		String sql="select * from administrator";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Administrator Admin=new Administrator();
				Admin.setId(rs.getInt("id"));
				Admin.setOnline_user(rs.getString("online_user"));
				Admin.setOnline_password(rs.getString("online_password"));
				Admin.setAccess(rs.getInt("access"));
				listAdmin.add(Admin);
			}
		} catch (SQLException e) {
			System.out.println("wrong SQL");
			e.printStackTrace();
		}
		return listAdmin;
	}
	@Override
	public List<Administrator> selectByUser(String online_user) {
		List<Administrator> listAdmin=new ArrayList<>();
		String sql="select * from administrator where online_user=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, online_user);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				Administrator Admin=new Administrator();
				Admin.setId(rs.getInt("id"));
				Admin.setOnline_user(rs.getString("online_user"));
				Admin.setOnline_password(rs.getString("online_password"));
				Admin.setAccess(rs.getInt("access"));
				listAdmin.add(Admin);
			}
		} catch (SQLException e) {
			System.out.println("wrong SQL");
			e.printStackTrace();
		}
		return listAdmin;
	}
	
	@Override
	public void update(Administrator Admin) {
		String sql="update administrator set online_user=?,online_password=?,access=? where id=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, Admin.getOnline_user());
			ps.setString(2, Admin.getOnline_password());
			ps.setInt(3, Admin.getAccess());
			ps.setInt(4, Admin.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("wrong SQL");
			e.printStackTrace();
		}
	}
	
	@Override
	public void deleteByUser(String online_user) {
		String sql="delete from administrator where online_user=?";
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
