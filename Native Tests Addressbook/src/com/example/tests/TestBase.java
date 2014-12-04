package com.example.tests;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.example.fw.ApplicationManager;

public class TestBase {
	
	protected static ApplicationManager app;

	@BeforeTest
	public void setUp() throws Exception {
		String configFile = System.getProperty("configFile", "application.properties");
		Properties props = new Properties();
		props.load(new FileReader(configFile));
		app = ApplicationManager.getInstance(props);
	  }
	
	@AfterTest
	public void tearDown() throws Exception {
		ApplicationManager.getInstance(null).stop();
		
	   }
	
}
	

