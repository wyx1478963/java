package com.util;

import com.model.User;

public class UserUtil {
	
	public static boolean judge(User user){
		if(StringUtil.IsEmpty(user.getPsd())){
			return false;
		}
		if(StringUtil.IsEmpty(user.getUserName())){
			return false;
		}
		if(user.getPsd().length()<6){
			return false;
		}		
		
		return true;
	}

	
}
