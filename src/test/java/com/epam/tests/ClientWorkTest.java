import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;
import org.junit.Test;

public class ClientWorkTest {

    @Test
    public void testClientWorkPage() {
        // Set up the WebDriver
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();

        try {
            // Step 1: Navigate to EPAM website
            driver.get("https://www.epam.com/");

            // Step 2: Click on Services
            WebElement servicesMenu = driver.findElement(By.linkText("Services"));
            servicesMenu.click();

            // Step 3: Click on Explore Our Client Work
            WebElement clientWorkLink = driver.findElement(By.linkText("Learn More"));
            clientWorkLink.click();

            // Step 4: Verify Client Work text is visible
            String pageSource = driver.getPageSource();
            Assert.assertTrue(pageSource.contains("Client Work"));

        } finally {
            // Close the browser
            driver.quit();
        }
    }
}