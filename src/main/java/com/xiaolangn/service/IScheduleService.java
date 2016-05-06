package com.xiaolangn.service;

import java.util.List;

import com.xiaolangn.bean.Schedule;

public interface IScheduleService {
	public  List<Schedule> getScheduleByProductId(Integer productid);
}
