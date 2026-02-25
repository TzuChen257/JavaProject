package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Result;
import util.Tool;

interface ResultDao
{
	//c
	void add(Result result);
	//r
	List<Result> selectAll();
	List<Result> selectByUser(String username);//個人可藉由自己的紀錄刪除
	//List<Result> selectByMapLevel(int map_level);//只顯示前五??是否需要view
	//List<Result> selectByUserAndMap(String username,int map_level);//只顯示前五故要view??可以用Stream篩選???
	//d
	//void deleteById(int id);//個人可刪除自己的紀錄
}

public class ResultDaoImpl implements ResultDao{
	//test main
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//connection
	Connection conn=Tool.getDB();
	//method
	@Override
	public void add(Result result) {
		String sql="insert into result(username,time_spend,time_now,map_level) values(?,?,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, result.getUsername());
			ps.setString(2, result.getTime_spend());
			ps.setString(3, result.getTime_now());
			ps.setInt(4, result.getMap_level());
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("wrong sql");
			e.printStackTrace();
		}
	}
	@Override
	public List<Result> selectAll() {
		List<Result> list=new ArrayList<>();
		String sql="select * from result";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Result r=new Result();
				r.setId(rs.getInt("id"));
				r.setUsername(rs.getString("username"));
				r.setTime_spend(rs.getString("time_spend"));
				r.setTime_now(rs.getString("time_now"));
				r.setMap_level(rs.getInt("map_level"));
				list.add(r);
			}
		} catch (SQLException e) {
			System.out.println("wrong sql");
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<Result> selectByUser(String username) {
		List<Result> list=new ArrayList<>();
		String sql="select * from result where username=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, username);
			ResultSet rs=ps.executeQuery();
			while(rs.next())//可能一個人有多筆紀錄故要撈多筆
			{
				Result r=new Result();
				r.setId(rs.getInt("id"));
				r.setUsername(rs.getString("username"));
				r.setTime_spend(rs.getString("time_spend"));
				r.setTime_now(rs.getString("time_now"));
				r.setMap_level(rs.getInt("map_level"));
				list.add(r);
			}
		} catch (SQLException e) {
			System.out.println("wrong sql");
			e.printStackTrace();
		}
		return list;
	}
	/*
	@Override
	public List<Result> selectByMap(int map_level) {
		List<Result> list=new ArrayList<>();
		String sql="select * from result where map_level=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, map_level);
			ResultSet rs=ps.executeQuery();
			while(rs.next())//可能一個level有多筆
			{
				Result r=new Result();
				r.setId(rs.getInt("id"));
				r.setUsername(rs.getString("username"));
				r.setSec(rs.getInt("sec"));
				r.setResult_time(rs.getString("result_time"));
				r.setMap_level(rs.getInt("level"));
				list.add(r);
			}
		} catch (SQLException e) {
			System.out.println("wrong sql");
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public List<Result> selectByUserAndMap(String username, int map_level) {
		List<Result> list=new ArrayList<>();
		String sql="select * from result where username=? and map_level=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setInt(2, map_level);
			ResultSet rs=ps.executeQuery();
			while(rs.next())//可能某人在該level有多筆
			{
				Result r=new Result();
				r.setId(rs.getInt("id"));
				r.setUsername(rs.getString("username"));
				r.setSec(rs.getInt("sec"));
				r.setResult_time(rs.getString("result_time"));
				r.setMap_level(rs.getInt("level"));
				list.add(r);
			}
		} catch (SQLException e) {
			System.out.println("wrong sql");
			e.printStackTrace();
		}
		return list;
	}
	*/
	/*
	@Override
	public void deleteById(int id) {
		String sql="delete from result where id=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("wrong sql");
			e.printStackTrace();
		}
	}
	*/
}
