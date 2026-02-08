package vo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.Tool;

interface ViewDao
{
	//read
	List<View01> allIncome();
	List<View01> allExpenses();
	List<View01> onesIncome(String subject_account);
	List<View01> onesExpenses(String subject_account);
}
public class ViewDaoImpl implements ViewDao{
	//main test
	public static void main(String[] args) {
		System.out.println(new ViewDaoImpl().allIncome().size());
		System.out.println(new ViewDaoImpl().allExpenses().size());
		System.out.println(new ViewDaoImpl().onesIncome("13246546546").size());
		System.out.println(new ViewDaoImpl().onesExpenses("13246546546").size());
	}
	//連線物件
	Connection conn=Tool.getDb();
	//method
	@Override
	public List<View01> allIncome() {
		String sql="SELECT view01.id, view01.subject_account, view01.o_act as income,"
				+ "view01.expenses, view01.balance_now, view01.trading_time from view01 where in_out=1";
		List<View01> allIn=new ArrayList<>();
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				View01 v=new View01();
				v.setId(rs.getInt("id"));
				v.setSubject_account(rs.getString("subject_account"));
				v.setIncome(rs.getString("income"));
				v.setExpenses("");
				v.setBalance_now(rs.getInt("balance_now"));
				v.setTrading_time(rs.getString("trading_time"));
				allIn.add(v);
			}
		} catch (SQLException e) {
			System.out.println("wrong sql");
			e.printStackTrace();
		}
		return allIn;
	}

	@Override
	public List<View01> allExpenses() {
		String sql="SELECT view01.id, view01.subject_account, view01.income, view01.o_act as expenses,"
				+ "view01.balance_now, view01.trading_time from view01 where in_out=2";
		List<View01> allEx=new ArrayList<>();
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				View01 v=new View01();
				v.setId(rs.getInt("id"));
				v.setSubject_account(rs.getString("subject_account"));
				v.setIncome("");
				v.setExpenses(rs.getString("expenses"));
				v.setBalance_now(rs.getInt("balance_now"));
				v.setTrading_time(rs.getString("trading_time"));
				allEx.add(v);
			}
		} catch (SQLException e) {
			System.out.println("wrong sql");
			e.printStackTrace();
		}
		return allEx;
	}

	@Override
	public List<View01> onesIncome(String subject_account) {
		String sql="SELECT view01.id, view01.subject_account, view01.o_act as income, view01.expenses,"
				+ "view01.balance_now, view01.trading_time from view01 where in_out=1 and subject_account=?";
		List<View01> in=new ArrayList<>();
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, subject_account);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				View01 v=new View01();
				v.setId(rs.getInt("id"));
				v.setSubject_account(rs.getString("subject_account"));
				v.setIncome(rs.getString("income"));
				v.setExpenses("");
				v.setBalance_now(rs.getInt("balance_now"));
				v.setTrading_time(rs.getString("trading_time"));
				in.add(v);
			}
		} catch (SQLException e) {
			System.out.println("wrong sql");
			e.printStackTrace();
		}
		return in;
	}

	@Override
	public List<View01> onesExpenses(String subject_account) {
		String sql="SELECT view01.id, view01.subject_account, view01.income, view01.o_act as expenses,"
				+ "view01.balance_now, view01.trading_time from view01 where in_out=2 and subject_account=?";
		List<View01> ex=new ArrayList<>();
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, subject_account);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				View01 v=new View01();
				v.setId(rs.getInt("id"));
				v.setSubject_account(rs.getString("subject_account"));
				v.setIncome("");
				v.setExpenses(rs.getString("expenses"));
				v.setBalance_now(rs.getInt("balance_now"));
				v.setTrading_time(rs.getString("trading_time"));
				ex.add(v);
			}
		} catch (SQLException e) {
			System.out.println("wrong sql");
			e.printStackTrace();
		}
		return ex;
	}

}
