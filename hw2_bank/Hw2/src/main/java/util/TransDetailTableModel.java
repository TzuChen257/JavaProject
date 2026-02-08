package util;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import vo.View01;

public class TransDetailTableModel extends AbstractTableModel{
	//field
	private final String[] columns = {"帳戶","收入","支出","餘額","交易時間"};
	private List<View01> data=new ArrayList<>();
	//method
	public String getColumnName(int column)
	{
		return columns[column];
	}
	public Class<?> getColumnClass(int columnIndex)
	{
		switch(columnIndex) {
			case 0: return String.class;
			case 1: return String.class;
			case 2: return String.class;
			case 3: return Integer.class;
			case 4: return String.class;
			default: return Object.class;
		}
	}
	public void setData(List<View01> list)
	{
		data = (list==null) ? new ArrayList() : new ArrayList(list);
		fireTableDataChanged();
	}
	//imple method
	@Override
	public int getRowCount() {
		return data.size();
	}
	@Override
	public int getColumnCount() {
		return columns.length;
	}
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		View01 v=data.get(rowIndex);
		switch(columnIndex) {
			case 0: return v.getSubject_account();
			case 1: return v.getIncome();
			case 2: return v.getExpenses();
			case 3: return v.getBalance_now();
			case 4: return v.getTrading_time();
			default: return null;
		}
	}
	
}
