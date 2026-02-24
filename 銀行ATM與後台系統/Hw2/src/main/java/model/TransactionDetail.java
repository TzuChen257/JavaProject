package model;

import java.io.Serializable;

import service.Impl.AccountServiceImpl;
import util.Tool;

public class TransactionDetail implements Serializable{
	//field
	private int id;
	private String subject_account;
	private int trading_activity;//1提款2存款3轉出4轉入
	private int income;
	private int expenses;
	private int balance_now;//交易後
	private String object_account;//轉帳使用
	private String trading_time;
	//constructor
	//c01 查詢全部用
	public TransactionDetail() {
		super();
	}
	//c02 存提款(只跟自己有關)
	public TransactionDetail(String subject_account, int trading_activity, int trading_amount) {
		super();
		this.subject_account = subject_account;
		this.trading_activity = trading_activity;
		this.trading_time = Tool.Time();
		this.object_account = "ATM";
		if(trading_activity==1)
		{
			this.expenses = trading_amount;
		}
		else if(trading_activity==2)
		{
			this.income = trading_amount;
		}
	}
	//c03 轉帳_轉出(跟別人有關，須自選行為)
	public TransactionDetail(String subject_account, int trading_activity, int trading_amount, String object_account) {
		super();
		this.subject_account = subject_account;
		this.trading_activity = trading_activity;
		this.expenses = trading_amount;
		this.object_account = object_account;
		this.trading_time = Tool.Time();
	}
	//c04 轉帳_轉入(跟別人有關，毋須自選行為)，呼叫用
	public TransactionDetail(String subject_account, int trading_amount, String object_account) {
		super();
		this.subject_account = subject_account;
		this.trading_activity = 4;
		this.income = trading_amount;
		this.object_account = object_account;
		this.trading_time = Tool.Time();
	}
	//method
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubject_account() {
		return subject_account;
	}

	public void setSubject_account(String subject_account) {
		this.subject_account = subject_account;
	}

	public int getTrading_activity() {
		return trading_activity;
	}

	public void setTrading_activity(int trading_activity) {
		this.trading_activity = trading_activity;
	}

	public int getIncome() {
		return income;
	}

	public void setIncome(int income) {
		this.income = income;
	}

	public int getExpenses() {
		return expenses;
	}

	public void setExpenses(int expenses) {
		this.expenses = expenses;
	}

	public int getBalance_now() {
		return balance_now;
	}

	public void setBalance_now(int balance_now) {
		this.balance_now = balance_now;
	}

	public String getObject_account() {
		return object_account;
	}

	public void setObject_account(String object_account) {
		this.object_account = object_account;
	}

	public String getTrading_time() {
		return trading_time;
	}

	public void setTrading_time(String trading_time) {
		this.trading_time = trading_time;
	}
}
