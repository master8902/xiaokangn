package com.xiaolangn.spring.util;

import org.apache.log4j.Logger;


public class RyingLogs  {
	private static Logger log = Logger.getLogger(RyingLogs.class);

	public static void errorLogs(Exception e) {
		e.printStackTrace();
		log.error("** Exception ** ", e.fillInStackTrace());
	}

	public static void errorLogs(Exception e,String s) {
		e.printStackTrace();
		log.error("** Exception ** " + s, e.fillInStackTrace());
	}

	public static void warnLogs(String s,Exception e) {
		String ex = "Class: [" + e.getStackTrace()[0].getClassName()+
					"] Method: <" + e.getStackTrace()[0].getMethodName()+
					"> Line: " + e.getStackTrace()[0].getLineNumber()+
					" WARN: " + s;
		System.out.println(ex);
		log.warn("** WARN ** "+ex);
	}

	public static void infoLogs(String s,Exception e) {
		String ex = "Class: [" + e.getStackTrace()[0].getClassName()+
					"] Method: <" + e.getStackTrace()[0].getMethodName()+
					"> Line: " + e.getStackTrace()[0].getLineNumber()+
					" INFO: " + s;
		System.out.println(ex);
		log.info("** INFO ** "+ex);
	}

	public static void infoLogs(String s){
	    log.info(s);
	}

}
