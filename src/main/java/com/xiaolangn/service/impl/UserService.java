package com.xiaolangn.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xiaolangn.bean.User;
import com.xiaolangn.mapper.UserMapper;
import com.xiaolangn.service.IUserService;

@Service
public class UserService implements IUserService {

    // private static Logger logger = Logger.getLogger(UserService.class);

    @Resource
    UserMapper userMapper;

  
    @Override
    public User getUserById(Integer userid) {
        // TODO Auto-generated method stub
        return userMapper.getUserById(userid);
    }


	@Override
	public User getUserByPhone(String phoneNum) {
		// TODO Auto-generated method stub
		return userMapper.getUserByPhone(phoneNum);
	}


	@Override
	public int insert(User user) {
		// TODO Auto-generated method stub
		return userMapper.insert(user);
	}

   


}
