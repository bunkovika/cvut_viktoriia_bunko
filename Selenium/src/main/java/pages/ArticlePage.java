package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ArticlePage {
    WebDriver driver;

    @FindBy(className = "c-article-title")
    private WebElement name;

    @FindBy(css = ".c-article-header time")
    private WebElement date;

    @FindBy(css = ".c-bibliographic-information__list-item--doi .c-bibliographic-information__value")
    private WebElement doi;

    public ArticlePage(WebDriver driver, String queryString) {
        this.driver = driver;
        driver.get(queryString);

        PageFactory.initElements(driver, this);

        // Cookies button
        try {
            driver.findElement(By.cssSelector("button[data-cc-action='accept']")).click();
        } catch (NoSuchElementException e) {}
    }

    public String getName() {
        return name.getText();
    }

    public String getDate() {
        return date.getText();
    }

    public String getDOI() {
        return doi.getText();
    }

}