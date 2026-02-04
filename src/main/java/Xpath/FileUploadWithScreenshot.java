package Xpath;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class FileUploadWithScreenshot {
    public static void main(String[] args) throws Exception {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://testautomationcentral.com/demo/file_upload.html");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // ------------------ Step 1: Send File Path directly ------------------
        WebElement fileInput = driver.findElement(By.id("file-input"));
        fileInput.sendKeys("D:\\Setting Up a Kubernetes Cluster with Kubeadm! .pdf");

        // ------------------ Step 2: Click the visible Upload button ------------------
        WebElement uploadBtn = driver.findElement(By.cssSelector(".bg-blue-500.text-white.px-4.py-2.rounded"));
        uploadBtn.click();

        // ------------------ Step 3: Wait for success message ------------------
        WebElement successMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//*[contains(text(),'uploaded') or contains(text(),'success')]")
        ));
        System.out.println("Upload Message: " + successMsg.getText());

        // ------------------ Step 4: Take Screenshot ------------------
        TakesScreenshot ts = (TakesScreenshot) driver;
        File srcFile = ts.getScreenshotAs(OutputType.FILE);
        File destFile = new File("D:\\besant\\java ecllipse1\\Seleniumbesant\\upload_screenshot.png");
        org.openqa.selenium.io.FileHandler.copy(srcFile, destFile);
        System.out.println("Screenshot saved at: " + destFile.getAbsolutePath());

        driver.quit();
    }
}

