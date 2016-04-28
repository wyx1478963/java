package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.model.Course;
import com.util.StringUtil;

public class CourseDao {
	public static ResultSet courseList(Connection conn,Course course) throws Exception{	
		StringBuffer sb=new StringBuffer("select * from t_course");
		if(!StringUtil.IsEmpty(course.getCname())){
			sb.append(" and cname like '%"+course.getCname()+"%'");
		}
		PreparedStatement pstmt=conn.prepareStatement(sb.toString().replaceFirst("and", "where"));
		return pstmt.executeQuery();
	}

}
