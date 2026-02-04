package Xpath;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class XpathAxesFollowingPreceedingSiblings {
	public static void main(String[] args) throws InterruptedException, AWTException {
		 ChromeOptions options = new ChromeOptions();
	     options.addArguments("--guest");
	     
	     WebDriver driver = new ChromeDriver(options);
	     driver.manage().window().maximize();
	     driver.get("https://www.saucedemo.com");
	     System.out.println("opening sauce demo website: "+driver.getTitle());
	     Thread.sleep(1000);
	     driver.findElement(By.xpath("//div[@class='login_logo']//following::input[1]")).sendKeys("standard_user");
	     driver.findElement(By.xpath("//div[@class='login_logo']//following::input[2]")).sendKeys("secret_sauce");
	     driver.findElement(By.xpath("//div[@id='login_button_container']//following-sibling::input[1]")).click();  
	     driver.findElement(By.xpath("//div[@class='inventory_list']//following-sibling::div[5]/div[1]")).click();
	     driver.navigate().back();
	     driver.findElement(By.xpath("//div[@class='inventory_list']//following-sibling::div[2]/div[1]")).click();
	     System.out.println(driver.findElement(By.xpath("//div[@class='inventory_details_container']//following-sibling::div[1]/div[1]")).getText());
	     System.out.println(driver.findElement(By.xpath("//div[@class='inventory_details_container']//following-sibling::div[1]/div[2]")).getText());
	     System.out.println(driver.findElement(By.xpath("//div[@class='inventory_details_container']//following-sibling::div[1]/div[3]")).getText());
	     driver.findElement(By.xpath("(//button[@class='btn btn_primary btn_small btn_inventory']/preceding::button)[last()]")).click();
	     driver.findElement(By.xpath("//div[@id='page_wrapper']//following-sibling::div[2]")).click();
	     driver.navigate().back();
	     driver.findElement(By.xpath("//div[@class='inventory_list']//following-sibling::div[2]/div[1]")).click();
	     driver.findElement(By.xpath("(//button[@class='btn btn_primary btn_small btn_inventory'])[1]")).click();
	     System.out.println("T shirt added to cart back to inventory list");
         driver.findElement(By.xpath("(//button[@class='btn btn_secondary btn_small btn_inventory']//preceding::button)[last()]")).click();
         driver.findElement(By.xpath("//button[contains(@class,'btn_secondary') and normalize-space()='Remove']//preceding::a[@class='shopping_cart_link'][1]")).click();
         List<WebElement> cartItems = driver.findElements(
        		    By.xpath("//div[@class='cart_item']//div[@class='inventory_item_name']")
        		);

         System.out.println("Total items in cart: " + cartItems.size());
         for (WebElement item : cartItems) {
        		    System.out.println(item.getText());
        		}
         driver.findElement(By.xpath("//button[@id='checkout']/preceding-sibling::button[1]")).click();
         driver.findElement(By.xpath("//button[contains(@class,'btn_secondary') and normalize-space()='Remove']//preceding::a[@class='shopping_cart_link'][1]")).click();
         driver.findElement(By.xpath("//div[@class='cart_footer']/button[2]")).click();
         driver.findElement(By.cssSelector("input[placeholder='First Name']")).sendKeys("John");
         driver.findElement(By.cssSelector("input[placeholder='Last Name']")).sendKeys("Smith");
         driver.findElement(By.cssSelector("input[placeholder='Zip/Postal Code']")).sendKeys("600001");
         driver.findElement(By.id("continue")).click();
         WebElement summaryInfo = driver.findElement(By.className("summary_info"));
         System.out.println(summaryInfo.getText());
         driver.findElement(By.id("finish")).click();
         driver.findElement(By.id("back-to-products")).click();
         Robot robot = new Robot();

      // scroll one page down
      robot.keyPress(KeyEvent.VK_PAGE_DOWN);
      robot.keyRelease(KeyEvent.VK_PAGE_DOWN);

      // small delay so you see the scroll
      Thread.sleep(1000);

      // scroll one page up
      robot.keyPress(KeyEvent.VK_PAGE_UP);
      robot.keyRelease(KeyEvent.VK_PAGE_UP);

      // scroll step by step (Down arrow 3 times)
      for (int i = 0; i < 3; i++) {
          robot.keyPress(KeyEvent.VK_DOWN);
          robot.keyRelease(KeyEvent.VK_DOWN);
          Thread.sleep(500);
      }
     driver.quit();
	}
}
