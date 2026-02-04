package SeleniumAutomation.Seleniumbesant;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class YouTubeAutomationTitleXPath {

    public static void main(String[] args) throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--guest");
        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.get("https://www.youtube.com");

        Thread.sleep(3000);

        //  Search box
        WebElement searchBox = driver.findElement(By.xpath("//input[@name='search_query']"));
        searchBox.sendKeys("John Wick 4");
        searchBox.sendKeys(Keys.ENTER);

        Thread.sleep(4000); // wait for results

        //  Video by title containing "John Wick: Chapter 4"
        WebElement targetVideo = driver.findElement(By.xpath(
            "//a[@id='video-title' and contains(@title, 'John Wick: Chapter 4')]"
        ));

        // Scroll into view
        ((JavascriptExecutor) driver).executeScript(
            "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", targetVideo
        );
        Thread.sleep(500);

        // Click via JavaScript
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", targetVideo);

        Thread.sleep(5000); // wait for video page

        // Play video
        WebElement videoPlayer = driver.findElement(By.xpath("//div[contains(@class,'html5-video-player')]"));
        videoPlayer.click();

        Thread.sleep(30000); // watch 30 seconds

        driver.quit();
        System.out.println(" Played John Wick 4 video using contains() XPath.");
    }
}

