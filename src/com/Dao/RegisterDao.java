package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.model.User;
import com.util.StringUtil;
import com.util.UserUtil;

public class RegisterDao {
	public static int Register(Connection con,User user) throws Exception{
		String sql="insert into t_studentinfo values(?,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, user.getUserName());
		pstmt.setString(2, user.getPsd());
		pstmt.setString(3, "2");
		if(!UserUtil.judge(user)){
			return 0;
		}
		else
			return pstmt.executeUpdate();
	}
}
