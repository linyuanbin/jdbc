package jdbc_View;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import jdbc_itcast.action.Action;
import jdbc_itcast.model.student;


//��ͼ��

public class View {

	private static String CONTEXT="��ӭ��¼ѧ���ۺϹ���ϵͳ :\n"+
			"������ѧ��ϵͳ�����б�:\n"+"[MAIN/M]:���˵�\n"+
			"[QUERY/Q]:�鿴ѧ��ȫ����Ϣ\n"+
			"[GET/G]:�鿴����ѧ����Ϣ\n"+
			"[ADD/A]:���ѧ��"+
			"[UPDATE/U]:����ѧ����Ϣ\n"+
			"[DALETE/D]:=ɾ��ѧ��\n"+
			"[SEARCH/S]:�鿴ѧ����Ϣ������ �����������ߡ�id����\n"+
			"[EXIT/E]:�Ƴ�ϵͳ"+
			"[BREAK/B]:�������˵�";
	
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
		
		//ʹ����һֱ��������    ����ѭ��
		Scanner scan=new Scanner(System.in);
		student stu=new student();
		Action action=new Action();
		String prenious=null;//�������
		Integer step=1;//������
		Integer de=1;//ɾ��������
		while(scan.hasNext()){
			String in=scan.next().toString();           //ת����д
			if(OPERATION_EXIT.equals(in.toUpperCase())
					||OPERATION_EXIT.substring(0,1).equals(in.toUpperCase())){
				System.out.println("�Ƴ�ϵͳ�ɹ���");
				break;
			}else if(OPERATION_UPDATE.equals(in.toUpperCase())//�޸�
					||OPERATION_UPDATE.substring(0,1).equals(in.toUpperCase())
					||OPERATION_UPDATE.equals(prenious)){
				prenious=OPERATION_UPDATE;
				
				
				
				
			}else if(OPERATION_MAIN.equals(in.toUpperCase()) //������ҳ��
					||OPERATION_MAIN.substring(0,1).equals(in.toUpperCase())){
				System.out.println(CONTEXT);
			}
			
			
			else if(OPERATION_DALETE.equals(in.toUpperCase())
					||OPERATION_DALETE.substring(0,1).equals(in.toUpperCase())
					||OPERATION_DALETE.equals(prenious)){
				prenious=OPERATION_DALETE;
				//ɾ��
				if(1==de){
				System.out.println("��������Ҫɾ����ѧ����ѧ�ţ�");
				}
				if(2==de){
				try {
					action.del(Integer.valueOf(in));
					System.out.println("ɾ���ɹ���");
					System.out.println(CONTEXT);
					//if(3==de)prenious=in;
					
				} catch (NumberFormatException e) {
					e.printStackTrace();
					System.out.println("ɾ��ʧ�ܣ�");
				} catch (SQLException e) {
					e.printStackTrace();
					System.out.println("ɾ��ʧ�ܣ�");
				}
				}
				de++;
				
			}
			
			else if(OPERATION_QUERY.equals(in.toUpperCase())
					||OPERATION_QUERY.substring(0,1).equals(in.toUpperCase())){
				  //��ѯȫ��
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
					||OPERATION_ADD.equals(prenious)){//���������ģ��
				prenious=OPERATION_ADD;
				//����
				if(1==step){
				System.out.println("������ѧ���ġ�������:");
				}else if(2==step){
					stu.setName(in);
					System.out.println("������ѧ�������ա�:,��ʽΪ��yyy-mmm-ddd");
				}else if(3==step){
                 SimpleDateFormat sf=new SimpleDateFormat("yyy-mmm-ddd");
                 Date birthday=null;
				try {
					birthday = sf.parse(in);
	                 stu.setBirth(birthday);
                    System.out.println("������ѧ�����Ա𡿣�");
				} catch (ParseException e) {
					//e.printStackTrace();
					System.out.println("����������ڸ�ʽ�������������룺");
					step=2;//���ں������������Ҫ�ټ�һ��
				}
				}else if(4==step){
					stu.setSex(Integer.valueOf(in));
					System.out.println("������ѧ�������䡿��");
				}else if(5==step){
					stu.setAge(Integer.valueOf(in));
					System.out.println("������ѧ��������ѧԺ����");
				}else if(6==step){
					stu.setPart(in);
					System.out.println("������ѧ�������᡿��");
				}else if(7==step){
					stu.setLocal(in);
					System.out.println("������ѧ�������ڰ༶����");
				}else if(8==step){
					stu.setClasses(in);
					
					try {
						action.add(stu);
						System.out.println("��ӳɹ���");
						System.out.println(CONTEXT);//������ҳ��
						//prenious=in;
						
					} catch (SQLException e) {
						//e.printStackTrace();
						System.out.println("���ʧ�ܣ�");
					}
				}
				if(OPERATION_ADD.equals(prenious)){
					step++;
				}
			}/*else {
			System.out.println("�������ֵΪ��"+in);
			}	*/		
		}
	}
}
