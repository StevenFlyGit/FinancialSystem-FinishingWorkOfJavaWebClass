package com.wg.wpf.bean;

import java.io.Serializable;


public class Manager implements Serializable{
	
	//基础数据类型

	/** serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** id. */
	private Long id;

	/** name. */
	private String name;
	
	/** phone. */
	private String phone;

	/** sex. */
	private String sex;

	/** age. */
	private Integer age;

	/** idcard. */
	private String idcard;

	/** salary. */
	private String salary;
	
	/** insurance. */
	private String insurance;
	
	/** bonus. */
	private String bonus;

	/** tax. */
	private String tax;
	
	/** position. */
	private String position;
	
	/** email. */
	private String email;
	
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getInsurance() {
		return insurance;
	}

	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}
	
	public String getBonus() {
		return bonus;
	}

	public void setBonus(String bonus) {
		this.bonus = bonus;
	}

	public String getTax() {
		return tax;
	}

	public void setTax(String tax) {
		this.tax = tax;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
