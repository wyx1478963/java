package com.Dao;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.ResultSet;

import org.junit.Before;
import org.junit.Test;

import com.model.Course;
import com.model.User;
import com.util.JDBC;

public class CourseDaoTest {
	JDBC jdbc;
	Connection conn;
	Course course1,course2,course3,course4,course5,course6;
	ResultSet rs;
	@Before
	public void setUp() throws Exception {
		course1=new Course("计算机网络");
		course2=new Course("计算机科学与技术");
		course3=new Course("计算机组成");
		course4=new Course("软件工程");
		course5=new Course("编译原理");	
		course6=new Course("");
		jdbc=new JDBC();
		conn=jdbc.getCon();
	}
	@Test
	public void test1() throws Exception {
		rs=CourseDao.courseList(conn, course1);
		if(!rs.next())
			fail("Not yet implemented");
	}

	@Test
	public void test2() throws Exception {
		rs=CourseDao.courseList(conn, course2);
		if(rs.next())
			fail("Not yet implemented");
	}
	@Test
	public void test3() throws Exception {
		rs=CourseDao.courseList(conn, course3);
		if(!rs.next())
			fail("Not yet implemented");
	}
	@Test
	public void test4() throws Exception {
		rs=CourseDao.courseList(conn, course4);
		if(!rs.next())
			fail("Not yet implemented");
	}
	@Test
	public void test5() throws Exception {
		rs=CourseDao.courseList(conn, course5);
		if(rs.next())
			fail("Not yet implemented");
	}
	@Test
	public void test6() throws Exception {
		rs=CourseDao.courseList(conn, course6);
		if(rs.next())
			fail("Not yet implemented");
	}
	
	


}
