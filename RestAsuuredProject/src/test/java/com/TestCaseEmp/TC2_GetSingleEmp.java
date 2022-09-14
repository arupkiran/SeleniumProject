package com.TestCaseEmp;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.BaseEmp.BaseEmp;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC2_GetSingleEmp extends BaseEmp
{
	@BeforeClass
	void getSingleEmp() throws InterruptedException
	{
		System.out.println("Get single employee details"); 
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";	
		httprequest =RestAssured.given();
		response=httprequest.request(Method.GET,"/employee/"+empId);
		Thread.sleep(3000);
	}
	@Test
	void checkResponseBody()
	{
		System.out.println("checking response body"); 
	String responsebody=response.getBody().asString();
		
		Assert.assertEquals(responsebody.contains(empId),true);
	}
		

	@Test
	void checkStatusCode()
	{
		System.out.println("checking status code"); 
		int statuscode=response.getStatusCode();
		System.out.println("status code is: "+statuscode);
		Assert.assertEquals(statuscode, 200);
		
	}
	@Test
	void checkStatusline()
	{
		System.out.println("checking status line"); 
		String statusline=response.getStatusLine();
		System.out.println("status line is: "+statusline);
		Assert.assertEquals(statusline,"HTTP/1.1 200 OK" );
		
	}
	@AfterClass
	void tearDown()
	{
		System.out.println("finished Tc1 detail emp testcase");
	}
	

}
