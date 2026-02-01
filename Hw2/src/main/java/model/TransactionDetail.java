package model;

import java.io.Serializable;

import util.Tool;

public class TransactionDetail implements Serializable{
	//field
	private int id;
	private String subject_account;
	private int trading_activity;//1提款2存款3轉出4轉入
	private int trading_amount;
	private String income;
	private String expenses;
	private String object_account;
	private int subject_balance;
	private String trading_time;
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
		this.trading_amount = trading_amount;
		this.trading_time = Tool.Time();
		//this.subject_balance
		if(trading_activity==1)
		{
			Account subject=new Account(subject_account);
			this.expenses="-"+String.valueOf(trading_amount);//this.expenses
			this.income="";//this.income
			this.subject_balance=subject.getBalance()-trading_amount;//new balance here
			subject.setBalance(subject_balance);//new balance back
			//new TransactionDetail().moneyOut(subject_account, trading_amount);
		}
		else if(trading_activity==2)
		{
			Account subject=new Account(subject_account);
			this.income="+"+String.valueOf(trading_amount);//this.income
			this.expenses="";//this.expenses
			this.subject_balance=subject.getBalance()+trading_amount;//new balance here
			subject.setBalance(subject_balance);//new balance back
			//new TransactionDetail().moneyIn(subject_account, trading_amount);
		}
	}
	//c03 轉帳_轉出(跟別人有關，須自選行為)
	public TransactionDetail(String subject_account, int trading_activity, int trading_amount,
			String object_account) {
		super();
		this.subject_account = subject_account;
		this.trading_activity = trading_activity;
		this.trading_amount = trading_amount;
		this.object_account = object_account;
		this.trading_time = Tool.Time();
		//this.subject_balance
		Account subject=new Account(subject_account);
		this.expenses="-"+trading_amount;//this.expenses
		this.income="";//this.income
		this.subject_balance=subject.getBalance()-trading_amount;//new balance here
		subject.setBalance(subject_balance);//new balance back
		//new TransactionDetail().moneyOut(subject_account, trading_amount);
		//同步使對方建立一筆轉入資料
		TransactionDetail object=new TransactionDetail(object_account,trading_amount,subject_account);
	}
	//c04 轉帳_轉入(跟別人有關，毋須自選行為)，呼叫用
	public TransactionDetail(String subject_account, int trading_amount, String object_account) {
		super();
		this.trading_activity=4;//直接帶入
		this.subject_account = subject_account;
		this.trading_amount = trading_amount;
		this.object_account = object_account;
		this.trading_time = Tool.Time();
		//this.subject_balance
		Account subject=new Account(subject_account);
		this.income="+"+trading_amount;//this.income
		this.expenses="";//this.expenses
		this.subject_balance=subject.getBalance()+trading_amount;//new balance here
		subject.setBalance(subject_balance);//new balance back
		//new TransactionDetail().moneyIn(subject_account, trading_amount);
	}
	//method
	//出帳
	private void moneyOut(String subject_account,int trading_amount)
	{
		Account subject=new Account(subject_account);
		this.expenses="-"+trading_amount;//this.expenses
		this.income="";//this.income
		this.subject_balance=subject.getBalance()-trading_amount;//new balance here
		subject.setBalance(subject_balance);//new balance back
		//確認是否真的連的到資料，表示要讀取兩筆資料??
	}
	//入賬
	private void moneyIn(String subject_account,int trading_amount)
	{
		Account subject=new Account(subject_account);
		this.income="+"+trading_amount;//this.income
		this.expenses="";//this.expenses
		this.subject_balance=subject.getBalance()+trading_amount;//new balance here
		subject.setBalance(subject_balance);//new balance back
		//確認是否真的連的到資料，表示要讀取兩筆資料??
	}
	//setter/getter
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
	public int getTrading_amount() {
		return trading_amount;
	}
	public void setTrading_amount(int trading_amount) {
		this.trading_amount = trading_amount;
	}
	public String getIncome() {
		return income;
	}
	public void setIncome(String income) {
		this.income = income;
	}
	public String getExpenses() {
		return expenses;
	}
	public void setExpenses(String expenses) {
		this.expenses = expenses;
	}
	public String getObject_account() {
		return object_account;
	}
	public void setObject_account(String object_account) {
		this.object_account = object_account;
	}
	public int getSubject_balance() {
		return subject_balance;
	}
	public void setSubject_balance(int subject_balance) {
		this.subject_balance = subject_balance;
	}
	public String getTrading_time() {
		return trading_time;
	}
	public void setTrading_time(String trading_time) {
		this.trading_time = trading_time;
	}
}
