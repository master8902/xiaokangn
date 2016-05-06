package com.xiaolangn.bean;

import java.sql.Date;


public class Product {

    private Integer id;
    private String chineseName;
    private String englishName;
    private Integer type;
    private String title;
    private Date startDate;
    private Date endDate;
    private Integer ishot;
    private Double price;
    private Integer totalSeat;
	private Integer saleSeat;
	private String explain;
    private String favorable;
	private String picture_url;
	private String notice;
	private String costContain;
	private String costUncomtain;
	private String groupRule;
	
	public String getCostContain() {
		return costContain;
	}
	public void setCostContain(String costContain) {
		this.costContain = costContain;
	}
	public String getCostUncomtain() {
		return costUncomtain;
	}
	public void setCostUncomtain(String costUncomtain) {
		this.costUncomtain = costUncomtain;
	}
	public String getGroupRule() {
		return groupRule;
	}
	public void setGroupRule(String groupRule) {
		this.groupRule = groupRule;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getChineseName() {
		return chineseName;
	}
	public void setChineseName(String chineseName) {
		this.chineseName = chineseName;
	}
	public String getEnglishName() {
		return englishName;
	}
	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Integer getIshot() {
		return ishot;
	}
	public void setIshot(Integer ishot) {
		this.ishot = ishot;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getTotalSeat() {
		return totalSeat;
	}
	public void setTotalSeat(Integer totalSeat) {
		this.totalSeat = totalSeat;
	}
	public Integer getSaleSeat() {
		return saleSeat;
	}
	public void setSaleSeat(Integer saleSeat) {
		this.saleSeat = saleSeat;
	}
	public String getExplain() {
		return explain;
	}
	public void setExplain(String explain) {
		this.explain = explain;
	}
	public String getFavorable() {
		return favorable;
	}
	public void setFavorable(String favorable) {
		this.favorable = favorable;
	}
	public String getPicture_url() {
		return picture_url;
	}
	public void setPicture_url(String picture_url) {
		this.picture_url = picture_url;
	}
	public String getNotice() {
		return notice;
	}
	public void setNotice(String notice) {
		this.notice = notice;
	}	

}

