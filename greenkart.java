package Selenium.java;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class greenkart {






	public static void main(String args[]) throws InterruptedException
	{
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	
	String[] item = {"Brocolli","Brinjal","Apple","Musk Melon","Walnuts"};
	int[] quantity = {2,4,6,8,4};
	
	List<WebElement> vegs = driver.findElements(By.xpath("//h4"));
	int j=0;
	for(int i=0; i<vegs.size();i++)
	{
	
		String[] name = vegs.get(i).getText().split("-");
		String formatted= name[0].trim();
		
		List itemlist = Arrays.asList(item);
//		driver.findElements(By.xpath("//h4[@class='product-name'])").
		if(itemlist.contains(formatted))
		{
	j++;

			
			WebElement a= driver.findElement(By.xpath("//input[@class='quantity']"));
					a.clear();
a.sendKeys(String.valueOf(quantity[j-1]));
		driver.findElements(By.xpath("(//div[@class='product-action'])/button")).get(i).click();
		if(j==quantity.length) {
			break;
		}
	}		
}
	driver.findElement(By.xpath("//a[@class='cart-icon']")).click();
	driver.findElement(By.xpath("(//button[@type='button'])[1]")).click();	
	Thread.sleep(2000);
	driver.findElement(By.xpath("//button[text()='Place Order']")).click();
	Thread.sleep(2000);
	
	WebElement country= driver.findElement(By.xpath("//select"));
	Select s= new Select(country);
	s.selectByVisibleText("India");

	driver.findElement(By.xpath("//input")).click();  
	driver.findElement(By.xpath("//button")).click();
	
	Thread.sleep(6000);
}
}
