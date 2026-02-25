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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class Tool {

	public static void main(String[] args) {
		Tool.getDB();
	}
	//self-design methods
	//get connection
	public static Connection getDB()
	{
		//DriverManager sql
		String sql="jdbc:mysql://localhost:3306/hw3_bomp";
		String user="root";
		String password="1234";
		//DriverManager to Connection
		Connection conn=null;
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
	//record time
	public static String dateTime()
	{
		return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
	}
	public static String loginDate()
	{
		return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
	}
	//saveObject
	public static void saveObject(Object object,String fileName)
	{
		try {
			FileOutputStream fos=new FileOutputStream(fileName+".txt");
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(object);
		} catch (FileNotFoundException e) {
			System.out.println("no saving access");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("fail to writeObject");
			e.printStackTrace();
		}
	}
	//readObject
	public static Object readObject(String fileName)
	{
		Object object=null;
		try {
			FileInputStream fis=new FileInputStream(fileName+".txt");
			ObjectInputStream ois=new ObjectInputStream(fis);
			object=ois.readObject();
		} catch (FileNotFoundException e) {
			System.out.println("nothing to read");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("fail to readObject");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("no such class");
			e.printStackTrace();
		}
		return object;
	}
	//level跳轉
	public static void saveLevel(int level)
	{
		try {
			FileOutputStream fos = new FileOutputStream("Level.txt");
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			osw.write(level);
			osw.close();
		} catch (FileNotFoundException e) {
			System.out.println("無存取權限");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("存入有誤");
			e.printStackTrace();
		}
	}
	public static int readLevel()
	{
		int level=0;
		try {
			FileInputStream fis=new FileInputStream("Level.txt");
			InputStreamReader isr=new InputStreamReader(fis);
			level=isr.read();
		} catch (FileNotFoundException e) {
			System.out.println("無讀取權限");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("寫出有誤");
			e.printStackTrace();
		}
		return level;
	}
}
