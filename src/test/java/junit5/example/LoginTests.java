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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTests {
    WebDriver driver;
    String baseUrl = "https://the-internet.herokuapp.com/";
    By formAuthenticationLinkLoc = By.partialLinkText("Form Authentication");
    By usernameInputLoc = By.id("username");
    By headerLoc = By.xpath("//h2");
    By passwordInputLoc = By.id("password");

    @BeforeEach
    void beginWebTest() {
        this.driver = new ChromeDriver();
    }

    @AfterEach
    void endWebTest() {
        this.driver.quit();
    }


    @Test
    void userCanLoginWithValidCredentials() {
        driver.get(baseUrl);
        navigateToAuthenticationForm();

        WebElement header = driver.findElement(headerLoc);
        System.out.println(header.getText());
        fillUserName("tomsmith");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("SuperSecretPassword!");
        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
        submitButton.click();

        WebElement flash = driver.findElement(By.id("flash"));
        assertTrue(flash.getText().contains("You logged into a secure area!"));
    }

    @Test
    void userCanNotLoginWithInvalidPassword() {
        driver.get(baseUrl);
        WebElement formAuthenticationLink = driver.findElement(By.partialLinkText("Form Authentication"));
        formAuthenticationLink.click();
        WebElement header = driver.findElement(By.xpath("//h2"));
        System.out.println(header.getText());
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("tomsmith");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Not Password");
        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
        submitButton.click();

        WebElement flash = driver.findElement(By.id("flash"));
        assertTrue(flash.getText().contains("Your password is invalid!"), "Expected message: Your password is invalid!, but we got: " +
                "" + flash.getText() );
    }

    void navigateToAuthenticationForm() {
        click(formAuthenticationLinkLoc);
    }
    void fillUserName(String username) {
        inputText(usernameInputLoc, username);
    }

    void inputText(By locator, String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        WebElement element = driver.findElement(locator);
        element.sendKeys(text);
    }

    void click(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        WebElement element = driver.findElement(locator);
        element.click();
    }
}
