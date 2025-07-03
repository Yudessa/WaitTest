import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class WaitTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        FirefoxOptions options = new FirefoxOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);

        driver = new FirefoxDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    @DisplayName("Ожидание_видимости")

    public void visible() {
        driver.get("https://demoqa.com/dynamic-properties");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
        WebElement visibleButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#visibleAfter")));
        assertTrue(visibleButton.isDisplayed(), "Кнопка не видна");
    }
}
