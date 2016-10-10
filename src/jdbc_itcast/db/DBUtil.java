package jdbc_itcast.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//提供数据库连接的工具类
public class DBUtil {                                                    //字符类型utf8  不声明字符编码utf8汉字乱码
	private static final String URL="jdbc:mysql://127.0.0.1:3306/student?characterEncoding=utf8";
	private static final String NAME="root";
	private static final String PASSWORD="";
	
	private static Connection conn=null;

	//静态语句块
	static{
		try {
			//1加载驱动程序
			Class.forName("com.mysql.jdbc.Driver");
			//Class.forName("sum.jdbc.odbc.JdbcOdbcDriver");	不可用
					//2获取数据库的链接
			conn=DriverManager.getConnection(URL,NAME,PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	//提供数据库连接
	public static Connection getConnection(){
		return conn;
		
	}
		
	/*
	public static void main(String []args)throws Exception{
		//Connection conn=null;
		//1加载驱动程序
		Class.forName("com.mysql.jdbc.Driver");
		
		//2获取数据库的链接
		conn=DriverManager.getConnection(URL,NAME,PASSWORD);
		
		//3通过数据库的链接操作数据库，实现增删改查
		Statement stmt= conn.createStatement();
		//java sql包的resultset方法
		ResultSet rs=stmt.executeQuery("select name,id,age from student1");
		
		while(rs.next()){
			System.out.println(rs.getString("name")+","+rs.getInt("id")+","+rs.getInt("age"));
			
			
		}
	}
	*/
	
}

