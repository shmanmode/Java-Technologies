package com.cdac.dp.ver2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

/**
 * Requirement is to develop logging functionality in Java
 * 
 * @author Majrul Ansari
 * @version 2.0
 *
 */
public class FileLogger {

	public void log(String msg) {
		//System.out.println("[INFO] [" + new Date() + "] " + msg);
		log(msg, LogLevel.INFO);
	}
	
	public void log(String msg, LogLevel level) {
		try(FileWriter fw = new FileWriter("app.log",true)) {
			switch (level) {
			case INFO:
				fw.write("\n[INFO] [" + new Date() + "] " + msg);
				break;
			case WARN:
				fw.write("\n[WARNING] [" + new Date() + "] " + msg);
				break;
			case DEBUG:
				fw.write("\n[DEBUG] [" + new Date() + "] " + msg);
				break;
			case ERROR:
				fw.write("\n[ERROR] [" + new Date() + "] " + msg);
			}
		}
		catch (IOException e) {
			e.printStackTrace(); //instead we should throw 
		}
	}
}
