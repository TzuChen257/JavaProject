package vo;

public class View01 implements Comparable<View01>{
	//f
	private int id;
	private String subject_account;
	private String o_act;
	private int in_out;
	private String income;
	private String expenses;
	private int balance_now;
	private String trading_time;
	//m
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
	public String getO_act() {
		return o_act;
	}
	public void setO_act(String o_act) {
		this.o_act = o_act;
	}
	public int getIn_out() {
		return in_out;
	}
	public void setIn_out(int in_out) {
		this.in_out = in_out;
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
	public int getBalance_now() {
		return balance_now;
	}
	public void setBalance_now(int balance_now) {
		this.balance_now = balance_now;
	}
	public String getTrading_time() {
		return trading_time;
	}
	public void setTrading_time(String trading_time) {
		this.trading_time = trading_time;
	}
	//排序用
	@Override
	public int compareTo(View01 o) {
		return this.id-o.id;
	}
}
