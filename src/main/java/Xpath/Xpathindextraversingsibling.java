package Xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.JavascriptExecutor;

import java.util.List;

public class Xpathindextraversingsibling {
    public static void main(String[] args) throws InterruptedException {
        // Set EdgeDriver path
        System.setProperty("webdriver.edge.driver",
                "D:\\besant\\java ecllipse1\\SeleniumAutomation\\DriverLinks\\edgedriver_win64\\msedgedriver.exe");

        WebDriver driver = new EdgeDriver();
        driver.get("file:///D:/besant/java%20ecllipse1/Seleniumbesant/new%201.html");
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // ================= 1. INDEX BASED SELECTION =================
        System.out.println("\n===== 1. INDEX BASED SELECTION =====");
        Thread.sleep(2000);

        List<WebElement> courseBoxes = driver.findElements(By.xpath("//div[@class='course-box']"));
        int boxIndex = 1;
        for (WebElement box : courseBoxes) {
            System.out.println("Course Box " + boxIndex + ": " + box.findElement(By.xpath(".//h3")).getText());
            boxIndex++;
        }
        Thread.sleep(1000);

        // ================= 2. TRAVERSING WITHOUT AXES (Course Box 1) =================
        System.out.println("\n===== 2. TRAVERSING WITHOUT AXES (Course Box 1) =====");
        WebElement courseBox1 = driver.findElement(By.xpath("(//div[@class='course-box'])[1]"));

        System.out.println(">>> Forward Traversing Steps (Without Axes)");
        WebElement title1 = courseBox1.findElement(By.xpath("./h3"));
        highlight(js, title1);
        System.out.println("Step 1: Highlight Title");

        WebElement firstSubject1 = courseBox1.findElement(By.xpath("./p[2]/span[1]"));
        highlight(js, firstSubject1);
        System.out.println("Step 2: Highlight First Subject");

        WebElement enrollBtn1 = courseBox1.findElement(By.xpath("./button[@class='enrollBtn']"));
        highlight(js, enrollBtn1);
        System.out.println("Step 3: Highlight Enroll Button");
        Thread.sleep(1000);

        System.out.println("\n>>> Backward Traversing Steps (Without Axes)");
        highlight(js, enrollBtn1);
        System.out.println("Step 1: From Enroll Button");

        highlight(js, firstSubject1);
        System.out.println("Step 2: Back to First Subject");

        highlight(js, title1);
        System.out.println("Step 3: Back to Title");
        Thread.sleep(1000);

        // ================= 3. TRAVERSING WITH AXES (Course Box 3) =================
        System.out.println("\n===== 3. TRAVERSING WITH AXES (Course Box 3) =====");
        WebElement courseBox3 = driver.findElement(By.xpath("(//div[@class='course-box'])[3]"));

        System.out.println(">>> Forward Traversing Steps (With Axes)");
        WebElement forwardAxes = courseBox3.findElement(By.xpath("./h3/following::button[@class='enrollBtn'][1]"));
        highlight(js, forwardAxes);
        System.out.println("Step 1: Highlight Enroll Button using following axis");
        Thread.sleep(1000);

        System.out.println("\n>>> Backward Traversing Steps (With Axes)");
        WebElement backwardAxes = courseBox3.findElement(By.xpath("./button[@class='enrollBtn']/preceding::h3[1]"));
        highlight(js, backwardAxes);
        System.out.println("Step 1: Highlight Title using preceding axis");
        Thread.sleep(1000);

        // ================= 4. SIBLING NAVIGATION (Course Titles) =================
        System.out.println("\n===== 4. SIBLING NAVIGATION (Course Titles) =====");

        System.out.println(">>> Forward Traversing (Sibling With Axes)");
        WebElement forwardSiblingAxes = driver.findElement(By.xpath("//div[@class='course-box'][1]/following-sibling::div[1]/h3"));
        highlight(js, forwardSiblingAxes);
        System.out.println("Step 1: Highlight Next Course Box Title");
        Thread.sleep(1000);

        System.out.println(">>> Backward Traversing (Sibling With Axes)");
        WebElement backwardSiblingAxes = driver.findElement(By.xpath("//div[@class='course-box'][3]/preceding-sibling::div[1]/h3"));
        highlight(js, backwardSiblingAxes);
        System.out.println("Step 1: Highlight Previous Course Box Title");
        Thread.sleep(1000);

        System.out.println(">>> Forward Traversing (Sibling Without Axes)");
        WebElement forwardSiblingNoAxes = driver.findElement(By.xpath("(//div[@class='course-box'])[1]/following-sibling::div[1]/h3"));
        highlight(js, forwardSiblingNoAxes);
        System.out.println("Step 1: Highlight Next Course Box Title (No Axes)");
        Thread.sleep(1000);

        System.out.println(">>> Backward Traversing (Sibling Without Axes)");
        WebElement backwardSiblingNoAxes = driver.findElement(By.xpath("(//div[@class='course-box'])[3]/preceding-sibling::div[1]/h3"));
        highlight(js, backwardSiblingNoAxes);
        System.out.println("Step 1: Highlight Previous Course Box Title (No Axes)");
        Thread.sleep(1000);

        driver.quit();
    }

    // Helper method to highlight element
    public static void highlight(JavascriptExecutor js, WebElement element) {
        js.executeScript("arguments[0].style.border='3px solid red'", element);
    }
}
