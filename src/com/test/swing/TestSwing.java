package com.test.swing;

import static org.junit.Assert.*;

import org.fest.swing.fixture.FrameFixture;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.UI.StudentMain;

public class TestSwing {
	
	private FrameFixture frame;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		frame=new FrameFixture(new StudentMain() );
		frame.show();
	}
	public void tearDown(){
		frame.cleanUp();		
	}

	@Test
	public void test() {
		
		frame.textBox("user_txt").enterText("teacher");
		frame.textBox("psd_txt").enterText("123456");
		frame.button("login_btn").click();
	}
	@Test
	public void test2() {
		frame.textBox("user_txt").enterText("111");
		//frame.textBox("psd_ptxt").enterText("123456");
		frame.button("login_btn").click();
	}
	@Test
	public void test3() {
		frame.textBox("user_txt").enterText("222");
		//frame.textBox("psd_ptxt").enterText("123456");
		frame.button("login_btn").click();
	}
	@Test
	public void test4() {
		frame.textBox("user_txt").enterText("333");
		//frame.textBox("psd_ptxt").enterText("123456");
		frame.button("login_btn").click();
	}

}
