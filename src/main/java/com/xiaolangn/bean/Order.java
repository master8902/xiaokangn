package com.xiaolangn.bean;

import java.text.DecimalFormat;
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
	
    private Double orderPrice;
    
	private String orderNotice;
	
	private Date orderSaveTime;
	
	private Integer isPay;

	private Integer userId;
	
	private Integer productid;
	
	private Date tradeTime;
	
	private String tradeOddNum;
	
	private String businessOddNum;
	
	private String businessName;
	
	private String openid;
	private Date createTime;
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

	public Double getOrderPrice() {
		return orderPrice;
	}

	public void setOrderPrice(Double orderPrice) {
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

	public Integer getProductid() {
		return productid;
	}

	public void setProductid(Integer productid) {
		this.productid = productid;
	}

	public Date getTradeTime() {
		return tradeTime;
	}

	public void setTradeTime(Date tradeTime) {
		this.tradeTime = tradeTime;
	}

	public String getTradeOddNum() {
		return tradeOddNum;
	}

	public void setTradeOddNum(String tradeOddNum) {
		this.tradeOddNum = tradeOddNum;
	}

	public String getBusinessOddNum() {
		return businessOddNum;
	}

	public void setBusinessOddNum(String businessOddNum) {
		this.businessOddNum = businessOddNum;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
}
