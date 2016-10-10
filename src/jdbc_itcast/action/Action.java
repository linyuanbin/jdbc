package jdbc_itcast.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jdbc_itcast.dao.Service;
import jdbc_itcast.model.student;

//控制层
public class Action {
	
	public void add(student stu) throws SQLException{
		Service s=new Service(); 
		s.add(stu);
	}
	
	//获得单个
	public student get(Integer id) throws SQLException{
		Service s=new Service();
		return s.get(id);
	}
	
	
	public void edit(student stu) throws SQLException{
		Service s=new Service();
		s.update(stu);
	}
	
	
	public void del(Integer id) throws SQLException{
		Service s=new Service();
		s.delete(id);
	}
	
	//查询全部
	public List<student> query() throws Exception{
		Service s=new Service();
		return s.query();
	}
	
	
	public List<student> query(List<Map<String,Object>> params) throws Exception{
		Service s=new Service();
		return s.query(params);
	}
	
	
	

	/*
	public static void main(String[] args)throws Exception{
	
		Service s=new Service(); 
		List<student> gs=s.query(); 
		for(student stu:gs){
			System.out.println(stu.getName()+","+stu.getAge());
		}
		
		
		
		Service s=new Service();
		student stu=new student();
		stu.setName("李小璐");
		stu.setAge(56);
		stu.setSex(1);
		//此处Date为 java.util 类型
		stu.setBirth(new Date());
		stu.setClasses("150");
		stu.setLocal("福州");
		stu.setPart("会计学院");
		
		
		//stu.setId(6); 
		//s.delete(5);
		//s.update(stu); 
		//s.add(stu);//添加不需要id
		//s.get(2);
		
		//查找全部
		List<student> stu1=s.query();
		System.out.println(stu1.toString());
		
		
		
		//用get()查找
		student stu2=s.get(2);
		System.out.println(stu2.toString());
		
		
		
		//属性查询
		List<student> gs=s.query("lin",1);
		for(int i=0;i<gs.size();i++){
			System.out.println(gs.get(i).toString());
		}
		
		
		
		List<Map<String,Object>> params=new ArrayList<Map<String,Object>>();
		Map<String,Object> param= new HashMap<String, Object>();
		param.put("name","name");
		param.put("rela","like");  //param.put("rela","=");
		param.put("value","'%lin%'");
		params.add(param);
		//List<student> gs=s.query(params);
		
		param= new HashMap<String, Object>();
		param.put("name","id");
		param.put("rela","=");  //param.put("rela","=");
		param.put("value","1");
		params.add(param);
		List<student> gs=s.query(params);
		for(int i=0;i<gs.size();i++){
			System.out.println(gs.get(i).toString());
		}
	} */

}
