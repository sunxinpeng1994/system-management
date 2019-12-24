package com.xp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xp.service.UserService;
import com.xp.service.impl.UserServiceImpl;

/**
 * Servlet implementation class RegServlet
 */
@WebServlet("/reg")
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegServlet() {
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
		//retrieve req
		String uname = req.getParameter("uname");
		String pwd = req.getParameter("pwd");
		String gender = req.getParameter("sex");
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
