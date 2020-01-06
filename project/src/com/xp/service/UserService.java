package com.xp.service;

import java.util.List;

import com.xp.pojo.User;

public interface UserService {

	User getUserInfoService(String uname, String pwd);

	Integer regUserInfoService(String uname, String pwd, String gender, int age, String dob);

	List<User> selUserInfoService();

	int delUserInfoService(String uid);

}
