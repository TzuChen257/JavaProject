package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.text.NumberFormatter;


public class Tool {

	public static void main(String[] args) {
		//test_connection
		//Tool.getDb();
		//test_time
		//System.out.println(Tool.Time());
		//save
		//Tool.saveAccount(new Account("13248544546","541234",1000,"75.04.05","N156875451","Taipei","09132542748"));
		//Tool.saveTradeActivity(2);
		//read
		//System.out.println(Tool.readAccount());
		//System.out.println(Tool.readTrade());
		//System.out.println(Tool.addDate());
	}
	//numberFormate
	public static NumberFormatter numFormat()
	{
		NumberFormat format=NumberFormat.getInstance();//當下判斷
		format.setMaximumFractionDigits(0);//整數
		format.setMinimumFractionDigits(0);
		format.setGroupingUsed(false);//不要逗點顯示
		NumberFormatter formatter=new NumberFormatter(format);
		formatter.setAllowsInvalid(false);//不可以輸入數字以外
		formatter.setCommitsOnValidEdit(true);//編輯有效及時提交
		return formatter;
	}
	//date for 流水號
	public static String addDate()
	{
		return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"));
	}
	//trading time
	public static String Time()
	{
		String time=null;
		LocalDateTime now=LocalDateTime.now();
		DateTimeFormatter customFormat=DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		time=now.format(customFormat);
		//String time=LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
		return time;
	}
	//database connection
	public static Connection getDb()
	{
		Connection conn=null;
		String sql="jdbc:mysql://localhost:3306/hw2_bank";
		String user="root";
		String password="1234";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection(sql, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("no Driver");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("no connection");
			e.printStackTrace();
		}
		return conn;
	}
	//temp_save
	public static void saveObject(Object object, String fileName)
	{
		try {
			FileOutputStream fos=new FileOutputStream(fileName+".txt");
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(object);
		} catch (FileNotFoundException e) {
			System.out.println("無存取權限");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("存入有誤");
			e.printStackTrace();
		}
	}
	public static void saveTradeActivity(int trade_activity)
	{
		try {
			FileOutputStream fos = new FileOutputStream("Trade.txt");
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			osw.write(trade_activity);
			osw.close();
		} catch (FileNotFoundException e) {
			System.out.println("無存取權限");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("存入有誤");
			e.printStackTrace();
		}
	}
	//temp_read
	public static Object readObject(String fileName)
	{
		Object object=null;
		try {
			FileInputStream fis=new FileInputStream(fileName+".txt");
			ObjectInputStream ois=new ObjectInputStream(fis);
			object=ois.readObject();
		} catch (FileNotFoundException e) {
			System.out.println("無讀取權限");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("寫出有誤");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("查無此類別");
			e.printStackTrace();
		}
		return object;
	}
	public static int readTrade()
	{
		int trade_activity=0;
		try {
			FileInputStream fis=new FileInputStream("Trade.txt");
			InputStreamReader isr=new InputStreamReader(fis);
			trade_activity=isr.read();
		} catch (FileNotFoundException e) {
			System.out.println("無讀取權限");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("寫出有誤");
			e.printStackTrace();
		}
		return trade_activity;
	}
}
