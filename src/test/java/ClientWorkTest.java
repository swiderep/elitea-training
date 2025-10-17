import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClientWorkTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void testClientWorkVisibility() {
        driver.get("https://www.epam.com/");
        driver.findElement(By.linkText("Services")).click();
        driver.findElement(By.linkText("Learn More")).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Client Work')]")));
        Assert.assertTrue(driver.getPageSource().contains("Client Work"));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}