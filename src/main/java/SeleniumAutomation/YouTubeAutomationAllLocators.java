package SeleniumAutomation.Seleniumbesant;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class YouTubeAutomationAllLocators {

    public static void main(String[] args) throws InterruptedException {

        // Launch Chrome in Guest mode
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--guest");
        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.get("https://www.youtube.com");

        Thread.sleep(3000); // wait for homepage

        //  name → search box
        WebElement searchBox = driver.findElement(By.name("search_query"));
        searchBox.sendKeys("John Wick 4 trailer");
        searchBox.sendKeys(Keys.ENTER); // search

        Thread.sleep(4000); // wait for results

        //  id → all video titles
        List<WebElement> videos = driver.findElements(By.id("video-title"));

        //  select video by title
        String targetTitle = "John Wick: Chapter 4";
        for (WebElement video : videos) {
            if (video.getAttribute("title").contains(targetTitle)) {
                video.click();
                break;
            }
        }

        Thread.sleep(5000); // wait for video page

        //  className → video player
        driver.findElement(By.className("html5-video-player")).click();

        // id → video container
        driver.findElement(By.id("movie_player"));

        //  tagName → page title
        driver.findElement(By.tagName("title"));

        Thread.sleep(30000); // watch 30 seconds

        driver.quit();
        System.out.println("Played John Wick 4 trailer using all locators.");
    }
}

