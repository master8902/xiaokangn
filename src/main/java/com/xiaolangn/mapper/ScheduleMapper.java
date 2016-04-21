package com.xiaolangn.mapper;

import com.xiaolangn.bean.Schedule;

public interface ScheduleMapper {
/**
 * 根据产品id查询日程信息
 * @param productId
 * @return
 */
   public Schedule getScheduleByProductId(Integer productId);

   
}
