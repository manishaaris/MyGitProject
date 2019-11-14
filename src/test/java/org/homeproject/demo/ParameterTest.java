package org.homeproject.demo;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest extends BaseReportClass{
	   @Test
	   @Parameters("myName")
	   public void parameterTest1(String myName) {
		   extent1.createTest("parameterTest");
	      System.out.println("Parameterized value is : " + myName);
	   }
	}