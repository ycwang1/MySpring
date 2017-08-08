package com.java.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Component;

@Component("s")
public class ProductService {
	private static final String driver="com.mysql.jdbc.Driver";
	private static final String url="jdbc:mysql://localhost:3306/test";
	private static final String userName="root";
	private static final String pwd="ROOT";
	public void doSomeService(){
		Connection conn=null;
		Statement st=null;
		
		try {
			Class.forName(driver);
			System.out.println("connection to database");
			conn=DriverManager.getConnection(url, userName, pwd);
			System.out.println("ÊµÀý»¯statement");
			st=conn.createStatement();
			String sql="select * from websites";
			ResultSet rt=st.executeQuery(sql);
			while(rt.next()){
				int id=rt.getInt("id");
				String name= rt.getString("name");
				String url=rt.getString("url");
				int alexa=rt.getInt("alexa");
				String country=rt.getString("country");
				System.out.println("id:"+id);
				System.out.println("name:"+name);
				System.out.println("url:"+url);
				System.out.println("alexa"+alexa);
				System.out.println("country:"+country);
			}
			rt.close();
			st.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
		     try {
	                if(st!=null){
	 
	                    st.close();
	 
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	            try {
	                if(conn!=null){
	 
	                	conn.close();
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
		}
		System.out.println("doSomeService");
	}
}
