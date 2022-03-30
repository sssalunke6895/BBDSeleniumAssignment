package com.bbd;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Assignment5 {


	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		String path=System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",path+"/Drivers/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		//launch ChromeDriver
		
		System.setProperty("webdriver.gecko.driver", path+"/Drivers/geckodriver.exe");
		WebDriver driver1=new FirefoxDriver();
		
		//launch FirefoxDriver
		
		System.setProperty("webdriver.edge.driver", path+"/Drivers/msedgedriver.exe");
		WebDriver driver2=new EdgeDriver();
		
		driver.manage().window().maximize();
		driver.navigate().to("https://www.myntra.com/");

			
			// Choose any section like men or women from menu bar
			Actions a = new Actions(driver1);
			a.moveToElement(driver1.findElement(By.xpath("//a[contains(text(),'Men')]"))).build().perform();
			a.click();
			// Verify Category
			WebElement category = driver1.findElement(By.xpath("//a[contains(text(),'T-Shirts')]"));
			JavascriptExecutor js = (JavascriptExecutor) driver1;
			//Click on sort by and choose What’s new
			js.executeScript("arguments[0].click()", category);
			Actions a1 = new Actions(driver1);
			a1.moveToElement(driver1.findElement(By.xpath("//div[@class='sort-sortBy']"))).build().perform();
			a1.moveToElement(driver1.findElement(By.xpath("//label[contains(text(),\"What's New\")]"))).click().build()
					.perform();
			Thread.sleep(2000);
			// Verify Filters Like Brand,Discount,Range etc.
			a1.moveToElement(driver1.findElement(By.cssSelector("ul[class='brand-list'] input[value='Puma']"))).click()
					.build().perform();
			Thread.sleep(2000);
			// Verify Discount
			a1.moveToElement(driver1.findElement(By.cssSelector("[class='discount-list'] li:nth-child(2)"))).click().build()
					.perform();
			Thread.sleep(2000);
			// Verify Range
			a1.moveToElement(driver1.findElement(By.cssSelector("[class='Range'] li:nth-child(2)"))).click().build()
					.perform();
			Thread.sleep(2000);
			// Selecting Product
			a1.moveToElement(driver1.findElement(By.xpath("//ul[@class=\"results-base\"]/li[1]//img[@class=\"img-responsive\"]"))).click().build().perform();
			Thread.sleep(3000);
			//Getting Windows Id for Multiple Tabs
			Set<String> handles=driver1.getWindowHandles();
			Iterator<String> itr = handles.iterator();
			String parent=itr.next();
			String child=itr.next();
			//Get Permission to Child/Next Tab Using switchTo()
			driver1.switchTo().window(child);
			//Verify Size of Product
			driver1.findElement(By.xpath("//p[contains(text(),'L')]")).click();
			//Verify Adding Item To Cart
			driver1.findElement(By.xpath("//div[contains(text(),'ADD TO BAG')]")).click();
			//Verify Cart or Bag
			driver1.findElement(By.xpath("//span[@class='myntraweb-sprite desktop-iconBag sprites-headerBag']")).click();
			//Verify Move to WishList
			Thread.sleep(3000);
			
			driver1.findElement(By.xpath("//button[@class='inlinebuttonV2-base-actionButton bulkActionStrip-desktopBulkWishlist']")).click();
			
			
			driver1.quit();
}}