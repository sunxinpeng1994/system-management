package com.xp.service;

import com.xp.pojo.User;

public interface UserService {

	User getUserInfoService(String uname, String pwd);

	Integer regUserInfoService(String uname, String pwd, String gender, int age, String dob);

}
