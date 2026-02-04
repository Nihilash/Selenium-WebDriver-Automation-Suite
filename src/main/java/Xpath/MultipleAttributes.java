package Xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleAttributes {
	public static void main(String[] args) throws InterruptedException {
      WebDriver driver = new ChromeDriver();
      driver.manage().window().maximize();
      driver.get("https://the-internet.herokuapp.com/login");
      Thread.sleep(2000);
      WebElement UserName = driver.findElement(By.xpath("//input[@name='username'or @id='username']"));
      UserName.sendKeys("Nihilash");
      driver.findElement(By.xpath("//input[contains(@id='password']")).sendKeys("pass12");
	}
}
