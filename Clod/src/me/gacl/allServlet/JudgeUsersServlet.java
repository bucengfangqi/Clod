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


public class JudgeUsersServlet extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username=request.getParameter("username");
		username=new String(username.getBytes("iso8859-1"),"UTF-8");
		
		String password=request.getParameter("password");
		password=new String(password.getBytes("iso8859-1"),"UTF-8");
		String str="com.java.mapping.UserMapper.getUsername";
		String str1="com.java.mapping.UserMapper.getPassword";
		Users user=new Users();
		//List list = Arrays.asList(new String[]{"1","232","345"});
		List<String> user1=UserUtils.getSession().selectList(str,user.getUsername());
		String password1=UserUtils.getSession().selectOne(str1,username);
		if(null==username||"".equals(username.replace(" ",""))){
			String message="请务必输入账号！";
			request.setAttribute("message", message);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}else if(user1.contains(username.replace(" ",""))==false){
			String message="账号未注册！";
			request.setAttribute("message", message);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}else if(null==password||"".equals(password.replace(" ",""))){
			String message="请输入密码！";
			request.setAttribute("message", message);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}else if(user1.contains(username.replace(" ",""))==true&&password.replace(" ","").equals(password1)){
			String message="登陆成功！";
			request.setAttribute("Username",username);
			request.setAttribute("message", message);
			request.getRequestDispatcher("/upload.jsp").forward(request, response);
		}else if(user1.contains(username)==true&&password!=password1.replace(" ","")){
			String message="密码错误！";
			request.setAttribute("message", message);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}else{
			String message="账号输入错误";
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
