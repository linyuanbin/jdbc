package jdbc_View;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import jdbc_itcast.action.Action;
import jdbc_itcast.model.student;


//视图层

public class View {

	private static String CONTEXT="欢迎登录学生综合管理系统 :\n"+
			"下面是学生系统功能列表:\n"+"[MAIN/M]:主菜单\n"+
			"[QUERY/Q]:查看学生全部信息\n"+
			"[GET/G]:查看单个学生信息\n"+
			"[ADD/A]:添加学生"+
			"[UPDATE/U]:更新学生信息\n"+
			"[DALETE/D]:=删除学生\n"+
			"[SEARCH/S]:查看学生信息（根据 【姓名】或者【id】）\n"+
			"[EXIT/E]:推出系统"+
			"[BREAK/B]:返回主菜单";
	
	private static final String OPERATION_MAIN="MAIN";
	private static final String OPERATION_QUERY="QUERY";
	private static final String OPERATION_GET="GET";
	private static final String OPERATION_ADD="ADD";
	private static final String OPERATION_UPDATE="UPDATE";
	private static final String OPERATION_DALETE="DALETE";
	private static final String OPERATION_SEARCH="SEARCH";
	private static final String OPERATION_EXIT="EXIT";
	private static final String OPERATION_BREAK="BREAK";
	
	public static void main(String[] args) {
		
		System.out.println(CONTEXT);
		
		//使程序一直保持运行    用贞循环
		Scanner scan=new Scanner(System.in);
		student stu=new student();
		Action action=new Action();
		String prenious=null;//记忆变量
		Integer step=1;//步骤标记
		Integer de=1;//删除步骤标记
		while(scan.hasNext()){
			String in=scan.next().toString();           //转换大写
			if(OPERATION_EXIT.equals(in.toUpperCase())
					||OPERATION_EXIT.substring(0,1).equals(in.toUpperCase())){
				System.out.println("推出系统成功！");
				break;
			}else if(OPERATION_UPDATE.equals(in.toUpperCase())//修改
					||OPERATION_UPDATE.substring(0,1).equals(in.toUpperCase())
					||OPERATION_UPDATE.equals(prenious)){
				prenious=OPERATION_UPDATE;
				
				
				
				
			}else if(OPERATION_MAIN.equals(in.toUpperCase()) //返回主页面
					||OPERATION_MAIN.substring(0,1).equals(in.toUpperCase())){
				System.out.println(CONTEXT);
			}
			
			
			else if(OPERATION_DALETE.equals(in.toUpperCase())
					||OPERATION_DALETE.substring(0,1).equals(in.toUpperCase())
					||OPERATION_DALETE.equals(prenious)){
				prenious=OPERATION_DALETE;
				//删除
				if(1==de){
				System.out.println("请输入需要删除的学生的学号：");
				}
				if(2==de){
				try {
					action.del(Integer.valueOf(in));
					System.out.println("删除成功！");
					System.out.println(CONTEXT);
					//if(3==de)prenious=in;
					
				} catch (NumberFormatException e) {
					e.printStackTrace();
					System.out.println("删除失败！");
				} catch (SQLException e) {
					e.printStackTrace();
					System.out.println("删除失败！");
				}
				}
				de++;
				
			}
			
			else if(OPERATION_QUERY.equals(in.toUpperCase())
					||OPERATION_QUERY.substring(0,1).equals(in.toUpperCase())){
				  //查询全部
				try {
					List<student> list=action.query();
					for(student s:list){
					System.out.println(s.toString());
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
			}else if(OPERATION_ADD.equals(in.toUpperCase())
					||OPERATION_ADD.substring(0,1).equals(in.toUpperCase())
					||OPERATION_ADD.equals(prenious)){//保持在添加模块
				prenious=OPERATION_ADD;
				//新增
				if(1==step){
				System.out.println("请输入学生的【姓名】:");
				}else if(2==step){
					stu.setName(in);
					System.out.println("请输入学生【生日】:,格式为：yyy-mmm-ddd");
				}else if(3==step){
                 SimpleDateFormat sf=new SimpleDateFormat("yyy-mmm-ddd");
                 Date birthday=null;
				try {
					birthday = sf.parse(in);
	                 stu.setBirth(birthday);
                    System.out.println("请输入学生【性别】：");
				} catch (ParseException e) {
					//e.printStackTrace();
					System.out.println("您输入的日期格式有误，请重新输入：");
					step=2;//由于后面的自增所以要少加一吃
				}
				}else if(4==step){
					stu.setSex(Integer.valueOf(in));
					System.out.println("请输入学生【年龄】：");
				}else if(5==step){
					stu.setAge(Integer.valueOf(in));
					System.out.println("请输入学生【所在学院】：");
				}else if(6==step){
					stu.setPart(in);
					System.out.println("请输入学生【籍贯】：");
				}else if(7==step){
					stu.setLocal(in);
					System.out.println("请输入学生【所在班级】：");
				}else if(8==step){
					stu.setClasses(in);
					
					try {
						action.add(stu);
						System.out.println("添加成功！");
						System.out.println(CONTEXT);//返回主页面
						//prenious=in;
						
					} catch (SQLException e) {
						//e.printStackTrace();
						System.out.println("添加失败！");
					}
				}
				if(OPERATION_ADD.equals(prenious)){
					step++;
				}
			}/*else {
			System.out.println("您输入的值为："+in);
			}	*/		
		}
	}
}
