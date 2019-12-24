package com.xp.dao.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.xp.dao.UserDao;
import com.xp.pojo.User;
import com.xp.util.DBUtil;


public class UserDaoImpl implements UserDao {
	//
	@Override
	public User getUserInfoDao(String uname, String pwd) {
		//jdbc
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		User u = null;
		//create connection
		
		try{
			conn = DBUtil.getConnection();
			String sql = "select * from t_user where uname=? and pwd = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, uname);
			ps.setString(2, pwd);
			rs = ps.executeQuery();
			while(rs.next()) {
				u = new User();
				u.setUid(rs.getInt("uid"));
				u.setUname(rs.getString("uname"));
				u.setPwd(rs.getString("pwd"));
				u.setGender(rs.getString("gender"));
				u.setAge(rs.getInt("age"));
				u.setDob(rs.getString("dob"));
			}
			
		}catch(Exception e){
			
		}finally{
			DBUtil.closeAll(rs, ps, conn);
		}
		return u;
	}

	@Override
	public Integer regUserInfoDao(String uname, String pwd, String gender,
			int age, String dob) {
		String sql = "insert into t_user values(default,?,?,?,?,?)";
		return DBUtil.executeDML(sql, uname, pwd, gender, age, dob);
		
	}

}
