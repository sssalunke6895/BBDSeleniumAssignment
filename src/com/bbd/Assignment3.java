package com.bbd;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment3 {

	//private static final String Trending = null;
	//private static final String Now = null;

	public static void main(String[] args) throws InterruptedException {
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", path + "/Drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://in.search.yahoo.com/?fr2=inr");
		driver.findElement( By.xpath("//h4[@class='title d-i fz-s fw-xl s-label']")).getText();
		//if (text.contentEquals("Trending Now")) {
			//System.out.println("Text : " + text);
		//} 
		//else {
		//	System.out.println("Text : " + text);
			//driver.close();
			//driver.quit();
		//}
		List<WebElement> links = driver.findElements(By.xpath("(//li[@class=icon-find])//a"));
		int size = links.size();
		System.out.println("Total Number of Links : " + size);
		for (int i = 0; i < size; i++) {
			System.out.println(links.get(i).getText());
		}

		for (int i = 0; i < size; i++) {
			String linkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
			links.get(i).sendKeys(linkTab);
		}
		
		driver.findElement(By.xpath("//a[@title='COVID-19 in India']")).click();
		System.out.print("Total Casses in India : ");
		String cases= driver.findElement(By.xpath("//*[@id=\"web\"]/ol/li[4]/div/table/tbody/tr[1]/td[2]/div/span")).getText();
		System.out.print(cases+"\n");
		String death = driver.findElement(By.xpath("//*[@id=\\\"web\\\"]/ol/li[4]/div/table/tbody/tr[1]/td[4]/div/span")).getText();
		System.out.print("Death Cases : ");
		System.out.print(death);
		Thread.sleep(5000);
		driver.close();
		driver.quit();
	}
}
