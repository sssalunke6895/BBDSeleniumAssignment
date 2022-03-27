package com.bbd;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment1 {
	public static void main(String[] args)
	{
		String path=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",path+"/Drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://qatechhub.com/");
		String title=driver.getTitle();
		String url=driver.getCurrentUrl();
		System.out.println("Title is : "+title);
		System.out.println("Url is :"+url);
		driver.navigate().to("https://www.facebook.com/");
		driver.navigate().back();
		System.out.println("Url after navigate back : "+driver.getCurrentUrl());
		driver.navigate().forward();
		driver.navigate().refresh();
		driver.close();
		driver.quit();
	}
	

}
