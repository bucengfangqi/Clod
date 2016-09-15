package me.gacl.allServlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadServlet extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//声明message
		String message="";
		//先获得上传的路径
		String realpath=this.getServletContext().getRealPath("WEB-INF/upload");
		//将realpath实例化赋值给file
		File file=new File(realpath);
		//判断是否存在文件夹upload或者upload是不是文件夹，如果不存在或者不是那就创建一个
		if(!file.exists()||!file.isDirectory()){
			//创建文件夹upload
			file.mkdir();
		}
		//利用struts的jar包实现部分功能
		try{	//1.创建磁盘文件协议工厂
			DiskFileItemFactory factory=new DiskFileItemFactory();
			//2.获得文件解析器ServletFileUpload
			ServletFileUpload upload=new ServletFileUpload(factory);
			//3.设置编码集为UTF-8
			upload.setHeaderEncoding("UTF-8");
			//4.因为上传的文件可能是多个，创建用以接受多个文件上传的list集合接收解析的文件
			List<FileItem> list=upload.parseRequest(request);
			//5.增强for循环用以逐个循环上传文件
			for(FileItem item:list){//开始上传文件
				//1.获得上传文件名
				String filename=item.getName();
				//2.文件名是空的那就跳过此项执行其它项
				if(null==filename||"".equals(filename.trim())){
					continue;
				}
				//3.获得文件用户文件输入流
				InputStream in=item.getInputStream();
				//4.获得文件输出流将文件输到服务器指定文件夹
				FileOutputStream out=new FileOutputStream(realpath+"/"+filename);
				//5.创建byte缓冲区
				byte[] buffer=new byte[1024];
				//6.设置变量稍后加以判断防止内容重复上传
				int len;
				//7.循环从输入流的缓冲区中读取文件输出到指定文件夹
				while((len=in.read(buffer))>0){
					out.write(buffer,0,len);
				}
				//8.一定要关闭流防止资源浪费，并且删除多余日志
				in.close();out.close();item.delete();
			}
			message="上传成功！";
		}catch(Exception e){
			message="上传失败！";
		}
		//将message的内容报保存到"message"当中
		request.setAttribute("message",message);
		//跳转到页面message.jsp显示上传信息
		request.getRequestDispatcher("/upload.jsp").forward(request,response);
	}
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
