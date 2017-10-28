package com.cn.shop.domain;

import java.io.Serializable;
import javax.persistence.*;



@Entity
@Table(name = "store_user")
public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7984727386031171642L;

	@Id
    @GeneratedValue
    private Long id;

	

	@Column(name = "name")
	private String name; //用户名
	
	@Column(name = "password")
	private  String password; //密码
	
	@Column(name = "address")
	private String address; //地址
	
	@Column(name = "postCode")
	private String postCode; //邮编
	
	@Column(name = "email")
	private String email; //email地址
	
	@Column(name = "homePhone")
	private String homePhone;// 家庭电话号码
	
	@Column(name = "cellPhone")
	private String cellPhone; //手机号码
	
	@Column(name = "officePhone")
	private String officePhone; //办公室电话号码
	
	@Column(name = "type")
	private String type; //办公室电话号码
	
	@Column(name = "workNo")
	private String workNo; //办公室电话号码
	
	
	
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	public String getOfficePhone() {
		return officePhone;
	}

	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getWorkNo() {
		return workNo;
	}

	public void setWorkNo(String workNo) {
		this.workNo = workNo;
	}
}
