package model;

import java.io.Serializable;

public class Administrator implements Serializable{
	//f
	private int id;
	private String online_user;
	private String online_password;
	private int access;//1)最高權限：可刪除資料 2)員工：可新增與查詢資料
	//c
	//c01 查詢用
	public Administrator() {
		super();
	}
	//c02 建立用
	public Administrator(String online_user, String online_password, int access) {
		super();
		this.online_user = online_user;
		this.online_password = online_password;
		this.access = access;
	}
	//m
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getAccess() {
		return access;
	}
	public void setAccess(int access) {
		this.access = access;
	}
}
