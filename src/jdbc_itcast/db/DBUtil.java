package jdbc_itcast.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//�ṩ���ݿ����ӵĹ�����
public class DBUtil {                                                    //�ַ�����utf8  �������ַ�����utf8��������
	private static final String URL="jdbc:mysql://127.0.0.1:3306/student?characterEncoding=utf8";
	private static final String NAME="root";
	private static final String PASSWORD="";
	
	private static Connection conn=null;

	//��̬����
	static{
		try {
			//1������������
			Class.forName("com.mysql.jdbc.Driver");
			//Class.forName("sum.jdbc.odbc.JdbcOdbcDriver");	������
					//2��ȡ���ݿ������
			conn=DriverManager.getConnection(URL,NAME,PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	//�ṩ���ݿ�����
	public static Connection getConnection(){
		return conn;
		
	}
		
	/*
	public static void main(String []args)throws Exception{
		//Connection conn=null;
		//1������������
		Class.forName("com.mysql.jdbc.Driver");
		
		//2��ȡ���ݿ������
		conn=DriverManager.getConnection(URL,NAME,PASSWORD);
		
		//3ͨ�����ݿ�����Ӳ������ݿ⣬ʵ����ɾ�Ĳ�
		Statement stmt= conn.createStatement();
		//java sql����resultset����
		ResultSet rs=stmt.executeQuery("select name,id,age from student1");
		
		while(rs.next()){
			System.out.println(rs.getString("name")+","+rs.getInt("id")+","+rs.getInt("age"));
			
			
		}
	}
	*/
	
}

