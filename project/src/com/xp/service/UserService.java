package com.xp.service;

import java.util.List;

import com.xp.pojo.User;

public interface UserService {

	User getUserInfoService(String uname, String pwd);

	Integer regUserInfoService(String uname, String pwd, String gender, int age, String dob);

	List<User> selUserInfoService();

<<<<<<< HEAD
=======
	

>>>>>>> 53c2f983cd4deee23335ca65d9375d8ca223778d
	int delUserInfoService(String uid);

}
