package com.Dao;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Before;
import org.junit.Test;

import com.model.User;
import com.util.JDBC;

public class UserDaoTest {

	JDBC jdbc;
	Connection conn;
	User user1,user2,user3,user4,user5,user6;
	@Before
	public void setUp() throws Exception {
		user1=new User("111","222");//任意测试
		user2=new User("test","222");//密码测试
		user3=new User("111","123456");//用户名测试
		user4=new User("","222");//空用户名测试
		user5=new User("111","");//空密码测试
		user6=new User("test","123456");//正确测试
		jdbc=new JDBC();
		conn=jdbc.getCon();
		
	} 

	@Test
	public void test() throws Exception {
		if(UserDao.student_login(conn, user1)!=null)
			fail("Not yet implemented");
	}
	@Test
	public void test1() throws Exception {
		if(UserDao.student_login(conn, user2)!=null)
			fail("Not yet implemented");
	}
	@Test
	public void test2() throws Exception {
		if(UserDao.student_login(conn, user3)!=null)
			fail("Not yet implemented");
	}
	@Test
	public void test3() throws Exception {
		if(UserDao.student_login(conn, user4)!=null)
			fail("Not yet implemented");
	}
	@Test
	public void test4() throws Exception {
		if(UserDao.student_login(conn, user5)!=null)
			fail("Not yet implemented");
	}
	@Test
	public void test5() throws Exception {
		if(UserDao.student_login(conn, user6)==null)
			fail("Not yet implemented");
	}

}
