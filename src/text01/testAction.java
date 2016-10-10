package text01;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jdbc_itcast.action.Action;
import jdbc_itcast.model.student;

public class testAction {
  public static void main(String []args) throws Exception{
	  Action action=new Action();
	 
	  
	  student stu=new student();
		stu.setName("李小璐");
		stu.setAge(501);
		stu.setSex(0);
		//此处Date为 java.util 类型
		stu.setBirth(new Date());
		stu.setClasses("301");
		stu.setLocal("福州");
		stu.setPart("医学学院");
	//  action.add(stu);	//新增  
	  
	  //stu.setId(10);
	  //action.edit(stu);//修改
	  
	  //action.del(11);  //删除
	  
	  
	  /*//查询所有
	    List<student> result=action.query();
	  
	  for(int i=0;i<result.size();i++){
		  
		  System.out.println(result.get(i).getId()+":"+result.get(i).getName()+":"+result.get(i).getAge());
	  }
	  */
		
		//按属性查找
		List<Map<String,Object>> params=new ArrayList<Map<String,Object>>();
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("name","name");
		map.put("rela", "=");
		map.put("value", "'lin'");
		
		params.add(map);
		List<student> result=action.query(params);
		for(int i=0;i<result.size();i++){
			  
			  System.out.println(result.get(i).getId()+":"+result.get(i).getName()+":"+result.get(i).getAge());
		  }
  }
	
	
}
