package com.java.util;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class UserUtils {
	public static SqlSessionFactory getsqlSession(){
		//获得配置文件的输入流
		InputStream in=UserUtils.class.getClassLoader().getResourceAsStream("conf.xml");
		//根据流建立工厂
		SqlSessionFactory sqlSession=new SqlSessionFactoryBuilder().build(in);
		//方法返回一个工厂
		return sqlSession;
	}
	
	//不同的方法采用不同的事务
	public static SqlSession getSession(){
		return getsqlSession().openSession();
	}
	public static SqlSession getSession(boolean s){
		return getsqlSession().openSession(s);
	}
}
