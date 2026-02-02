package util;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.swing.Timer;

import model.Account;
import model.Administrator;
import model.TransactionDetail;

public class Tool {

	public static void main(String[] args) {
		//test_connection
		//Tool.getDb();
		//test_time
		//System.out.println(Tool.Time());
		//save
		//Tool.saveAccount(new Account("13248544546","541234",1000,"75.04.05","N156875451","Taipei","09132542748"));
		//read
		//System.out.println(Tool.readAccount());
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
	//timer??????
	/*
	public static String TimeRun()
	{
		String timenow=null;
		Timer timer=new Timer(1000, (ActionListener) new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						String time=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());
					}
				});
		timer.start();
		return timenow;
	}
	*/
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
	public static void saveAccount(Account account)
	{
		try {
			FileOutputStream fos=new FileOutputStream("Account.txt");
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(account);
		} catch (FileNotFoundException e) {
			System.out.println("無存取權限");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("存入有誤");
			e.printStackTrace();
		}
	}
	public static void saveAdmin(Administrator admin)
	{
		try {
			FileOutputStream fos=new FileOutputStream("Admin.txt");
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(admin);
		} catch (FileNotFoundException e) {
			System.out.println("無存取權限");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("存入有誤");
			e.printStackTrace();
		}
	}
	public static void saveDetail(TransactionDetail detail)
	{
		try {
			FileOutputStream fos = new FileOutputStream("Detail.txt");
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(detail);
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
		} catch (FileNotFoundException e) {
			System.out.println("無存取權限");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("存入有誤");
			e.printStackTrace();
		}
	}
	//temp_save_read
	public static Account readAccount()
	{
		Account account=null;
		try {
			FileInputStream fis=new FileInputStream("Account.txt");
			ObjectInputStream ois=new ObjectInputStream(fis);
			account=(Account) ois.readObject();
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
		return account;
	}
	public static Administrator readAdmin()
	{
		Administrator admin=null;
		try {
			FileInputStream fis=new FileInputStream("Admin.txt");
			ObjectInputStream ois=new ObjectInputStream(fis);
			admin=(Administrator) ois.readObject();
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
		return admin;
	}
	public static TransactionDetail readDetail()
	{
		TransactionDetail detail=null;
		try {
			FileInputStream fis=new FileInputStream("Detail.txt");
			ObjectInputStream ois=new ObjectInputStream(fis);
			detail=(TransactionDetail) ois.readObject();
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
		return detail;
	}
	public static int readTrade()
	{
		int trade_activity=0;
		try {
			FileInputStream fis=new FileInputStream("Trade.txt");
			InputStreamReader isr=new InputStreamReader(fis);
			isr.read();
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
