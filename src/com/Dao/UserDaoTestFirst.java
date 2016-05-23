package com.Dao;

import static org.junit.Assert.fail;

import java.sql.Connection;

import org.junit.Before;
import org.junit.Test;

import com.model.Course;
import com.model.User;
import com.util.JDBC;

public class UserDaoTestFirst {

	JDBC jdbc;
	Connection conn;
	User user,user1,ruser,ruser1,ruser2,ruser3;
	Course course,course1;
	@Before
	public void setUp() throws Exception {
		
		
		user=new User("test","123456");//正确测试
		user1=new User("teacher","123456");
		course=new Course("计算机网络");
		course1=new Course(1009, "极限编程", 20008);
		ruser=new User("aaa","bbbaaaa");		
		ruser1=new User("abc","aaa");
		ruser2=new User("dbc","");
		ruser3=new User("","aaaaaa");
		jdbc=new JDBC();
		conn=jdbc.getCon();
		
	} 

	@Test
	public void testSudentlogin() throws Exception {
		if(UserDao.student_login(conn, user)==null)
			fail("Not yet implemented");
	}
	@Test
	public void testTeacherlogin() throws Exception {
		if(UserDao.teacher_login(conn, user1)==null)
			fail("Not yet implemented");
	}
	@Test
	public void testSearch() throws Exception {
		if(CourseDao.courseList(conn, course)==null)
			fail("Not yet implemented");
	}
	@Test
	public void testAdd() throws Exception {
		if(CourseDao.CourseAdd(conn, course1)==0)
			fail("Not yet implemented");
	}
	@Test
	public void testRegister() throws Exception {
		if(RegisterDao.Register(conn, ruser)==0)
			fail("Not yet implemented");
	}
	@Test
	public void testRegister1() throws Exception {
		if(RegisterDao.Register(conn, ruser1)!=0)
			fail("Not yet implemented");
	}
	@Test
	public void testRegister2() throws Exception {
		if(RegisterDao.Register(conn, ruser2)!=0)
			fail("Not yet implemented");
	}
	@Test
	public void testRegister3() throws Exception {
		if(RegisterDao.Register(conn, ruser3)!=0)
			fail("Not yet implemented");
	}
	
	
}
