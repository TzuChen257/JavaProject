package model;

import java.io.Serializable;

import service.Impl.AccountServiceImpl;
import util.Tool;

public class TransactionDetail implements Serializable{
	//field
	private int id;
	private String subject_account;
	private int trading_activity;//1提款2存款(3轉出4轉入)
	private int income;
	private int expenses;
	private int balance_now;//交易後
	private String object_account;//轉帳使用
	private String trading_time;
	private AccountServiceImpl accountServiceImpl=new AccountServiceImpl();//new一個可以連線的物件去修改balance
	//問題：收入跟支出是不是應該要不同項目???如果沒有分項目我可以再顯示時判斷應該放哪嗎
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
		if(trading_activity==1)
		{
			Account subject=accountServiceImpl.findByAccount(subject_account).get(0);//使用時已登入故不會有照不到帳戶的問題就不使用try/catch了
			this.expenses = trading_amount;
			this.balance_now=subject.getBalance()-trading_amount;
			subject.setBalance(balance_now);
			accountServiceImpl.updateData(subject);
		}
		else if(trading_activity==2)
		{
			Account subject=accountServiceImpl.findByAccount(subject_account).get(0);//使用時已登入故不會有照不到帳戶的問題就不使用try/catch了
			this.income = trading_amount;
			this.balance_now=subject.getBalance()+trading_amount;
			subject.setBalance(balance_now);
			accountServiceImpl.updateData(subject);
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
		//balance
		Account subject=accountServiceImpl.findByAccount(subject_account).get(0);//使用時已登入故不會有照不到帳戶的問題就不使用try/catch了
		this.balance_now=subject.getBalance()-trading_amount;
		subject.setBalance(balance_now);
		accountServiceImpl.updateData(subject);
		//呼叫對方轉入
		//new TransactionDetail(object_account, trading_amount, subject_account);
	}
	//c04 轉帳_轉入(跟別人有關，毋須自選行為)，呼叫用
	public TransactionDetail(String subject_account, int trading_amount, String object_account) {
		super();
		this.subject_account = subject_account;
		this.trading_activity = 4;
		this.income = trading_amount;
		this.object_account = object_account;
		this.trading_time = Tool.Time();
		//balance
		Account subject=accountServiceImpl.findByAccount(subject_account).get(0);//使用時已登入故不會有照不到帳戶的問題就不使用try/catch了
		this.balance_now=subject.getBalance()+trading_amount;
		subject.setBalance(balance_now);
		accountServiceImpl.updateData(subject);
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
