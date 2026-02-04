package SeleniumAutomation.Seleniumbesant;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookLoginNavigate {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys("Standard@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("12Pass32@#");
		driver.findElement(By.name("login")).click();
		Thread.sleep(3000);
		driver.navigate().back();
		driver.findElement(By.linkText("Forgotten password?")).click();
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(3000);
		driver.navigate().forward();
		Thread.sleep(3000);
		driver.navigate().refresh();
		driver.quit();
	}

}
