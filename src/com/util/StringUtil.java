package com.util;

import javax.swing.JTextField;

public class StringUtil {
	static public boolean IsEmpty(String str){
		if(str.equals("")||str==null)
			return true;
		else
			return false;
		
	}
	static public boolean tIsEmpty(JTextField txt){
		if(!txt.getText().equals(""))
			return false;
		else
			return true;
	}
	

}
