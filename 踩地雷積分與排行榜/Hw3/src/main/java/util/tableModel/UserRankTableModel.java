package util.tableModel;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Rank;
import model.User;

public class UserRankTableModel extends AbstractTableModel{
	//f
	private final String[] columns = {"名次","使用者","等級"};
	private List<Rank<User>> rankList;
	public final String topic="全玩家排行";
	//c
	public UserRankTableModel(List<Rank<User>> rankList) {
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
			default: return Object.class;
		}
	}
	public void setRankList(List<Rank<User>> list)
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
		Rank<User> r=rankList.get(rowIndex);
		switch(columnIndex)
		{
			case 0:return r.getShow();
			case 1:return r.getObject().getUsername();
			case 2:return r.getObject().getLevel();
			default: return null;
		}
	}

}
