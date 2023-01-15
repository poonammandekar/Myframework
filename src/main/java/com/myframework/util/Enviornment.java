package com.fasttrack22.util;

public class Enviornment {

		private static String filePath="/src/main/resources/Environment.properties";
		public static String URL;
		
	static{
		PropUtil prop=new PropUtil();
		String baseDir=System.getProperty("user.dir");
		
		URL=prop.getValue(baseDir+	filePath,"app_url");
	}
}
