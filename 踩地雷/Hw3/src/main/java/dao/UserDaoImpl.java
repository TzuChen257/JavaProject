package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.User;
import util.Tool;

interface UserDao
{
	//c
	void add(User user);
	//r
	List<User> selectAll();//登入選項用(下拉式選單)
	List<User> selectByUser(String username);//確認使用者是否重複用
	//u
	void updateGameStateAndCheckin(User user);//積分使用
}

public class UserDaoImpl implements UserDao{
	//test main
	public static void main(String[] args) {
		//new UserDaoImpl().add(new User("kkk","1234"));
		//new UserDaoImpl().add(new User("dgf","123"));
		//System.out.println(new UserDaoImpl().selectAll());
		//System.out.println(new UserDaoImpl().selectByUser("abc"));
	}
	//Connection物件
	Connection conn=Tool.getDB();
	//method
	@Override
	public void add(User user) {
		String sql="insert into user(username, password, level, score, latest_checkin, checkin_week, checkin_count) values(?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setInt(3, user.getLevel());
			ps.setInt(4, user.getScore());
			ps.setString(5, user.getLatest_checkin());
			ps.setString(6, user.getCheckin_week());
			ps.setInt(7, user.getCheckin_count());
			//null就不填入
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("wrong sql");
			e.printStackTrace();
		}
	}
	@Override
	public List<User> selectAll() {
		String sql="select * from user";
		List<User> list=new ArrayList<>();
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				User u=new User();
				u.setId(rs.getInt("id"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				u.setLevel(rs.getInt("level"));
				u.setScore(rs.getInt("score"));
				u.setCheckin_count(rs.getInt("checkin_count"));
				u.setLatest_checkin(rs.getString("latest_checkin"));
				u.setCheckin_week(rs.getString("checkin_week"));
				u.setCheckin_week(rs.getString("checkin_week"));
				list.add(u);
			}
		} catch (SQLException e) {
			System.out.println("wrong sql");
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<User> selectByUser(String username) {
		String sql="select * from user where username=?";
		List<User> list=new ArrayList<>();
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				User u=new User();
				u.setId(rs.getInt("id"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
				u.setLevel(rs.getInt("level"));
				u.setScore(rs.getInt("score"));
				u.setCheckin_count(rs.getInt("checkin_count"));
				u.setLatest_checkin(rs.getString("latest_checkin"));
				u.setCheckin_week(rs.getString("checkin_week"));
				u.setCheckin_week(rs.getString("checkin_week"));
				list.add(u);
			}
		} catch (SQLException e) {
			System.out.println("wrong sql");
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public void updateGameStateAndCheckin(User user) {
		String sql="update user set level=?,score=?,latest_checkin=?,checkin_week=?,checkin_count=? where username=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, user.getLevel());
			ps.setInt(2, user.getScore());
			ps.setString(3, user.getLatest_checkin());
			ps.setString(4, user.getCheckin_week());
			ps.setInt(5, user.getCheckin_count());
			ps.setString(6, user.getUsername());
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("wrong sql");
			e.printStackTrace();
		}
	}
}
