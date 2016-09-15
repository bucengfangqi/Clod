package me.gacl.allServlet;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListFileServlet extends HttpServlet{
	//1.先定义一个有参的listfile方法用于列出所有的文件
		public void listfile(File file,Map<String,String> map){
			//2.判断文件名是否为文件名
			if(!file.isFile()){
				//3.如果不是文件名那肯定是文件夹名,列出文件夹里的内容
				File[] files=file.listFiles();
				//4.循环输出文件
				for(File f:files){
					//5.再次调用自身方法判断输出的文件是不是文件
					listfile(f,map);
				}
			}else{
				//6.将文件名放到map集合
				map.put(file.getName(),file.getName());
			}
		}
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try{
		//1.获得需要判断是否为文件名的文件夹
		String realpath=this.getServletContext().getRealPath("/WEB-INF/upload");
		File file=new File(realpath);
		if(!file.exists()||!file.isDirectory()){
			String message="很抱歉！您还没有上传任何文件";
			request.setAttribute("message",message);
			request.getRequestDispatcher("/upload.jsp").forward(request,response);
		}
		//2.创建一个Map集合接收文件名
		Map<String,String> fileNameMap=new HashMap<String,String>();
		//3.调用刚才写好的列出所有的文件的方法将文件名存到Map集合
		listfile(new File(realpath),fileNameMap);
		
		//4.保存fileNameMap内容到"fileNameMap";
		request.setAttribute("fileNameMap",fileNameMap);
		//5.跳转到listfile.jsp，然后页面可操作所有文件名
		request.getRequestDispatcher("/listfile.jsp").forward(request,response);
		}catch(Exception e){
			System.out.println("客户还没有上传任何文件");
		}
			
	}
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
