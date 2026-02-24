package util.tableModel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Rank;
import model.Result;

public class ResultRankTableModel extends AbstractTableModel{
	//f
	private final String[] columns = {"名次","使用者","花費時間","完成時間"};
	private List<Rank<Result>> rankList;//用建構式??
	public static String topic;
	//c
	public ResultRankTableModel(List<Rank<Result>> rankList) {
		super();
		this.rankList = rankList;
	}
	//m
	@Override
	public String getColumnName(int column)
	{
		return columns[column];
	}
	@Override
	public Class<?> getColumnClass(int columnIndex)
	{
		switch(columnIndex) {
			case 0: return String.class;
			case 1: return String.class;
			case 2: return String.class;
			case 3: return String.class;
			default: return Object.class;
		}
	}
	public void setRankList(List<Rank<Result>> list)
	{
		rankList = (list==null) ? new ArrayList() : new ArrayList(list);
		fireTableDataChanged();
	}
	@Override
	public int getRowCount() {
		return rankList.size();
	}

	@Override
	public int getColumnCount() {
		return columns.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Rank<Result> r=rankList.get(rowIndex);
		switch(columnIndex)
		{
			case 0:return r.getShow();
			case 1:return r.getObject().getUsername();
			case 2:return r.getObject().getTime_spend();
			case 3:return r.getObject().getTime_now();
			default: return null;
		}
	}
}