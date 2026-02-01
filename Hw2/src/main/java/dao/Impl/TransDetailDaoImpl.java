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
		new TransDetailDaoImpl().add(new TransactionDetail("13246546546",2,50000));//存款
		new TransDetailDaoImpl().add(new TransactionDetail("13245646546",1,10000));//提款
		//new TransDetailDaoImpl().add(new TransactionDetail("88145649511",3,30000,"13246546546"));//轉帳
		//select
		System.out.println(new TransDetailDaoImpl().selectAll());
		System.out.println(new TransDetailDaoImpl().selectByAccount("13246546546"));
	}
	//每個method都要用的物件
	Connection conn=Tool.getDb();
	//method
	@Override
	public void add(TransactionDetail transDetail) {
		String sqlTransAdd="insert into transaction_detail"
				+ "(subject_account,trading_activity,trading_amount,income,expenses,object_account,subject_balance,trading_time)"
				+ " values(?,?,?,?,?,?,?,?)";
		String sqlSubjectAccount="select * from account where bank_account=?";
		try {
			PreparedStatement psTransD=conn.prepareStatement(sqlTransAdd);
			PreparedStatement psSubjectA=conn.prepareStatement(sqlSubjectAccount);
			psSubjectA.setString(1, transDetail.getSubject_account());
			ResultSet rsS=psSubjectA.executeQuery();
			Account account=new Account();
			if(rsS.next())
			{
				account.setBank_account(rsS.getString("bank_account"));
				account.setBalance(rsS.getInt("balance"));
			}
			psTransD.setString(1, transDetail.getSubject_account());
			psTransD.setInt(2, transDetail.getTrading_activity());
			psTransD.setInt(3, transDetail.getTrading_amount());
			psTransD.setString(4, transDetail.getIncome());
			psTransD.setString(5, transDetail.getExpenses());
			psTransD.setString(6, transDetail.getObject_account());
			psTransD.setInt(7, transDetail.getSubject_balance());
			psTransD.setString(8, transDetail.getTrading_time());
			psTransD.executeUpdate();
		} catch (SQLException e) {
			System.out.println("wrong sql");
			e.printStackTrace();
		}
	}
	@Override
	public void addTrans(TransactionDetail transDetail) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void addGetTrans(String subject_account, int trading_amount, String object_account) {
		// TODO Auto-generated method stub
		
	}
	/*
	@Override
	public void add(TransactionDetail transDetail) {
		String sqlTransAdd="insert into transaction_detail"
				+ "(subject_account,trading_activity,trading_amount,income,expenses,object_account,subject_balance,trading_time)"
				+ " values(?,?,?,?,?,?,?,?)";
		String sqlSubjectAccount="select * from account where bank_account=?";
		try {
			PreparedStatement psTransD=conn.prepareStatement(sqlTransAdd);
			PreparedStatement psSubjectA=conn.prepareStatement(sqlSubjectAccount);
			psSubjectA.setString(1, transDetail.getSubject_account());
			ResultSet rsS=psSubjectA.executeQuery();
			Account subAccount=new Account();
			Account obAccount=new Account();
			if(rsS.next())
			{
				subAccount.setBank_account(rsS.getString("bank_account"));
				subAccount.setBalance(rsS.getInt("balance"));
			}
			if(transDetail.getObject_account()!=null)
			{
				String sqlObjectAccount="select * from account where bank_account=?";
				PreparedStatement psObjectA=conn.prepareStatement(sqlObjectAccount);
				psObjectA.setString(1, sqlSubjectAccount);
				ResultSet rsO=psObjectA.executeQuery();
				if(rsO.next())
				{
					obAccount.setBank_account(rsO.getString("bank_account"));
					obAccount.setBalance(rsO.getInt("balance"));
				}
			}
			psTransD.setString(1, transDetail.getSubject_account());
			psTransD.setInt(2, transDetail.getTrading_activity());
			psTransD.setInt(3, transDetail.getTrading_amount());
			psTransD.setString(4, transDetail.getIncome());
			psTransD.setString(5, transDetail.getExpenses());
			psTransD.setString(6, transDetail.getObject_account());
			psTransD.setInt(7, transDetail.getSubject_balance());
			psTransD.setString(8, transDetail.getTrading_time());
			psTransD.executeUpdate();
		} catch (SQLException e) {
			System.out.println("wrong sql");
			e.printStackTrace();
		}
	}
	*/
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
				transDetail.setTrading_amount(rs.getInt("trading_amount"));
				transDetail.setIncome(rs.getString("income"));
				transDetail.setExpenses(rs.getString("expenses"));
				transDetail.setObject_account(rs.getString("object_account"));
				transDetail.setSubject_balance(rs.getInt("subject_balance"));
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
				transDetail.setTrading_amount(rs.getInt("trading_amount"));
				transDetail.setIncome(rs.getString("income"));
				transDetail.setExpenses(rs.getString("expenses"));
				transDetail.setObject_account(rs.getString("object_account"));
				transDetail.setSubject_balance(rs.getInt("subject_balance"));
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
