package com.xiaolangn.bean;

import java.util.Date;


public class Order {

    private Integer id;
    
	private String orderType;
	
	private String identificationType;
	
	private String identificationNumber;
	
    private String realName;
    
	private String nationality;
	
	private String contacts;
	
	private String phoneNum;
	
    private Integer orderPrice;
    
	private String orderNotice;
	
	private Date orderSaveTime;
	
	private Integer isPay;

	private Integer userId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrderType() {
		return orderType;
	}

	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}

	public String getIdentificationType() {
		return identificationType;
	}

	public void setIdentificationType(String identificationType) {
		this.identificationType = identificationType;
	}

	public String getIdentificationNumber() {
		return identificationNumber;
	}

	public void setIdentificationNumber(String identificationNumber) {
		this.identificationNumber = identificationNumber;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getContacts() {
		return contacts;
	}

	public void setContacts(String contacts) {
		this.contacts = contacts;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public Integer getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(Integer orderPrice) {
		this.orderPrice = orderPrice;
	}

	public String getOrderNotice() {
		return orderNotice;
	}

	public void setOrderNotice(String orderNotice) {
		this.orderNotice = orderNotice;
	}

	public Date getOrderSaveTime() {
		return orderSaveTime;
	}

	public void setOrderSaveTime(Date orderSaveTime) {
		this.orderSaveTime = orderSaveTime;
	}

	public Integer getIsPay() {
		return isPay;
	}

	public void setIsPay(Integer isPay) {
		this.isPay = isPay;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
}
