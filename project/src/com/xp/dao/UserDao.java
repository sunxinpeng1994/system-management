package com.xp.dao;

import java.util.List;

import com.xp.pojo.User;

public interface UserDao {

	User getUserInfoDao(String uname, String pwd);

	Integer regUserInfoDao(String uname, String pwd, String gender, int age,
			String dob);

	List<User> selUserInfoDao();

	int delUserInfoDao(String uid);

	

}
