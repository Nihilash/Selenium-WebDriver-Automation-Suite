package RobotANDAUTOMACTIONS;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class ActionsDemo {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Call whichever test you want to run
        //scrollTest(driver);
        //mouseHoverTest(driver);
        //dragDropTest(driver);
        DoubleClickTest(driver);
        //driver.quit();
    }

    // 1. Scrolling Example
    public static void scrollTest(WebDriver driver) throws InterruptedException {
        driver.get("https://www.selenium.dev/");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll down by pixels
        js.executeScript("window.scrollBy(0, 600);");
        Thread.sleep(2000);

        // Scroll till element is visible
        WebElement element = driver.findElement(By.xpath("//h2[text()='Selenium Level Sponsors']"));
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(2000);

        // Scroll to bottom
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        Thread.sleep(2000);

        System.out.println("✅ Scrolling Test Done!");
    }

    // 2. Mouse Hover Example with info printing (demo site)
    public static void mouseHoverTest(WebDriver driver) throws InterruptedException {
        driver.get("https://demoqa.com/tool-tips");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Hover over the button
        WebElement hoverButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("toolTipButton")
        ));

        Actions actions = new Actions(driver);
        actions.moveToElement(hoverButton).perform();  // Hover
        Thread.sleep(1000);

        // Capture tooltip text
        WebElement tooltip = driver.findElement(By.cssSelector(".tooltip-inner"));
        System.out.println("Hover Info: " + tooltip.getText());

        System.out.println("✅ Mouse Hover Test Done!");
    }

    // 3. Drag and Drop Example
    public static void dragDropTest(WebDriver driver) throws InterruptedException {
        driver.get("https://jqueryui.com/droppable/");

        driver.switchTo().frame(0); // Switch to frame containing draggable & droppable

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(source, target).perform();
        Thread.sleep(2000);

        System.out.println("✅ Drag & Drop Test Done!");
    }
    
    //4.Double Click
    public static void DoubleClickTest(WebDriver driver) throws InterruptedException {
    	driver.get("https://demoqa.com/tool-tips");
    	//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	driver.findElement(By.xpath("//span[@class='pr-1']")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(By.xpath("//li[@id='item-4']"));
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        element.click();
        Thread.sleep(2000);
        WebElement button = driver.findElement(By.id("doubleClickBtn"));
    	js.executeScript("window.scrollBy(0, 200);");
        Thread.sleep(2000);
        Actions actions2 = new Actions(null);
		actions2.doubleClick(button);
		actions2.perform();
    }
}
