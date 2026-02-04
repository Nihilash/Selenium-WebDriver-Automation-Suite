package Xpath;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Iframes {
	public static void main(String[] args) {
     WebDriver driver = new ChromeDriver();
     driver.manage().window().maximize();
     driver.get("file:///D:/besant/java%20ecllipse1/Seleniumbesant/Frames.html");
     List<WebElement> frames = driver.findElements(By.tagName("iframe"));
     System.out.println(frames.size());
     WebElement frame1 = driver.findElement(By.xpath("//iframe[@id='frame1']"));
     driver.switchTo().frame(frame1);
     System.out.println(driver.findElement(By.tagName("h2")).getText());
     driver.switchTo().frame(0);
     System.out.println(driver.findElement(By.tagName("h3")).getText());
     driver.switchTo().parentFrame();
     driver.switchTo().defaultContent();
//     WebElement MainPage = driver.findElement(By.tagName("h1"));
//     driver.switchTo().frame(MainPage);
     System.out.println(driver.findElement(By.tagName("h1")).getText());
     System.out.println(driver.getTitle());
     driver.quit();
     
     
	}
}
