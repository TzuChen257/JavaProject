package model;

import java.io.Serializable;

public class Account implements Serializable{
	//f
	private int id;
	private String bank_account;
	private String trans_password;
	private int access_level;
	private String online_user;
	private String online_password;
	private int balance;
	private String name;
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
	public Account(String bank_account, String trans_password, String online_user,
			String online_password, int balance, String name, String birthday, String national_id, String address,
			String phone) {
		super();
		this.bank_account = bank_account;
		this.trans_password = trans_password;
		this.access_level = 3;
		this.online_user = online_user;
		this.online_password = online_password;
		this.balance = balance;
		this.name = name;
		this.birthday = birthday;
		this.national_id = national_id;
		this.address = address;
		this.phone = phone;
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
	public int getAccess_level() {
		return access_level;
	}
	public void setAccess_level(int access_level) {
		this.access_level = access_level;
	}
	public String getOnline_user() {
		return online_user;
	}
	public void setOnline_user(String online_user) {
		this.online_user = online_user;
	}
	public String getOnline_password() {
		return online_password;
	}
	public void setOnline_password(String online_password) {
		this.online_password = online_password;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
