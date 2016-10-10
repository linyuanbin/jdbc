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
	  //���ݿ�������Ҫ���ݹ���  //������import java.sql.Connection;
	  Connection conn=DBUtil.getConnection();
	  String sql=""+"insert into student1"+"("+"name,birth,sex,age,part,local,entrace,classes"+")"
	  +"values("+"?,?,?,?,?,?,current_date(),?)";  //��ѧ����ֱ����current_date()������ֵ
	  //ִ��sql����   //Ԥ�������
	  PreparedStatement ptmt=conn.prepareStatement(sql);
	  
	  ptmt.setString(1,stu.getName());
	  //������Ҫjava.sql ���͵�date����,��Ϊ���ݿ���dateΪsql��
	  ptmt.setDate(2,new Date(stu.getBirth().getTime()));
	  ptmt.setInt(3,stu.getSex());
	  ptmt.setInt(4,stu.getAge());
	  ptmt.setString(5,stu.getPart());
	  ptmt.setString(6,stu.getLocal());//����
	//��ѧ����ֱ����current_date()������ֵ
	  ptmt.setString(7,stu.getClasses());
	  
	  //����execute()����ʱ������ִ��   �÷���ֻ�����������޸ģ���ɾ��    ��ѯ����
	  ptmt.execute();
  }
  

  
  
  //���¶�Ӧid�Ķ���
  public void update(student stu)throws SQLException{
	  //���ݿ�������Ҫ���ݹ���  //������import java.sql.Connection;
	  Connection conn=DBUtil.getConnection();
	  String sql=" "+" update student1 "+" set name=?,birth=?,sex=?,age=?,part=?,local=?,entrace=?,classes=? "
	  +" where id=? ";  
	  //ִ��sql����   //Ԥ����  
	  PreparedStatement ptmt=conn.prepareStatement(sql);
	  
	
	  ptmt.setString(1,stu.getName());
	  //���ݿ��е�DateΪjava.sql���ͣ�
	  //���ⲿ��DateΪjava.util���ͣ����Դ�������Ҫ����ת����ȡ���Ͳ���ת���ˡ���Ϊutil��sql�ĸ���
	  //������Ҫjava.sql ���͵�date����
	  //java.util.Date date1=stu.getEntrace();
	  ptmt.setDate(2,new Date(stu.getBirth().getTime()));
	  ptmt.setInt(3,stu.getSex());
	  ptmt.setInt(4,stu.getAge());
	  ptmt.setString(5,stu.getPart());
	  ptmt.setString(6,stu.getLocal());//����
	  java.util.Date date2=stu.getEntrace();
	  ptmt.setDate(7,new Date(stu.getBirth().getTime()));
	  ptmt.setString(8,stu.getClasses());
	  ptmt.setInt(9,stu.getId());
	  
	  //����execute()����ʱ������ִ��
	  ptmt.execute();
	
	 
  }
  
  
  
  
  
  public void delete(Integer id)throws SQLException{
	  Connection conn=DBUtil.getConnection();    //ǰ��ӿո񣬷���ᱨ��
	  String sql=""+" delete from student1 "+
	  " where id=? ";  //��ѧ����ֱ����current_date()������ֵ
	  //ִ��sql�ķ���   //Ԥ����
	  PreparedStatement ptmt=conn.prepareStatement(sql);
	  ptmt.setInt(1,id);
	  
	  //����execute()����ʱ������ִ��
	  ptmt.execute(); 
  }
  
  
  
  
  
  //��ѯ������
  public List<student> query()throws Exception{
	  Connection conn=DBUtil.getConnection();
	 //Statement stmt=conn.createStatement();
		StringBuilder sb=new StringBuilder();  //stringBuilder�����ɱ䳤�ַ���  //stringBuffer()
		sb.append("select id,name,age,sex,birth,entrace,part,classes,local from student1"); //׷�ӵ��ַ���β��
	  //java sql����resultset����
		//ResultSet rs=stmt.executeQuery("select id,name,age from student1");
		PreparedStatement ptmt=conn.prepareStatement(sb.toString());
		
		ResultSet rs=ptmt.executeQuery();//�´��ѯָ��
		
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
  
  
  //�����Բ���
  public List<student> query(String name,int id)throws Exception{
	  List<student> gs=new ArrayList<student>();
	  
	  Connection conn=DBUtil.getConnection();
	  StringBuilder sb=new StringBuilder();
	  sb.append("select * from student1 ");
	  
	  sb.append(" where name like ? and id like ? ");
	  PreparedStatement ptmt=conn.prepareStatement(sb.toString());	
	  ptmt.setString(1,"%"+name+"%");//������Ҫ��������������Ҳ��������
	  ptmt.setInt(2,id);
	  //java sql����resultset����
		ResultSet rs=ptmt.executeQuery();
		
		System.out.println(sb.toString());//�����ʽ   
		  
		student s=null;
		while(rs.next()){
			s=new student();
			s.setId(rs.getInt("id"));
			  s.setName(rs.getString("name"));
			  s.setBirth(rs.getDate("birth"));//java.util.date�൱java.sql.date�ĸ��������Ի�����������ת��
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
			   //ƴsql
			   sb.append(" and "+map.get("name")+" "+map.get("rela")+" "+map.get("value")+" ");
		   }
		   
	   }
	 
	  PreparedStatement ptmt=conn.prepareStatement(sb.toString());	
	
	  //java sql����resultset����
		ResultSet rs=ptmt.executeQuery();
		
		System.out.println(sb.toString());//�����ʽ
		
		student s=null;
		while(rs.next()){
			s=new student();
			s.setId(rs.getInt("id"));
			  s.setName(rs.getString("name"));
			  s.setBirth(rs.getDate("birth"));//java.util.date�൱java.sql.date�ĸ��������Ի�����������ת��
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
  
  
  
  
  
  
	//��ѯ����ѧ��ͨ��id
  public student get(Integer id)throws SQLException{
	  Connection conn=DBUtil.getConnection();    //ǰ��ӿո񣬷���ᱨ��
	  String sql=""+" select * from student1 "+
	  " where id=? ";  //��ѧ����ֱ����current_date()������ֵ
	  //ִ��sql����   //Ԥ����
	  PreparedStatement ptmt=conn.prepareStatement(sql);
	  ptmt.setInt(1,id);
	  
	  //��ѯ���ǵ���execute()����
	  ResultSet rs=ptmt.executeQuery();
	  student s=null;
	  while(rs.next()){
		  s=new student();
		  s.setId(rs.getInt("id"));
		  s.setName(rs.getString("name"));
		  s.setBirth(rs.getDate("birth"));//java.util.date�൱java.sql.date�ĸ��������Ի�����������ת��
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
