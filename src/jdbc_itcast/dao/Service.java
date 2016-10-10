package jdbc_itcast.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jdbc_itcast.db.DBUtil;
import jdbc_itcast.model.student;


public class Service {
	
  public void add(student stu) throws SQLException{
	  //数据库连接需要传递过来  //包名：import java.sql.Connection;
	  Connection conn=DBUtil.getConnection();
	  String sql=""+"insert into student1"+"("+"name,birth,sex,age,part,local,entrace,classes"+")"
	  +"values("+"?,?,?,?,?,?,current_date(),?)";  //入学日期直接用current_date()函数赋值
	  //执行sql方法   //预编译语句
	  PreparedStatement ptmt=conn.prepareStatement(sql);
	  
	  ptmt.setString(1,stu.getName());
	  //日期需要java.sql 类型的date数据,因为数据库中date为sql型
	  ptmt.setDate(2,new Date(stu.getBirth().getTime()));
	  ptmt.setInt(3,stu.getSex());
	  ptmt.setInt(4,stu.getAge());
	  ptmt.setString(5,stu.getPart());
	  ptmt.setString(6,stu.getLocal());//籍贯
	//入学日期直接用current_date()函数赋值
	  ptmt.setString(7,stu.getClasses());
	  
	  //调用execute()方法时才真正执行   该方法只用于新增，修改，和删除    查询不用
	  ptmt.execute();
  }
  

  
  
  //更新对应id的对象
  public void update(student stu)throws SQLException{
	  //数据库连接需要传递过来  //包名：import java.sql.Connection;
	  Connection conn=DBUtil.getConnection();
	  String sql=" "+" update student1 "+" set name=?,birth=?,sex=?,age=?,part=?,local=?,entrace=?,classes=? "
	  +" where id=? ";  
	  //执行sql方法   //预编译  
	  PreparedStatement ptmt=conn.prepareStatement(sql);
	  
	
	  ptmt.setString(1,stu.getName());
	  //数据库中的Date为java.sql类型，
	  //而外部的Date为java.util类型，所以存入是需要类型转换，取出就不用转换了。因为util是sql的父集
	  //日期需要java.sql 类型的date数据
	  //java.util.Date date1=stu.getEntrace();
	  ptmt.setDate(2,new Date(stu.getBirth().getTime()));
	  ptmt.setInt(3,stu.getSex());
	  ptmt.setInt(4,stu.getAge());
	  ptmt.setString(5,stu.getPart());
	  ptmt.setString(6,stu.getLocal());//籍贯
	  java.util.Date date2=stu.getEntrace();
	  ptmt.setDate(7,new Date(stu.getBirth().getTime()));
	  ptmt.setString(8,stu.getClasses());
	  ptmt.setInt(9,stu.getId());
	  
	  //调用execute()方法时才真正执行
	  ptmt.execute();
	
	 
  }
  
  
  
  
  
  public void delete(Integer id)throws SQLException{
	  Connection conn=DBUtil.getConnection();    //前后加空格，否则会报错
	  String sql=""+" delete from student1 "+
	  " where id=? ";  //入学日期直接用current_date()函数赋值
	  //执行sql的方法   //预编译
	  PreparedStatement ptmt=conn.prepareStatement(sql);
	  ptmt.setInt(1,id);
	  
	  //调用execute()方法时才真正执行
	  ptmt.execute(); 
  }
  
  
  
  
  
  //查询整个表
  public List<student> query()throws Exception{
	  Connection conn=DBUtil.getConnection();
	 //Statement stmt=conn.createStatement();
		StringBuilder sb=new StringBuilder();  //stringBuilder创建可变长字符串  //stringBuffer()
		sb.append("select id,name,age,sex,birth,entrace,part,classes,local from student1"); //追加到字符串尾部
	  //java sql包的resultset方法
		//ResultSet rs=stmt.executeQuery("select id,name,age from student1");
		PreparedStatement ptmt=conn.prepareStatement(sb.toString());
		
		ResultSet rs=ptmt.executeQuery();//下达查询指令
		
		List<student> gs=new ArrayList<student>();
		student s=null;
		while(rs.next()){
			s=new student();
			s.setId(rs.getInt("id"));
			s.setName(rs.getString("name"));
			s.setBirth(rs.getDate("birth"));
			s.setClasses(rs.getString("classes"));
			s.setEntrace(rs.getDate("entrace"));
			s.setAge(rs.getInt("age"));
			s.setLocal(rs.getString("local"));
			s.setPart(rs.getString("part"));
			s.setSex(rs.getInt("sex"));
			gs.add(s);
		}
	  
	  return gs;
  }
  
  
  //按属性查找
  public List<student> query(String name,int id)throws Exception{
	  List<student> gs=new ArrayList<student>();
	  
	  Connection conn=DBUtil.getConnection();
	  StringBuilder sb=new StringBuilder();
	  sb.append("select * from student1 ");
	  
	  sb.append(" where name like ? and id like ? ");
	  PreparedStatement ptmt=conn.prepareStatement(sb.toString());	
	  ptmt.setString(1,"%"+name+"%");//当不需要输入完整的名字也可搜索到
	  ptmt.setInt(2,id);
	  //java sql包的resultset方法
		ResultSet rs=ptmt.executeQuery();
		
		System.out.println(sb.toString());//输出格式   
		  
		student s=null;
		while(rs.next()){
			s=new student();
			s.setId(rs.getInt("id"));
			  s.setName(rs.getString("name"));
			  s.setBirth(rs.getDate("birth"));//java.util.date相当java.sql.date的父集，所以回来不用类型转换
			  s.setSex(rs.getInt("sex"));
			  s.setAge(rs.getInt("age"));
			  s.setPart(rs.getString("part"));
			  s.setLocal(rs.getString("local"));
			  s.setEntrace(rs.getDate("entrace"));
			  s.setClasses(rs.getString("classes"));
			  gs.add(s);
		}
	  
	  return gs;
  }
  
  
  
  
  
  public List<student> query(List<Map<String,Object>> params)throws Exception{
	  List<student> gs=new ArrayList<student>();
	  
	  Connection conn=DBUtil.getConnection();
	  StringBuilder sb=new StringBuilder();
	  sb.append("select * from student1 where 1=1 ");
	 
	   if(params!=null&&params.size()>0){
		   for(int i=0;i<params.size();i++){
			   Map<String,Object> map=params.get(i);
			   //拼sql
			   sb.append(" and "+map.get("name")+" "+map.get("rela")+" "+map.get("value")+" ");
		   }
		   
	   }
	 
	  PreparedStatement ptmt=conn.prepareStatement(sb.toString());	
	
	  //java sql包的resultset方法
		ResultSet rs=ptmt.executeQuery();
		
		System.out.println(sb.toString());//输出格式
		
		student s=null;
		while(rs.next()){
			s=new student();
			s.setId(rs.getInt("id"));
			  s.setName(rs.getString("name"));
			  s.setBirth(rs.getDate("birth"));//java.util.date相当java.sql.date的父集，所以回来不用类型转换
			  s.setSex(rs.getInt("sex"));
			  s.setAge(rs.getInt("age"));
			  s.setPart(rs.getString("part"));
			  s.setLocal(rs.getString("local"));
			  s.setEntrace(rs.getDate("entrace"));
			  s.setClasses(rs.getString("classes"));
			  gs.add(s);
		}
	  
	  return gs;
  }
  
  
  
  
  
  
	//查询单个学生通过id
  public student get(Integer id)throws SQLException{
	  Connection conn=DBUtil.getConnection();    //前后加空格，否则会报错
	  String sql=""+" select * from student1 "+
	  " where id=? ";  //入学日期直接用current_date()函数赋值
	  //执行sql方法   //预编译
	  PreparedStatement ptmt=conn.prepareStatement(sql);
	  ptmt.setInt(1,id);
	  
	  //查询不是调用execute()方法
	  ResultSet rs=ptmt.executeQuery();
	  student s=null;
	  while(rs.next()){
		  s=new student();
		  s.setId(rs.getInt("id"));
		  s.setName(rs.getString("name"));
		  s.setBirth(rs.getDate("birth"));//java.util.date相当java.sql.date的父集，所以回来不用类型转换
		  s.setSex(rs.getInt("sex"));
		  s.setAge(rs.getInt("age"));
		  s.setPart(rs.getString("part"));
		  s.setLocal(rs.getString("local"));
		  s.setEntrace(rs.getDate("entrace"));
		  s.setClasses(rs.getString("classes"));
	  }
	  return s;
  }
	
}
