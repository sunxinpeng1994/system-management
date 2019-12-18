package com.xp.servlet;

import java.io.IOException;

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
 * Servlet implementation class UserServlet
 */
@WebServlet("/user")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//request decode
		req.setCharacterEncoding("utf-8");
		//response encode
		resp.setContentType("text/html;charset=utf-8");
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
