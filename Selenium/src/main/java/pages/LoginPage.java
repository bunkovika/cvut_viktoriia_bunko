package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage {
    private final WebDriver driver;
    // Login
    @FindBy(id = "login-box-email")
    private WebElement loginEmailField;

    @FindBy(id = "login-box-pw")
    private WebElement loginPasswordField;

    private WebElement loginFormSubmitButton;

    // Registration
    @FindBy(id = "first-name")
    private WebElement signupFirstNameField;

    @FindBy(id = "last-name")
    private WebElement signupLastNameField;

    @FindBy(id = "email-address")
    private WebElement signupEmailField;

    @FindBy(id = "password")
    private WebElement signupPasswordField;

    @FindBy(id = "password-confirm")
    private WebElement signupPasswordConfirmField;

    private WebElement signupFormSubmitButton;

    public LoginPage(WebDriver driver) {
//        creation of page
        this.driver = driver;
        PageFactory.initElements(driver, this);
//        Cookies and Popup button
        closeCookies();
        closePopupWindow();
//        creation buttons
        creationLoginSignUpButtons();
    }
    public LoginPage(WebDriver driver, String link) {
        this.driver = driver;
        driver.get(link);
        PageFactory.initElements(driver, this);
        //buttons
        closeCookies();
        creationLoginSignUpButtons();
    }
    public void closePopupWindow() {
        try {
            WebElement window = driver.findElement(By.className("QSIWebResponsive"));
            List<WebElement> buttons = window.findElements(By.cssSelector("button"));

            for (WebElement button : buttons) {
                if (button.getText().equals("No Thanks")) {
                    button.click();
                    break;
                }
            }

        } catch (NoSuchElementException e) {}
    }

    public void setLoginEmail(String email) {
        this.loginEmailField.sendKeys(email);
    }

    public void setLoginPassword(String password) {
        this.loginPasswordField.sendKeys(password);
    }

    public void sendLoginForm() {
        loginFormSubmitButton.click();
    }

    private void closeCookies() {
        try {
            driver.findElement(By.cssSelector("button[data-cc-action='accept']")).click();
        } catch (NoSuchElementException e) {}
    }
    private void creationLoginSignUpButtons(){
        loginFormSubmitButton = driver.findElement(By.cssSelector(".btn[title='Log in']"));
        signupFormSubmitButton = driver.findElement(By.cssSelector(".btn[title='Create account']"));
    }
}
