package dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.TransDetailDao;
import model.Account;
import model.TransactionDetail;
import util.Tool;

public class TransDetailDaoImpl implements TransDetailDao{
	//test_main
	public static void main(String[] args) {
		//add
		//new TransDetailDaoImpl().add1Withdraw(new TransactionDetail("13246546546",1,5000));//提款
		//new TransDetailDaoImpl().add2Deposit(new TransactionDetail("13245646546",2,10000));//存款
		new TransDetailDaoImpl().add3Trans(new TransactionDetail("88145649511",3,30000,"13246546546"));//轉帳
		//select
		//System.out.println(new TransDetailDaoImpl().selectAll());
		//System.out.println(new TransDetailDaoImpl().selectByAccount("13246546546"));
	}
	//每個method都要用的物件
	Connection conn=Tool.getDb();
	//method
	@Override
	public void add1Withdraw(TransactionDetail transDetail) {
		String sql="insert into transaction_detail"
				+ "(subject_account,trading_activity,expenses,balance_now,trading_time)"
				+ "values(?,?,?,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, transDetail.getSubject_account());
			ps.setInt(2, transDetail.getTrading_activity());
			ps.setInt(3, transDetail.getExpenses());
			ps.setInt(4, transDetail.getBalance_now());
			ps.setString(5, transDetail.getTrading_time());
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("wrong sql");
			e.printStackTrace();
		}
	}
	@Override
	public void add2Deposit(TransactionDetail transDetail) {
		String sql="insert into transaction_detail"
				+ "(subject_account,trading_activity,income,balance_now,trading_time)"
				+ "values(?,?,?,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, transDetail.getSubject_account());
			ps.setInt(2, transDetail.getTrading_activity());
			ps.setInt(3, transDetail.getIncome());
			ps.setInt(4, transDetail.getBalance_now());
			ps.setString(5, transDetail.getTrading_time());
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("wrong sql");
			e.printStackTrace();
		}
	}
	@Override
	public void add3Trans(TransactionDetail transDetail) {
		String sql="insert into transaction_detail"
				+ "(subject_account,trading_activity,expenses,balance_now,object_account,trading_time)"
				+ "values(?,?,?,?,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, transDetail.getSubject_account());
			ps.setInt(2, transDetail.getTrading_activity());
			ps.setInt(3, transDetail.getExpenses());
			ps.setInt(4, transDetail.getBalance_now());
			ps.setString(5, transDetail.getObject_account());
			ps.setString(6, transDetail.getTrading_time());
			ps.executeUpdate();
			//同步呼叫轉入
			new TransDetailDaoImpl().add4GetTrans(new TransactionDetail(transDetail.getObject_account(),transDetail.getExpenses(),transDetail.getSubject_account()));
		} catch (SQLException e) {
			System.out.println("wrong sql");
			e.printStackTrace();
		}
	}
	@Override
	public void add4GetTrans(TransactionDetail transDetail) {
		String sql="insert into transaction_detail"
				+ "(subject_account,trading_activity,income,balance_now,object_account,trading_time)"
				+ "values(?,?,?,?,?,?)";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, transDetail.getSubject_account());
			ps.setInt(2, transDetail.getTrading_activity());
			ps.setInt(3, transDetail.getIncome());
			ps.setInt(4, transDetail.getBalance_now());
			ps.setString(5, transDetail.getObject_account());
			ps.setString(6, transDetail.getTrading_time());
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("wrong sql");
			e.printStackTrace();
		}
	}
	@Override
	public List<TransactionDetail> selectAll() {
		String sql="select * from transaction_detail";
		List<TransactionDetail> listTransD=new ArrayList<>();
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				TransactionDetail transDetail=new TransactionDetail();
				transDetail.setId(rs.getInt("id"));
				transDetail.setSubject_account(rs.getString("subject_account"));
				transDetail.setTrading_activity(rs.getInt("trading_activity"));
				transDetail.setIncome(rs.getInt("income"));
				transDetail.setExpenses(rs.getInt("expenses"));
				transDetail.setBalance_now(rs.getInt("balance_now"));
				transDetail.setObject_account(rs.getString("object_account"));
				transDetail.setTrading_time(rs.getString("trading_time"));
				listTransD.add(transDetail);
			}
		} catch (SQLException e) {
			System.out.println("wrong sql");
			e.printStackTrace();
		}
		return listTransD;
	}
	@Override
	public List<TransactionDetail> selectByAccount(String bank_account) {
		String sql="select * from transaction_detail where subject_account=?";
		List<TransactionDetail> listTransD=new ArrayList<>();
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, bank_account);
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				TransactionDetail transDetail=new TransactionDetail();
				transDetail.setId(rs.getInt("id"));
				transDetail.setSubject_account(rs.getString("subject_account"));
				transDetail.setTrading_activity(rs.getInt("trading_activity"));
				transDetail.setIncome(rs.getInt("income"));
				transDetail.setExpenses(rs.getInt("expenses"));
				transDetail.setBalance_now(rs.getInt("balance_now"));
				transDetail.setObject_account(rs.getString("object_account"));
				transDetail.setTrading_time(rs.getString("trading_time"));
				listTransD.add(transDetail);
			}
		} catch (SQLException e) {
			System.out.println("wrong sql");
			e.printStackTrace();
		}
		return listTransD;
	}
}
