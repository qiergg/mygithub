package com.clock.systemui.myfirstdemo.util;

public class MExceptionManager {
	public static void throwApplictionInitEx(String msg){
		throw new MException(msg);
	}
}