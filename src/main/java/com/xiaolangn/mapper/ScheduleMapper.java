package com.xiaolangn.mapper;

import java.util.List;

import com.xiaolangn.bean.Schedule;

public interface ScheduleMapper {
/**
 * 根据产品id查询日程信息
 * @param productId
 * @return
 */
   public List<Schedule> getScheduleByProductId(Integer productId);

   
}
