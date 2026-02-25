package model;

import java.io.Serializable;
import java.time.LocalTime;

import util.Tool;

public class Result implements Serializable,Comparable<Result>{
	//f
	private int id;
	private String username;
	private String time_spend;
	private String time_now;
	private int map_level;
	//c
	public Result() {
		super();
	}
	public Result(String username, String time_spend, int map_level) {
		super();
		this.username = username;
		this.time_spend = time_spend;
		this.time_now = Tool.dateTime();
		this.map_level = map_level;
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

	public String getTime_spend() {
		return time_spend;
	}

	public void setTime_spend(String time_spend) {
		this.time_spend = time_spend;
	}

	public String getTime_now() {
		return time_now;
	}

	public void setTime_now(String time_now) {
		this.time_now = time_now;
	}

	public int getMap_level() {
		return map_level;
	}

	public void setMap_level(int map_level) {
		this.map_level = map_level;
	}
	@Override
	public int compareTo(Result o) {
		return LocalTime.parse(this.getTime_spend()).compareTo(LocalTime.parse(o.getTime_spend()));
	}
}
