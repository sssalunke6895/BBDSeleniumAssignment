package Assignment5;


import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;

public class Microsoft {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		String path=System.getProperty("user.dir");
		System.setProperty("webdriver.edge.driver", path+"/Drivers/msedgedriver.exe");
		WebDriver driver=new EdgeDriver();
//driver.get("https://www.google.com/chrome/");
		driver.manage().window().maximize();
		driver.navigate().to("https://www.myntra.com/");

			
			// Choose any section like men or women from menu bar
			Actions a = new Actions(driver);
			a.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Men')]"))).build().perform();
			a.click();
			// Verify Category
			WebElement category = driver.findElement(By.xpath("//a[contains(text(),'T-Shirts')]"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			//Click on sort by and choose What’s new
			js.executeScript("arguments[0].click()", category);
			Actions a1 = new Actions(driver);
			a1.moveToElement(driver.findElement(By.xpath("//div[@class='sort-sortBy']"))).build().perform();
			a1.moveToElement(driver.findElement(By.xpath("//label[contains(text(),\"What's New\")]"))).click().build()
					.perform();
			Thread.sleep(2000);
			// Verify Filters Like Brand,Discount,Range etc.
			a1.moveToElement(driver.findElement(By.cssSelector("ul[class='brand-list'] input[value='Puma']"))).click()
					.build().perform();
			Thread.sleep(2000);
			// Verify Discount
			
			a1.moveToElement(driver.findElement(By.cssSelector("[class='discount-list'] li:nth-child(2)"))).click().build()
					.perform();
			Thread.sleep(2000);
			// Selecting Product
			a1.moveToElement(driver.findElement(By.xpath("//img[@title='Puma Men Yellow & Black Essentials Brand Logo Printed Pure Cotton T-shirt']"))).click().build().perform();
			Thread.sleep(3000);
			//Getting Windows Id for Multiple Tabs
			Set<String> handles=driver.getWindowHandles();
			Iterator<String> itr = handles.iterator();
			String parent=itr.next();
			String child=itr.next();
			//Get Permission to Child/Next Tab Using switchTo()
			driver.switchTo().window(child);
			//Verify Size of Product
			driver.findElement(By.xpath("//p[contains(text(),'L')]")).click();
			//Verify Adding Item To Cart
			driver.findElement(By.xpath("//div[contains(text(),'ADD TO BAG')]")).click();
			//Verify Cart or Bag
			driver.findElement(By.xpath("//span[@class='myntraweb-sprite desktop-iconBag sprites-headerBag']")).click();
			//Verify Move to WishList
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("//*[@id=\"cartItemsList\"]/div/div/div/div/div[1]/div/div[1]")).click();
			driver.findElement(By.xpath("//button[@class='inlinebuttonV2-base-actionButton bulkActionStrip-desktopBulkWishlist']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id=\"appContent\"]/div/div/div/div/div[1]/div[5]/div[4]/div/div/div[2]/div[2]/button")).click();
			Thread.sleep(2000);
			driver.quit();		

	
}}
