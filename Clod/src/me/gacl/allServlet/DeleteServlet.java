package me.gacl.allServlet;
import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteServlet extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.从网页上获得用户选中的文件名
		String filename=request.getParameter("filename1");
		//2.进行编码转换----------此不不知道能不能删除  稍后测试
		filename=new String(filename.getBytes("iso8859-1"),"UTF-8");
		//3.获得文件存放的路径
		String realpath=this.getServletContext().getRealPath("/WEB-INF/upload");
		//4.实例化文件路径赋值给file
		File file=new File(realpath+"/"+filename);
		//5.执行删除
		file.delete();
		//6.保存文字信息到message
		request.setAttribute("message", "删除成功！");
		//7.跳转至显示页面
		request.getRequestDispatcher("/servlet/listfileDownload").forward(request, response);
		System.out.println(file+"==删除成功！");
	}
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
