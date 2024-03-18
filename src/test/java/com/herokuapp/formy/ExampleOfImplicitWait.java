package com.herokuapp.formy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static java.lang.Thread.sleep;

public class ExampleOfImplicitWait {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        driver.get("https://formy-project.herokuapp.com/");
        WebElement keyAndMouseLink = driver.findElement(By.partialLinkText("Key and Mouse Press"));
        keyAndMouseLink.click();
        WebElement fullNameField = driver.findElement(By.id("name"));
        fullNameField.sendKeys("Test FullName");
        WebElement submitButton = driver.findElement(By.id("button"));
        submitButton.click();
        driver.quit();
    }
}
