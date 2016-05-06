package com.xiaolangn.bean;


public class Schedule {

    private Integer scheduleId;
    private Integer productId;
    private Integer day;
	private String content;
	private String picture_url;
	private String scheduleName;
	private String scheduleDetails;
	public String getScheduleName() {
		return scheduleName;
	}
	public void setScheduleName(String scheduleName) {
		this.scheduleName = scheduleName;
	}
	public String getScheduleDetails() {
		return scheduleDetails;
	}
	public void setScheduleDetails(String scheduleDetails) {
		this.scheduleDetails = scheduleDetails;
	}
	public Integer getScheduleId() {
		return scheduleId;
	}
	public void setScheduleId(Integer scheduleId) {
		this.scheduleId = scheduleId;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public Integer getDay() {
		return day;
	}
	public void setDay(Integer day) {
		this.day = day;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPicture_url() {
		return picture_url;
	}
	public void setPicture_url(String picture_url) {
		this.picture_url = picture_url;
	}
}
