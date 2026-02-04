package locatorsandCssSelectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CssSelectorsExamples {
    public static void main(String[] args) {

        // Launch Chrome browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Load the HTML file (update your path accordingly)
        driver.get("file:///D:/besant/java%20ecllipse1/Seleniumbesant/new%201.html");

        // Explicit wait for dynamic elements
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));

        // ---------- 4.1 Basics of CSS Selector ----------
        // Tag selector: selects elements by tag
        WebElement heading = driver.findElement(By.cssSelector("h2"));
        System.out.println("Page Heading (tag h2): " + heading.getText());

        // ID selector: selects element by ID
        WebElement courseContainer = driver.findElement(By.cssSelector("#courseContainer"));
        System.out.println("Course container ID: " + courseContainer.getAttribute("id"));

        // Class selector: selects elements by class name
        WebElement firstCourseBox = driver.findElement(By.cssSelector(".course-box"));
        System.out.println("First Course Box class: " + firstCourseBox.getAttribute("class"));

        // Tag + Class selector: tag with a specific class
        WebElement firstCourseName = driver.findElement(By.cssSelector("h3.glow"));
        System.out.println("First Course Name (h3.glow): " + firstCourseName.getText());

        // ---------- 4.2 Attribute Selectors ----------
        // Exact match
        WebElement modal = driver.findElement(By.cssSelector("div[id='modal']"));
        System.out.println("Modal Display (exact match): " + modal.getCssValue("name"));

        // ---------- 4.3 Combinators ----------
        // Complex chain button to open modal
        WebElement advancedButton = driver.findElement(By.cssSelector(".course-box:nth-child(1) button.enrollBtn"));
        System.out.println("Advanced Usage (complex chain): " + advancedButton.getText());

        // ---------- Interact with modal ----------
        advancedButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".modal-content")));

        // Child combinator: direct children
        WebElement modalTitle = driver.findElement(By.cssSelector(".modal-content > h3"));
        System.out.println("Modal Title (child >): " + modalTitle.getText());

        // Adjacent sibling combinator
        WebElement adjacentButton = driver.findElement(By.cssSelector("textarea + br + button"));
        System.out.println("Adjacent Button Text (+): " + adjacentButton.getText());

        // General sibling combinator
        WebElement generalSibling1 = driver.findElement(By.cssSelector("textarea ~ button"));
        WebElement generalSibling2 = driver.findElement(By.cssSelector("textarea ~ button:nth-child(5)"));
        System.out.println("General Sibling Button (~) 1: " + generalSibling1.getText());
        System.out.println("General Sibling Button (~) 2: " + generalSibling2.getText());

        // Fill modal inputs
        WebElement modalNameInput = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[id$='Name']")));
        modalNameInput.clear();
        modalNameInput.sendKeys("Nihilash");

        WebElement modalReasonInput = driver.findElement(By.cssSelector("textarea[id*='Reason']"));
        modalReasonInput.clear();
        modalReasonInput.sendKeys("Learning CSS Selectors - Modal Test");

        // Submit modal
        WebElement modalSubmitBtn = driver.findElement(By.cssSelector("#submitBtn"));
        modalSubmitBtn.click();

        // Wait until modal closes
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".modal-content")));

     // Wait until feedback button text changes in the first course box
        WebElement firstCourseFeedbackBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.cssSelector(".course-box:nth-child(1) button.feedbackBtn"))); // adjust class if needed

        System.out.println("Thanks Message after modal submit: " + firstCourseFeedbackBtn.getText());


        // ---------- 4.4 Pseudo-classes ----------
        WebElement firstChildCourse = driver.findElement(By.cssSelector(".course-box:first-child h3"));
        System.out.println("First child course: " + firstChildCourse.getText());

        WebElement lastChildCourse = driver.findElement(By.cssSelector(".course-box:last-child h3"));
        System.out.println("Last child course: " + lastChildCourse.getText());

        WebElement secondChildCourse = driver.findElement(By.cssSelector(".course-box:nth-child(2) h3"));
        System.out.println("Second child course: " + secondChildCourse.getText());

        WebElement notCancelButton = driver.findElement(By.cssSelector("button:not(#cancelBtn)"));
        System.out.println("First button not cancel: " + notCancelButton.getText());

        // ---------- 4.5 Grouping ----------
        WebElement groupElement1 = driver.findElement(By.cssSelector("h2, .glow, #userName"));
        System.out.println("Group Element 1 (h2, .glow, #userName): " + groupElement1.getText());

        driver.quit();
    }
}


