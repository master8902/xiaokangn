package com.xiaolangn.mapper;

import com.xiaolangn.bean.User;

public interface UserMapper {


   public User getUserById(Integer userid);

   public  User getUserByPhone(String phoneNum);
}
