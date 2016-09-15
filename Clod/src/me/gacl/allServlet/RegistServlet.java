package me.gacl.allServlet;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.java.bean.Users;
import com.java.util.UserUtils;


public class RegistServlet extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//先声明要接收的值以及数据库值
		String username=null;
		String password=null;
		String password1=null;
		//接收
		username=request.getParameter("username");
		//防止乱码
		username=new String(username.getBytes("iso8859-1"),"UTF-8");
		password=request.getParameter("password");
		password1=request.getParameter("password1");
		
		String str="com.java.mapping.UserMapper.getUsername";
		String str1="com.java.mapping.UserMapper.addUser";
		Users user=new Users();
		//List list = Arrays.asList(new String[]{"1","232","345"});
		List<String> user1=UserUtils.getSession().selectList(str,user.getUsername());
		//判断
		if(user1.contains(username.replace(" ",""))==true){
			String message="很抱歉！账号已经被注册！";
			request.setAttribute("message", message);
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
		}else if(null==username||"".equals(username.replace(" ",""))){
			String message="请务必输入账号！";
			request.setAttribute("message", message);
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
		}else if(null==password||"".equals(password.replace(" ",""))){
			String message="请输入密码！";
			request.setAttribute("message", message);
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
		}else if(null==password1||"".equals(password1.replace(" ",""))){
			String message="请输入确认密码！";
			request.setAttribute("message", message);
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
		}else if(!password.replace(" ","").equals(password1.replace(" ",""))){
			String message="两次密码不一致！";
			request.setAttribute("message", message);
			request.getRequestDispatcher("/regist.jsp").forward(request, response);
		}else{
			user.setPassword(password);
			user.setUsername(username);
			UserUtils.getSession(true).insert(str1,user);
			String message="注册成功！";
			request.setAttribute("message", message);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		//一定要关闭
		UserUtils.getSession(true).close();
	}
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
