package com.xp.dao.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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

	@Override
	public List<User> selUserInfoDao() {
		//声明jdbc变量
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		//声明变量
		List<User> lu=null;
		try {
			//创建连接
			conn=DBUtil.getConnection();
			//创建SQL命令
			String sql="select * from t_user";
			//创建SQL命令对象
			ps=conn.prepareStatement(sql);
			//执行SQL命令
			rs=ps.executeQuery();
			//给list集合赋值
			lu=new ArrayList<>();
			//遍历
			while(rs.next()){
				//给变量赋值
				User u=new User();
				u.setUid(rs.getInt("uid"));
				u.setUname(rs.getString("uname"));
				u.setPwd(rs.getString("pwd"));
				u.setGender(rs.getString("gender"));
				u.setAge(rs.getInt("age"));
				u.setDob(rs.getString("dob"));
				lu.add(u);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{//关闭资源
			DBUtil.closeAll(rs, ps, conn);
		}
		//返回结果
		System.out.println("lu " + lu);
		for(int i = 0; i < lu.size(); i++) {
			System.out.println(lu.get(i).getUname());
		}
		return lu;
	}

	@Override
	public int delUserInfoDao(String uid) {
		String sql = "delete from t_user where uid=?";
		return DBUtil.executeDML(sql, uid);
		
	}

}
