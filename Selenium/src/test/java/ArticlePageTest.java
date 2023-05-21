import io.github.bonigarcia.wdm.WebDriverManager;
import pages.ArticlePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArticlePageTest {
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
    public void getNameTest() {
        // ASSERT
        String expectedName = "Comparative analysis of the syntactic and semantic consistency of terms in software testing glossaries";

        // ACT
        ArticlePage articlePage = new ArticlePage(driver, "https://link.springer.com/article/10.1007/s11219-023-09638-0");

        // ASSERT
        assertEquals(expectedName, articlePage.getName());
    }

    @Test
    public void getDateTest() {
        // ASSERT
        String expectedDate = "16 May 2023";

        // ACT
        ArticlePage articlePage = new ArticlePage(driver, "https://link.springer.com/article/10.1007/s11219-023-09638-0");

        // ASSERT
        assertEquals(expectedDate, articlePage.getDate());
    }

    @Test
    public void getDOITest() {
        // ASSERT
        String expectedDOI = "https://doi.org/10.1007/s11219-023-09638-0";

        // ACT
        ArticlePage articlePage = new ArticlePage(driver, "https://link.springer.com/article/10.1007/s11219-023-09638-0");

        // ASSERT
        assertEquals(expectedDOI, articlePage.getDOI());
    }
}