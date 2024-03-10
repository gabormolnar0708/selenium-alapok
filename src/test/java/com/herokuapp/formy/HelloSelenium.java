package com.herokuapp.formy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.Thread.sleep;

public class HelloSelenium {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://formy-project.herokuapp.com/");
        WebElement keyAndMouseLink = driver.findElement(By.partialLinkText("Key and Mouse Press"));
        keyAndMouseLink.click();
        sleep(2000);
        WebElement fullNameField = driver.findElement(By.id("name"));
        fullNameField.sendKeys("Test FullName");
        WebElement submitButton = driver.findElement(By.id("button"));
        submitButton.click();
        driver.quit();

    }
}
