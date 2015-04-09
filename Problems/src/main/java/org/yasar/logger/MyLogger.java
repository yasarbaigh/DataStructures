package org.yasar.logger;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class MyLogger
{
	public static final String END_OF_MESSAGE = "=================================================\n";
	
	
	public static Logger getLog4jLogger(Class clazz)
	{
		PropertyConfigurator.configure("log4j_console.properties");
		return Logger.getLogger(clazz);		
	}
}
