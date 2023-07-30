package com.wg.wpf.bean;

import java.io.Serializable;


public class Workers implements Serializable{
	
	//基础数据类型

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** id. */
	private Long id;

	/** name. */
	private String name;

	/** password. */
	private String password;

	/** realname. */
	private String realname;

	/** age. */
	private Integer age;

	/** sex. */
	private String sex;
	
	/** salary. */
	private Float salary;

	/** phone. */
	private String phone;

	/** email. */
	private String email;

	/** dtype. */
	private String dtype;
	
	//get和set方法

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Float getSalary() {
		return salary;
	}

	public void setSalary(Float salary) {
		this.salary = salary;
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDtype() {
		return dtype;
	}

	public void setDtype(String dtype) {
		this.dtype = dtype;
	}
	
}
