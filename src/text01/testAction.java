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
		stu.setName("��С�");
		stu.setAge(501);
		stu.setSex(0);
		//�˴�DateΪ java.util ����
		stu.setBirth(new Date());
		stu.setClasses("301");
		stu.setLocal("����");
		stu.setPart("ҽѧѧԺ");
	//  action.add(stu);	//����  
	  
	  //stu.setId(10);
	  //action.edit(stu);//�޸�
	  
	  //action.del(11);  //ɾ��
	  
	  
	  /*//��ѯ����
	    List<student> result=action.query();
	  
	  for(int i=0;i<result.size();i++){
		  
		  System.out.println(result.get(i).getId()+":"+result.get(i).getName()+":"+result.get(i).getAge());
	  }
	  */
		
		//�����Բ���
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
