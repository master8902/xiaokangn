package com.xiaolangn.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xiaolangn.bean.Schedule;
import com.xiaolangn.mapper.ScheduleMapper;
import com.xiaolangn.service.IScheduleService;

@Service
public class ScheduleService implements IScheduleService {

    // private static Logger logger = Logger.getLogger(UserService.class);

    @Resource
    ScheduleMapper scheduleMapper;

  
    @Override
    public Schedule getScheduleByProductId(Integer productId) {
        // TODO Auto-generated method stub
        return scheduleMapper.getScheduleByProductId(productId);
    }

   


}
