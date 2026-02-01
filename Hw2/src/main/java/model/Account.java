package model;

import java.io.Serializable;

public class Account implements Serializable{
	//f
	private int id;
	private String bank_account;
	private String trans_password;
	private String online_username;
	private int balance;
	private String birthday;
	private String national_id;
	private String address;
	private String phone;
	//c
	//c01 查詢資料用
	public Account() {
		super();
	}
	//c02 建立帳戶
	public Account(String bank_account, String trans_password, int balance, String birthday, String national_id,
			String address, String phone) {
		super();
		this.bank_account = bank_account;
		this.trans_password = trans_password;
		this.balance = balance;
		this.birthday = birthday;
		this.national_id = national_id;
		this.address = address;
		this.phone = phone;
	}
	//c03 交易行為呼叫用
	public Account(String bank_account) {
		super();
		this.bank_account = bank_account;
	}
	//m
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBank_account() {
		return bank_account;
	}
	public void setBank_account(String bank_account) {
		this.bank_account = bank_account;
	}
	public String getTrans_password() {
		return trans_password;
	}
	public void setTrans_password(String trans_password) {
		this.trans_password = trans_password;
	}
	public String getOnline_username() {
		return online_username;
	}
	public void setOnline_username(String online_username) {
		this.online_username = online_username;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getNational_id() {
		return national_id;
	}
	public void setNational_id(String national_id) {
		this.national_id = national_id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
