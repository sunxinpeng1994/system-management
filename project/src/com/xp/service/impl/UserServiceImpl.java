package com.xp.service.impl;
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

}