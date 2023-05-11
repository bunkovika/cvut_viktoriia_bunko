
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class PageRobot{
    private WebDriver driver = new ChromeDriver();
    private JavascriptExecutor js = (JavascriptExecutor) driver;
    public PageRobot() {
        this.driver.get("https://moodle.fel.cvut.cz");

        PageFactory.initElements(driver, this);

        driver.findElement(By.partialLinkText("Log in")).click();
        driver.findElement(By.className("btn")).click();
        driver.findElement(By.id("username")).sendKeys("");
        driver.findElement(By.id("password")).sendKeys("");
        driver.findElement(By.className("btn")).click();

        driver.findElement(By.partialLinkText("Software Testing")).click();
        driver.findElement(By.partialLinkText("Cvičení")).click();
        driver.findElement(By.cssSelector("a.sectiontoggle[href='#collapse-4']")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        driver.findElement(By.cssSelector("a.aalink[href='https://moodle.fel.cvut.cz/mod/quiz/view.php?id=265999']")).click();
        driver.findElement(By.className("btn-primary")).click();
        driver.findElement(By.name("submitbutton")).click();
        //Quiz
        //First question
        driver.findElement(By.cssSelector("textarea")).sendKeys("Bunko Viktoriia 106 paralelka 11 cvičení");
        //Second question
        driver.findElement(By.cssSelector("input[type = 'text']")).sendKeys("86400");
        //Third question
        Select dropdown = new Select(driver.findElement(By.cssSelector("select")));
        dropdown.selectByVisibleText("Oberon");
        //Fourth question
        Select dropdown2 = new Select(driver.findElement(By.cssSelector("select[id$='4_p1']")));
        dropdown2.selectByVisibleText("Rumunsko");

        //Finish attempt
        driver.findElement(By.name("next")).click();

        //Go back to attempts
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //open profile dropdown
        driver.findElement(By.id("action-menu-toggle-1")).click();

        //Log out
        driver.findElement(By.cssSelector("a.dropdown-item.menu-action[href='https://moodle.fel.cvut.cz/login/logout.php']")).click();

        //Log out confirmation
        driver.findElement(By.className("btn-primary")).click();
    }
}