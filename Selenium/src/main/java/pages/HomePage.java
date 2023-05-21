package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {
    private final WebDriver driver;

    @FindBy(className = "register-link")
    private WebElement registerLink;


    public HomePage(WebDriver driver, String queryString) {
        this.driver = driver;
        driver.get(queryString);

        PageFactory.initElements(driver, this);

        // Cookies button
        try {
            driver.findElement(By.cssSelector("button[data-cc-action='accept']")).click();
        } catch (NoSuchElementException e) {}
    }

    public void clickRegisterLink() {
        registerLink.click();
    }

    public void clickAdvancedSearchLink() {
        driver.findElement(By.className("open-search-options")).click();
        driver.findElement(By.id("advanced-search-link")).click();
    }
}
