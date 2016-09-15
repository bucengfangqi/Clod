package me.gacl.allServlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadServlet extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//先来个catch防止tom报一堆错误乱码
		try{
			//1.首先从网页获得用户需要下载的文件的mingzi 
			String filename=request.getParameter("filename");
			//2.进行编码转换，否则将出现码
			filename=new String(filename.getBytes("iso8859-1"),"UTF-8");
			//3.开始准备下载，先获得从哪儿下载文件的路径
			String realpath=this.getServletContext().getRealPath("WEB-INF/upload");
			//4.先判断有木有这个文件
			File file=new File(realpath+"/"+filename);
			if(!file.exists()){
				String message="很抱歉！你要下载的文件已删除！";
				request.setAttribute("message",message);
				request.getRequestDispatcher("/servlet/listfileDownload").forward(request,response);
			}
			//5.获得服务器输入流
			FileInputStream in=new FileInputStream(file);
			//6.获得文件输出流输出文件到客户浏览器
			OutputStream out=response.getOutputStream();
			//7.设置响应头告诉浏览器以下载的方式打开文件
			response.setHeader("content-disposition","attachment;filename="+URLEncoder.encode(filename,"UTF-8"));
			//8.创建输入流byte缓冲区
			byte[] buffer=new byte[1024];
			//9.声明变量在可以防止等会儿循环输出下载的时候防止下载重复内容
			int len;
			//10.判断缓冲区是否有内容，有的话循环输出缓冲区的内容
			while((len=in.read(buffer))>0){
				out.write(buffer,0,len);
			}
			//11.用完后记得关闭流，防止资源浪费
			in.close();out.close();
			System.out.println(file+"==下载成功！");
		}catch(Exception w){
			System.out.println("用户下载文件不存在！");
		}
	}
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
