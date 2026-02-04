package Xpath;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class Xpathattributetextmultiattri {
    public static void main(String[] args) throws InterruptedException {
        // Set EdgeDriver path
        System.setProperty("webdriver.edge.driver",
                "D:\\besant\\java ecllipse1\\SeleniumAutomation\\DriverLinks\\edgedriver_win64\\msedgedriver.exe");

        // Initialize EdgeDriver
        WebDriver driver = new EdgeDriver();

        // Open local HTML file or URL
        driver.get("file:///D:/besant/java%20ecllipse1/Seleniumbesant/new%201.html");
        driver.manage().window().maximize();

        // ------------------- XPath Examples -------------------

        // 1. Using single attribute
        System.out.println(" // 1. Using single attribute");
        WebElement pythonCourse = driver.findElement(By.xpath("//div[@class='course-box'][1]"));
        System.out.println("Single attribute XPath: " + pythonCourse.getText());

        // 2. Using text()
        System.out.println("// 2. Using text()");
        WebElement pythonTitle = driver.findElement(By.xpath("//h3[text()='Python Basics']"));
        System.out.println("Text XPath: " + pythonTitle.getText());
        
        WebElement WebDevelopmetTitle = driver.findElement(By.xpath("//h3[.='Web Development']"));
        System.out.println("Text XPath: " + WebDevelopmetTitle .getText());

        // 3. Using multiple attributes (AND)
        System.out.println(" // 3. Using multiple attributes (AND)");
        WebElement enrollButtonAnd = driver.findElement(By.xpath("(//button[@class='enrollBtn' and text()='Enroll'])[1]"));
        System.out.println("AND XPath: " + enrollButtonAnd.getText());
        enrollButtonAnd.click();
        driver.findElement(By.xpath("//input[@type = 'text']")).sendKeys("Nihilash");
        driver.findElement(By.xpath("//textarea[@id = 'userReason']")).sendKeys("course needed");
        driver.findElement(By.xpath("//button[@id='submitBtn']")).click();

        // 4. Using OR
        System.out.println(" // 4. Using OR");
        WebElement enrollOrFeedback = driver.findElement(By.xpath("(//button[@class='feedbackBtn' or text()='Feedback'])[2]"));
        System.out.println("OR XPath: " + enrollOrFeedback.getText());
        enrollOrFeedback.click();
        driver.findElement(By.xpath("//input[@type = 'text']")).sendKeys("Nihilash");
        driver.findElement(By.xpath("//textarea[@id = 'userReason']")).sendKeys("Brave course grate experience");
        driver.findElement(By.xpath("//button[@id='submitBtn']")).click();

     // 5. Using union (|) to select either element
        System.out.println("// 5. Using union (|) to select either element");

        // XPath for all subjects in all courses
        List<WebElement> subjects = driver.findElements(By.xpath(
            "//div[h3[text()='Python Basics']]//span[@class='glow'] | " +
            "//div[h3[text()='Web Development']]//span[@class='glow'] | " +
            "//div[h3[text()='Data Science']]//span[@class='glow']"
        ));

        // Initialize Actions for hover
        Actions actions = new Actions(driver);

        // Highlight each subject with hover
        System.out.println("// Highlight each subject with Actions (hover)");
        for (WebElement sub : subjects) {
            // Hover over the element
            actions.moveToElement(sub).perform();

            // Apply glow via JS
            ((JavascriptExecutor) driver).executeScript(
                "arguments[0].style.background='yellow'; arguments[0].style.color='black'; arguments[0].style.transition='all 0.3s';", sub
            );

            System.out.println("Highlighted: " + sub.getText());
            Thread.sleep(1000); // pause to see sequential glow
        }

        // 6. Combining AND + | (multiple conditions)
        System.out.println("// 6. Combining AND + | (multiple conditions)");

     // XPath for all enroll + feedback buttons for all courses
     List<WebElement> buttons = driver.findElements(By.xpath(
             "//div[h3[text()='Python Basics']]//button[@class='enrollBtn' and text()='Enroll'] | " +
             "//div[h3[text()='Python Basics']]//button[@class='feedbackBtn' and text()='Feedback'] | " +
             "//div[h3[text()='Web Development']]//button[@class='enrollBtn' and text()='Enroll'] | " +
             "//div[h3[text()='Web Development']]//button[@class='feedbackBtn' and text()='Feedback'] | " +
             "//div[h3[text()='Data Science']]//button[@class='enrollBtn' and text()='Enroll'] | " +
             "//div[h3[text()='Data Science']]//button[@class='feedbackBtn' and text()='Feedback']"
     ));

     // Initialize Actions for hover
     Actions actions1 = new Actions(driver);

     for (WebElement btn : buttons) {
         // Hover over button
         actions1.moveToElement(btn).perform();

         // Highlight using JS
         ((JavascriptExecutor) driver).executeScript(
                 "arguments[0].style.background='orange'; arguments[0].style.color='white'; arguments[0].style.transition='all 0.3s';", btn
         );

         System.out.println("Button Highlighted: " + btn.getText());
         Thread.sleep(1000); // sequential highlight
     } 

        driver.quit();
    }
}
