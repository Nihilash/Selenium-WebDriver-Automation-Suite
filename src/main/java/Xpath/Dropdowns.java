package Xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Dropdowns {
    public static void main(String[] args) throws InterruptedException {
        // Launch Chrome
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Open local HTML file
        driver.get("file:///D:/besant/java%20ecllipse1/Seleniumbesant/dropdown.html");

        // -------- Single Select Dropdown --------
        WebElement courseDropdown = driver.findElement(By.id("courseSelect"));
        Select courseSelect = new Select(courseDropdown);
        Thread.sleep(2000);

        // Select by visible text
        courseSelect.selectByVisibleText("Python Basics");
        Thread.sleep(2000);
        // Select by value
        courseSelect.selectByValue("webDev");
        Thread.sleep(2000);
        // Select by index
        courseSelect.selectByIndex(2);
        Thread.sleep(2000);

        // Print all options
        System.out.println("All courses:");
        for (WebElement option : courseSelect.getOptions()) {
            System.out.println(option.getText());
        }

        // -------- Multi-Select Dropdown --------
        WebElement toolsDropdown = driver.findElement(By.id("toolsSelect"));
        Select toolsSelect = new Select(toolsDropdown);
        Thread.sleep(2000);
        // Select multiple options
        toolsSelect.selectByVisibleText("Selenium");
        toolsSelect.selectByValue("docker");
        Thread.sleep(2000);

        // Print all selected options
        System.out.println("Selected tools:");
        for (WebElement selected : toolsSelect.getAllSelectedOptions()) {
            System.out.println(selected.getText());
        }

        // Deselect all
        toolsSelect.deselectAll();
        Thread.sleep(2000);

        driver.quit();
    }
}
