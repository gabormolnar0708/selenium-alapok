package junit5.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginTests {
    WebDriver driver;
    String baseUrl = "https://the-internet.herokuapp.com/";
    By formAuthenticationLinkLoc = By.partialLinkText("Form Authentication");
    By usernameInputLoc = By.id("username");
    By passwordInputLoc = By.id("password");
    By loginButtonLoc = By.xpath("//button[@type='submit']");
    By flashMessageLoc = By.id("flash");

    @BeforeEach
    void beginWebTest(){
        this.driver = new ChromeDriver();
    }

    @AfterEach
    void endWebTest() {
        this.driver.quit();
    }

    @Test
    void userCanLoginWithValidCredentials() {
        openLandingPage();
        navigateToFormAuthentication();
        fillUsername("tomsmith");
        fillPassword("SuperSecretPassword!");
        submitCredentials();

        String message = getText(flashMessageLoc);
        Assertions.assertTrue(message.contains("You logged into a secure area!"));

    }

    void openLandingPage(){
        driver.get(baseUrl);
    }

    void navigateToFormAuthentication() {
        click(formAuthenticationLinkLoc);
    }

    void fillUsername(String username) {
        inputText(usernameInputLoc, username);
    }

    void fillPassword(String password) {
        inputText(passwordInputLoc, password);
    }

    void submitCredentials(){
        click(loginButtonLoc);
    }

    String getText(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        WebElement element = driver.findElement(locator);
        return element.getText();
    }


    void click(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        WebElement element = driver.findElement(locator);
        element.click();
    }

    void inputText(By locator, String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        WebElement element = driver.findElement(locator);
        element.sendKeys(text);
    }

}
