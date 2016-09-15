package me.gacl.allServlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DeleteAllFile extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		一个删除文件的方法(resp,req);
	}
	public void 一个删除文件的方法(HttpServletResponse response,HttpServletRequest request) throws ServletException, IOException {
		String realpath=this.getServletContext().getRealPath("/WEB-INF/upload");
		File file=new File(realpath);
		//调用递归方法删除所有文件
		listfile(file);
		request.setAttribute("message","格式化完毕!");
		request.getRequestDispatcher("/servlet/listfileDownload").forward(request, response);
		System.out.println("所有文件已被格式化！");
	}
	public static void listfile(File f) {
		//吧所有文件都放在一个数组
		File[] files =f.listFiles();
		//列粗所有文件
		for (File f1:files) {
			//如果文件是一个文件夹
			if (f1.isDirectory()) {
			//实例化文件路径
			File f2 =new File(f1.getPath());
			//调用自己的方法再判断
			listfile(f2);	
		}
		//删掉
		f1.delete();
	}
}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
