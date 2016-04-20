package com.xiaolangn.service;

import com.xiaolangn.bean.User;

public interface IUserService {
   public  User getUserById(Integer userid);
   public  User getUserByPhone(String phoneNum);
   public int insert(User user);
  
}
