package jdbc_itcast.model;

import java.util.Date;

//�Ӿ���

public class student {
private Integer id;//ѧ��
private Date birth;
private String name;
private Integer sex;
private Integer age;
private String part;//ѧԺ
private String local;//����
private Date entrace;//��ѧʱ��
private String classes;


public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public Date getBirth() {
	return birth;
}
public void setBirth(Date birth) {
	this.birth = birth;
}
public Integer getSex() {
	return sex;
}
public void setSex(Integer sex) {
	this.sex = sex;
}
public Integer getAge() {
	return age;
}
public void setAge(Integer age) {
	this.age = age;
}
public String getPart() {
	return part;
}
public void setPart(String part) {
	this.part = part;
}
public String getLocal() {
	return local;
}
public void setLocal(String local) {
	this.local = local;
}
public Date getEntrace() {
	return entrace;
}
public void setEntrace(Date entrace) {
	this.entrace = entrace;
}
public String getClasses() {
	return classes;
}
public void setClasses(String classes) {
	this.classes = classes;
}

public String toString() {
	return "student [id=" + id + ", ����=" + birth + ", ����=" + name
			+ ", �Ա�=" + sex + ", ����=" + age + ", ѧԺ=" + part + ", ����="
			+ local + ", ��ѧʱ��" + entrace + ", ���ڰ༶=" + classes + "]";
}


}
