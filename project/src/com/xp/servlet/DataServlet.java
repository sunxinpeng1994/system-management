package com.xp.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xp.pojo.User;
import com.xp.service.UserService;
import com.xp.service.impl.UserServiceImpl;

/**
 * Servlet implementation class DataServlet
 */
@WebServlet("/data")
public class DataServlet extends BaseServelet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DataServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		//设置请求编码格式
//		req.setCharacterEncoding("utf-8");
//		//设置响应编码格式
//		resp.setContentType("text/html;charset=utf-8");
//		//获取请求信息
//		String methodName=req.getParameter("method");
//		//调用方法处理请求（动态根据方法名调用方法--->反射）
//		try {
//			//反射获取方法所在的类的类对象
//			Class cla=this.getClass();
//			//反射获取要被调用的方法对象
//			Method m=cla.getMethod(methodName, HttpServletRequest.class,HttpServletResponse.class);
//			//反射执行方法
//			m.invoke(this, req,resp);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}	
//	}
    
	//login
	public void userLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		//get request
		String uname = req.getParameter("uname");
		String pwd = req.getParameter("pwd");
		//process 
		System.out.println(uname+" : " +pwd);
		UserService us = new UserServiceImpl();
		User u = us.getUserInfoService(uname, pwd);
		System.out.println(u);
		HttpSession hs = req.getSession();
		//return response: forward, redirect, direct
		if(u != null) {//redirect to main.jsp
			hs.setAttribute("userName", uname);
			resp.sendRedirect("/project/main.jsp");
		} else {//redirect to login.jsp
			//create/get session
			
			hs.setAttribute("flag", "loginFalse");
			resp.sendRedirect("/project/login.jsp");
		}
	}
	//log out
	public void userOut(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		//process, destroy session
		HttpSession hs = req.getSession();
		hs.invalidate();
		resp.sendRedirect("/project/login.jsp");
	}
	//registration
	public void userReg(HttpServletRequest req, HttpServletResponse resp) throws IOException{
		//retrieve req
		String uname = req.getParameter("uname");
		String pwd = req.getParameter("pwd");
		String gender = req.getParameter("gender");
		int age = Integer.parseInt(req.getParameter("age"));
		String dob = req.getParameter("dob");
		UserService us = new UserServiceImpl();
		int i = us.regUserInfoService(uname, pwd, gender, age, dob);
		//System.out.println(i);
		HttpSession hs = req.getSession();
		if(i > 0) {
			System.out.println("accound created");
			hs.setAttribute("flag", "regSuccess");
			resp.sendRedirect("/project/login.jsp");
		} else {
			resp.sendRedirect("/project/registration.jsp");
		}
	}
	//查询用户信息
		public void selUserInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
			//获取请求信息
			//处理请求信息
				//创建业务层对象
				UserService us=new UserServiceImpl();
				//调用业务层方法处理请求
				List<User> lu=us.selUserInfoService();
				System.out.println("lu " + lu);
			//响应处理结果
				//将结果存储到request作用域中
				req.setAttribute("lu",lu);
				//请求转发
				req.getRequestDispatcher("/user/userList2.jsp").forward(req, resp);
				return;
		}

		public void delUserInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
			String uid = req.getParameter("uid");
			UserService us=new UserServiceImpl();
			
			int i = us.delUserInfoService(uid);
			if(i > 0) {
				resp.getWriter().write("delete finish");
			} else {
				resp.getWriter().write("delete fail");
			}

		
		
			
			return;
		}
		
		

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
