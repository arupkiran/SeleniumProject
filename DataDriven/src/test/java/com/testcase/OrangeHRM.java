package com.testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseClass;

public class OrangeHRM extends BaseClass {
	
	@Test(dataProvider="credentials")
	public void loginPage(String username,String Password)
	{
		//driver.findElements(By.id("txtUsername")).clear();
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		driver.findElements(By.id("txtUsername")).clear();
		//driver.findElements(By.id("txtUsername")).clear();
		driver.findElement(By.id("txtPassword")).sendKeys(Password);
		driver.findElements(By.id("txtUsername")).clear();
		driver.findElement(By.id("btnLogin")).click();
		String expURL="https://opensource-demo.orangehrmlive.com/index.php/dashboard";
		String actualURL=driver.getCurrentUrl();
		Assert.assertEquals(actualURL, expURL);
		
	}

}
