package com.herokuapp.formy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExampleOfExplicitWait {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://formy-project.herokuapp.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Key and Mouse Press")));
        WebElement keyAndMouseLink = driver.findElement(By.partialLinkText("Key and Mouse Press"));
        keyAndMouseLink.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
        WebElement fullNameField = driver.findElement(By.id("name"));
        fullNameField.sendKeys("Test FullName");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("button")));
        WebElement submitButton = driver.findElement(By.id("button"));
        submitButton.click();
        driver.quit();
    }
}
