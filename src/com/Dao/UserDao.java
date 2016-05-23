package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



import com.model.User;

public class UserDao {
	/**
	 * 用于学生登录验证
	 * @throws Exception 
	 */
	static public User student_login(Connection conn,User user) throws Exception{
		User loginUser=null;
		String sql="select * from t_studentinfo where id=? and psd=? ";
		PreparedStatement pst=conn.prepareStatement(sql);
		pst.setString(1, user.getUserName());
		pst.setString(2, user.getPsd());
		ResultSet rs=pst.executeQuery();
		if(rs.next()){
			loginUser =new User(user.getUserName(),user.getPsd(),2);
			
		}
		return loginUser;	
	
	}
	static public User teacher_login(Connection conn,User user) throws Exception{
		User loginUser=null;
		String sql="select * from t_teacherinfo where id=? and psd=? ";
		PreparedStatement pst=conn.prepareStatement(sql);
		pst.setString(1, user.getUserName());
		pst.setString(2, user.getPsd());
		ResultSet rs=pst.executeQuery();
		if(rs.next()){
			loginUser =new User(user.getUserName(),user.getPsd(),1);
			
		}
		return loginUser;		
	}
}
