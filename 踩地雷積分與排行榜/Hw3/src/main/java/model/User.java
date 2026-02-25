package model;

import java.io.Serializable;

import util.Tool;

public class User implements Serializable,Comparable<User>{
	//f
	private int id;
	private String username;
	private String password;
	private int level;
	private int score;
    private String latest_checkin; 
    private String checkin_week;
    private int checkin_count;
	//c
	//查詢用
	public User() {
		super();
	}
	//新用戶用
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
		this.latest_checkin = null;//新增時尚未有上一次
		this.checkin_week = null;
		this.level = 1 ;
		this.score = 0 ;
		this.checkin_count = 1 ;
	}

	//guest用(level起始為0)
	public User(String username, String password, int level) {
		super();
		this.username = username;
		this.password = password;
		this.latest_checkin = null;
		this.checkin_week = null;
		this.level = level ;
		this.score = 0 ;
		this.checkin_count = 0 ;
	}
	//m
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getLatest_checkin() {
		return latest_checkin;
	}
	public void setLatest_checkin(String latest_checkin) {
		this.latest_checkin = latest_checkin;
	}
	
	public String getCheckin_week() {
		return checkin_week;
	}
	public void setCheckin_week(String checkin_week) {
		this.checkin_week = checkin_week;
	}
	public int getCheckin_count() {
		return checkin_count;
	}
	public void setCheckin_count(int checkin_count) {
		this.checkin_count = checkin_count;
	}
	@Override
	public int compareTo(User o) {
		return o.getLevel()-this.getLevel();
	}
}
