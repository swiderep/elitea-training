import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ClientWorkTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void testClientWorkVisibility() {
        // Step 1: Navigate to EPAM website
        driver.get("https://www.epam.com/");

        // Step 2: Select Services from the header menu
        driver.findElement(By.linkText("Services")).click();

        // Step 3: Click the Explore Our Client Work link
        driver.findElement(By.linkText("Explore Our Client Work")).click();

        // Step 4: Verify that the Client Work text is visible on the page
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Client Work')]")));
        Assert.assertTrue(driver.getPageSource().contains("Client Work"), "Client Work text is not visible!");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}