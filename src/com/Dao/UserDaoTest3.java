package com.Dao;

import static org.junit.Assert.fail;

import java.sql.Connection;

import org.junit.Before;
import org.junit.Test;

import com.model.User;
import com.util.JDBC;

public class UserDaoTest3 {
	User user;
	Connection conn;
	JDBC jdbc;
	
	@Before
	public void setUp() throws Exception {
		user=new User("teacher","123456");
		jdbc =new JDBC();
		conn=jdbc.getCon();
	}

	@Test
	public void test() throws Exception {
		if(UserDao.teacher_login(conn, user)!=null)
			fail("Not yet implemented");
	}

}
