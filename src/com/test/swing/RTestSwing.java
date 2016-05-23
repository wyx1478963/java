package com.test.swing;

import static org.junit.Assert.fail;

import org.fest.swing.fixture.FrameFixture;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.UI.Register;

public class RTestSwing {
	private FrameFixture frame;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		frame=new FrameFixture(new Register());
		frame.show();
		
	}
	public void tearDown(){
		frame.cleanUp();		
	}


	@Test
	public void test() {
		frame.textBox("user_txt").enterText("111");
		frame.textBox("psd_txt").enterText("123");
		frame.textBox("rpsd_txt").enterText("123");
		frame.button("submit_btn").click();
		
		
	}
	
	@Test
	public void test1() {
		frame.textBox("user_txt").enterText("111");
		frame.textBox("psd_txt").enterText("123");
		frame.textBox("rpsd_txt").enterText("123");
		frame.button("submit_btn").click();
		
		
	}

	
	

}
