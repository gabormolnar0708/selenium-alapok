package com.herokuapp.formy;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExampleOfFluentWait {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://formy-project.herokuapp.com/");
        WebElement keyAndMouseLink = driver.findElement(By.partialLinkText("Key and Mouse Press"));
        keyAndMouseLink.click();

        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofMillis(10000))
                .pollingEvery(Duration.ofMillis(2000))
                .ignoring(ElementNotInteractableException.class)
                .ignoring(NoSuchElementException.class);

        FluentWait<WebDriver> fluent = new FluentWait<>(driver);
        fluent.withTimeout(Duration.ofMillis(1000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
        WebElement fullNameField = driver.findElement(By.id("name"));
        fullNameField.sendKeys("Test Fullname");
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
        //wait.until(ExpectedConditions.elementToBeClickable(By.id("button")));
        WebElement submitButton = driver.findElement(By.id("button"));
        submitButton.click();
        driver.quit();
    }
}
