package com.xp.service.impl;
import java.util.List;

import com.xp.dao.UserDao;
import com.xp.dao.impl.UserDaoImpl;
import com.xp.pojo.User;
import com.xp.service.*;
public class UserServiceImpl implements UserService {
	//create dao 
	UserDao ud = new UserDaoImpl();
	@Override
	public User getUserInfoService(String uname, String pwd) {
		
		return ud.getUserInfoDao(uname, pwd);
		
		
	}
	@Override
	public Integer regUserInfoService(String uname, String pwd, String gender,
			int age, String dob) {
		return ud.regUserInfoDao(uname, pwd, gender, age, dob);
		
	}
	@Override
	public List<User> selUserInfoService() {
		// TODO Auto-generated method stub
		return ud.selUserInfoDao();
	}

}
