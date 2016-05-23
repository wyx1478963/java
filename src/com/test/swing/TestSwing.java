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
	//public void tearDown(){
		//frame.cleanUp();		
	//}

	@Test
	public void test() {		
		frame.textBox("user_txt").enterText("teacher");
		frame.textBox("psd_txt").enterText("123456");
		frame.button("login_btn").click();
	}
	@Test
	public void test1() {		
		frame.textBox("user_txt").enterText("teacher");
		frame.textBox("psd_txt").enterText("123456");
		frame.button("login_btn").click();
	}
	
}
