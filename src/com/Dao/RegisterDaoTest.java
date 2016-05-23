package com.Dao;

import static org.junit.Assert.fail;

import java.sql.Connection;

import org.junit.Before;
import org.junit.Test;

import com.model.User;
import com.util.JDBC;

public class RegisterDaoTest {
	JDBC jdbc;
	Connection conn;
	User user;
	@Before
	public void setUp() throws Exception {
		jdbc=new JDBC();
		conn=jdbc.getCon();
		user=new User("123","123456",2);
		
	}

	@Test
	public void test() throws Exception {
		if(RegisterDao.Register(conn, user)==0)
			fail("Not yet implemented");
	}

}
