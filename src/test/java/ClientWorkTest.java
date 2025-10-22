import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ClientWorkTest {
    public static void main(String[] args) {
        // Set the path for the ChromeDriver
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Step 1: Navigate to EPAM website
            driver.get("https://www.epam.com/");

            // Step 2: Select 'Services' from the header menu
            driver.findElement(By.linkText("Services")).click();

            // Step 3: Click the 'Explore Our Client Work' link
            driver.findElement(By.linkText("Learn More")).click();

            // Step 4: Verify that the 'Client Work' text is visible on the page
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(), 'Client Work')]")));

            System.out.println("Test Passed: 'Client Work' text is visible.");
        } catch (Exception e) {
            System.out.println("Test Failed: " + e.getMessage());
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}