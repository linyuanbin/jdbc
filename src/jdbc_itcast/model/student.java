package jdbc_itcast.model;

import java.util.Date;

//视觉类

public class student {
private Integer id;//学号
private Date birth;
private String name;
private Integer sex;
private Integer age;
private String part;//学院
private String local;//籍贯
private Date entrace;//入学时间
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
	return "student [id=" + id + ", 生日=" + birth + ", 姓名=" + name
			+ ", 性别=" + sex + ", 年龄=" + age + ", 学院=" + part + ", 籍贯="
			+ local + ", 入学时间" + entrace + ", 所在班级=" + classes + "]";
}


}
