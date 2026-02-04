package SeleniumAutomation.Seleniumbesant;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebdriverMethods {

    public static void main(String[] args) throws InterruptedException {
        // Launch Chrome
        WebDriver driver = new ChromeDriver();

        try {
            // Maximize browser window
            driver.manage().window().maximize();

            // Open Facebook
            driver.get("https://www.facebook.com");

            // Pause for 5 seconds so the page loads and you can see it
            Thread.sleep(5000);

            // Get Current URL
            @Nullable String url = driver.getCurrentUrl();
            if (url != null) {
                System.out.println("Current URL: " + url);
            }

            // Get Page Source (printing length to avoid console overflow)
            @Nullable String src = driver.getPageSource();
            if (src != null) {
                System.out.println("Page Source length: " + src.length());
            }

            // Verify title
            @Nullable String title = driver.getTitle();
            if (title != null) {
                System.out.println("Page Title: " + title);

                if (title.contains("Facebook")) {
                    System.out.println(" Test case passed");
                } else {
                    System.out.println(" Test case failed (title mismatch)");
                }
            } else {
                System.out.println("Test case failed (title was null)");
            }

            // Keep browser open for a few more seconds before closing
            Thread.sleep(5000);

        } finally {
            // Always close the browser
            driver.quit();
        }
    }
}
