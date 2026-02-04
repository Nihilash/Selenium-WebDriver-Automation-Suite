package Xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class XpathContainsStratswith {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.edge.driver",
                "D:\\besant\\java ecllipse1\\SeleniumAutomation\\DriverLinks\\edgedriver_win64\\msedgedriver.exe");

        WebDriver driver = new EdgeDriver();
        driver.get("file:///D:/besant/java%20ecllipse1/Seleniumbesant/new%201.html");
        driver.manage().window().maximize();

        Actions actions = new Actions(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // ----------------- 1st Course Box - Using starts-with -----------------
        System.out.println("// ----------------- 1st Course Box: starts-with -----------------");
        WebElement firstBox = driver.findElement(By.xpath("//div[@class='course-box'][1]"));
        js.executeScript("arguments[0].style.border='3px solid red'; arguments[0].style.transition='all 0.3s';", firstBox);
        Thread.sleep(500);

        List<WebElement> firstBoxElements = firstBox.findElements(By.xpath(
                ".//h3[starts-with(text(),'Python')] | " +
                ".//span[starts-with(@class,'glow')] | " +
                ".//button[starts-with(@class,'enrollBtn')] | " +
                ".//button[starts-with(@class,'feedbackBtn')] | " +
                ".//span[starts-with(@class,'start-date')]"
        ));

        System.out.println("// Highlighting internal elements using starts-with:");
        for (WebElement el : firstBoxElements) {
            actions.moveToElement(el).perform();
            js.executeScript("arguments[0].style.background='yellow'; arguments[0].style.color='black'; arguments[0].style.transition='all 0.3s';", el);
            System.out.println("1st Box Element: " + el.getText());
            Thread.sleep(500);
        }

        // ----------------- 2nd Course Box - Using contains -----------------
        System.out.println("// ----------------- 2nd Course Box: contains -----------------");
        WebElement secondBox = driver.findElement(By.xpath("//div[h3[contains(text(),'Web Development')]]"));
        js.executeScript("arguments[0].style.border='3px solid green'; arguments[0].style.transition='all 0.3s';", secondBox);
        Thread.sleep(500);

        List<WebElement> secondBoxElements = secondBox.findElements(By.xpath(
                ".//h3[contains(text(),'Web')] | " +
                ".//span[contains(@class,'glow')] | " +
                ".//button[contains(@class,'enrollBtn')] | " +
                ".//button[contains(@class,'feedbackBtn')] | " +
                ".//span[contains(@class,'start-date')]"
        ));

        System.out.println("// Highlighting internal elements using contains:");
        for (WebElement el : secondBoxElements) {
            actions.moveToElement(el).perform();
            js.executeScript("arguments[0].style.background='orange'; arguments[0].style.color='white'; arguments[0].style.transition='all 0.3s';", el);
            System.out.println("2nd Box Element: " + el.getText());
            Thread.sleep(500);
        }

        // ----------------- 3rd Course Box - Using starts-with + contains -----------------
        System.out.println("// ----------------- 3rd Course Box: starts-with + contains -----------------");
        WebElement thirdBox = driver.findElement(By.xpath("//div[h3[contains(text(),'Data Science')]]"));
        js.executeScript("arguments[0].style.border='3px solid blue'; arguments[0].style.transition='all 0.3s';", thirdBox);
        Thread.sleep(500);

        List<WebElement> thirdBoxElements = thirdBox.findElements(By.xpath(
                ".//h3[starts-with(text(),'Data')] | " +
                ".//span[contains(@class,'glow')] | " +
                ".//button[contains(@class,'enrollBtn')] | " +
                ".//button[contains(@class,'feedbackBtn')] | " +
                ".//span[starts-with(@class,'start-date')]"
        ));

        System.out.println("// Highlighting internal elements using starts-with + contains:");
        for (WebElement el : thirdBoxElements) {
            actions.moveToElement(el).perform();
            js.executeScript("arguments[0].style.background='lightblue'; arguments[0].style.color='black'; arguments[0].style.transition='all 0.3s';", el);
            System.out.println("3rd Box Element: " + el.getText());
            Thread.sleep(500);
        }

        Thread.sleep(2000);
        driver.quit();
    }
}
