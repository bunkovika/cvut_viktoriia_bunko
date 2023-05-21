import io.github.bonigarcia.wdm.WebDriverManager;
import pages.SearchPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchPageTest {
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
    public void setTypeArticleTest() {
        // ARRANGE
        String expectedValue = "within Article";

        // ACT
        SearchPage searchPage = new SearchPage(driver, "https://link.springer.com/search/page/1?date-facet-mode=in&facet-start-year=2023&showAll=true&query=Page+AND+Object+AND+Model+AND+%28Sellenium+OR+Testing%29");
        searchPage.setContentType("Article");

        // ASSERT
        assertEquals(expectedValue, driver.findElement(By.cssSelector(".facet-constraint-message")).getText());
    }

    @Test
    public void setPageTest() {
        // ARRANGE
        String expectedValue = "60";

        // ACT
        SearchPage searchPage = new SearchPage(driver, "https://link.springer.com/search/page/1?date-facet-mode=in&facet-start-year=2023&showAll=true&query=Page+AND+Object+AND+Model+AND+%28Sellenium+OR+Testing%29");
        searchPage.setPage(60);

        // ASSERT
        assertEquals(expectedValue, driver.findElement(By.cssSelector("input[name='go-to-page']")).getAttribute("value"));
    }

    @Test
    public void getResultsLinksTest() {
        // ACT
        SearchPage searchPage = new SearchPage(driver, "https://link.springer.com/search/page/1?date-facet-mode=in&facet-start-year=2023&showAll=true&query=Page+AND+Object+AND+Model+AND+%28Sellenium+OR+Testing%29");

        // ASSERT
        assertEquals(4, searchPage.getResultsLinks(4).size());
    }
}