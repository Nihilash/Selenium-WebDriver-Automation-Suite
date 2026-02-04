package SeleniumAutomation.Seleniumbesant;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Capabilities;

public class WebdriverMethods2 {

    public static void main(String[] args) throws InterruptedException {
        // Launch Chrome (or Chromium via Selenium Manager)
        WebDriver driver = new ChromeDriver();

        try {
            // Print browser details
            Capabilities caps = ((ChromeDriver) driver).getCapabilities();
            System.out.println("Browser Name   : " + caps.getBrowserName());
            System.out.println("Browser Version: " + caps.getBrowserVersion());

            // Print raw chromeOptions to see which binary Selenium Manager picked
            Object options = caps.getCapability("goog:chromeOptions");
            System.out.println("Chrome Options : " + options);

            // Maximize browser window
            driver.manage().window().maximize();

            // Open Facebook
            driver.get("https://www.facebook.com");

            // Pause for 5 seconds so you can see it
            Thread.sleep(5000);

            // Get Current URL
            @Nullable String url = driver.getCurrentUrl();
            if (url != null) {
                System.out.println("Current URL: " + url);
            }

            // Get Page Source length
            @Nullable String src = driver.getPageSource();
            if (src != null) {
                System.out.println("Page Source length: " + src.length());
            }

            // Verify title
            @Nullable String title = driver.getTitle();
            if (title != null) {
                System.out.println("Page Title: " + title);

                if (title.contains("Facebook")) {
                    System.out.println("✅ Test case passed");
                } else {
                    System.out.println("❌ Test case failed (title mismatch)");
                }
            } else {
                System.out.println("❌ Test case failed (title was null)");
            }

            // Keep browser open for a few more seconds
            Thread.sleep(5000);

        } finally {
            // Always close browser
            driver.quit();
        }
    }
}
