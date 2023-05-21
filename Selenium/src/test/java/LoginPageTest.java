import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginPageTest {
    WebDriver driver;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().setPosition(new Point(0,0));
        driver.manage().window().setSize(new Dimension(1600,900));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    @Test
    public void loginTest() {
        // ARRANGE
        String email = "bunkovik@cvut.cz";
        String password = "12345Qwe!!!";
        String expectedUrl = "https://link.springer.com/";

        // ACT
        LoginPage signupLoginPage = new LoginPage(driver, "https://link.springer.com/signup-login?previousUrl=https%3A%2F%2Flink.springer.com%2F");
        signupLoginPage.setLoginEmail(email);
        signupLoginPage.setLoginPassword(password);
        signupLoginPage.sendLoginForm();

        // ASSERT
        assertEquals(expectedUrl, driver.getCurrentUrl());
    }
}