package com.base;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

public class BaseClass {
	public WebDriver driver;
	@BeforeMethod
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Browserdriver\\chromedriver_win32 (1)\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
	}
	/* @DataProvider(name="credentials")
	public String[][] GetData()
	{
		String logindata[][]= {{"Admin","admin123"},
				{"Admin","Admin123"},
				{"admin","Admin123"}
				
		};
		return logindata;
	}*/
	@DataProvider(name="credentials")
	public String[][] ExcelData() throws IOException{
		String path="C:\\eclipse-workspace\\DataDriven\\TestData\\User.xlsx";
		Utility ul=new Utility(path);
		int rowcount=ul.getRowCount("Sheet1");
		int cellcount=ul.getColCount("Sheet1",1);
		String[][] logindata= new String[rowcount][cellcount];
		for(int i=1;i<=rowcount;i++)
		{
			for(int j=0;j<cellcount;j++)
			{
				logindata[i-1][j]=ul.getCellData("Sheet1",i,j);
			}
		}
	
		return logindata;
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
