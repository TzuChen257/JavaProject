package model;

public class Rank<T> {
	//f
	private T object;
	private int rank;
	private String show;//rank、未上榜
	//c
	public Rank(T object, int rank) {
		super();
		this.object = object;
		this.rank = rank;
		this.show = String.valueOf(rank);
	}
	//m
	public T getObject() {
		return object;
	}
	public void setObject(T object) {
		this.object = object;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public String getShow() {
		return show;
	}
	public void setShow(String show) {
		this.show = show;
	}
}
