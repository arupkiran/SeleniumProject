package com.TestCaseEmp;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.BaseEmp.BaseEmp;

import io.restassured.RestAssured;
import io.restassured.http.Method;

public class TC1_DetailEmp extends BaseEmp {
	@BeforeClass
	void getAllEmployee() throws InterruptedException {
		System.out.println("...starting get all employee..");
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		httprequest=RestAssured.given();
		response=httprequest.request(Method.GET,"/employees");
		Thread.sleep(3000);
	}
	@Test
	void checkResponseBody()
	{
		System.out.println("checking response body");
		 String responsebody=response.getBody().asString();
		 System.out.println("rsponse body is: "+responsebody);
		 Assert.assertTrue(responsebody!=null);
	}
	@Test
	void checkStatusCode()
	{
		System.out.println("checking response code");
		 int statuscode=response.getStatusCode();
		 System.out.println("status code is: "+statuscode);
		 Assert.assertEquals(statuscode,200);
	}
	@Test
	void checkResponseTime()
	{
		System.out.println("checking response time");
		 long responsetime=response.getTime();
		 System.out.println("rsponse time is: "+responsetime);
		 if(responsetime>8000)
		 {
			 System.out.println("response time is greater than 8000");
		 }
		 Assert.assertTrue(responsetime<8000);
	}
	@Test
	void checkStatusLine()
	{
		System.out.println("checking statusline");
		 String statusline=response.getStatusLine();
		 System.out.println("status line is: "+statusline);
		 Assert.assertEquals(statusline,"HTTP/1.1 200 OK");
		 	
	}
	@Test
	void checkContentType()
	{
		System.out.println("checking content type");
		 String contenttype=response.header("Content-Type");
		 System.out.println("Content type is: "+contenttype);
		 Assert.assertEquals(contenttype,"application/json");
		 	
	}
	@Test
	void checkServerType()
	{
		System.out.println("checking server type");
		 String servertype=response.header("Server");
		 System.out.println("server type is: "+servertype);
		 Assert.assertEquals(servertype,"nginx");
	}
	@Test
	void checkcontentEncoding()
	{
		System.out.println("checking contentencoding type");
		 String contentencoding=response.header("Content-Encoding");
		 System.out.println("contentencoding type is: "+contentencoding);
		 Assert.assertEquals(contentencoding,"gzip");
	}
	@Test
	void checkcontentlength()
	{
		System.out.println("checking content length");
		 String contentlength=response.header("Content-Length");
		 System.out.println("content length is: "+contentlength);
		 if(Integer.parseInt(contentlength)>800)
		 {
			 System.out.println("content length is less than 800");
		 }
		 Assert.assertTrue(Integer.parseInt(contentlength)<800);
	}
	@AfterClass
	void tearDown()
	{
		System.out.println("finished Tc1 detail emp testcase");
	}
}
