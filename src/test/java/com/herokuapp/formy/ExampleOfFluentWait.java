package com.herokuapp.formy;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class ExampleOfFluentWait {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://formy-project.herokuapp.com/");
        WebElement keyAndMouseLink = driver.findElement(By.partialLinkText("Key and Mouse Press"));
        keyAndMouseLink.click();
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .pollingEvery(Duration.ofMillis(100))
                .withTimeout(Duration.ofMillis(10000))
                .ignoring(ElementNotInteractableException.class)
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
        WebElement fullNameField = driver.findElement(By.id("name"));
        fullNameField.sendKeys("Test FullName");
        WebElement submitButton = driver.findElement(By.id("button"));
        submitButton.click();
        driver.quit();
    }
}
