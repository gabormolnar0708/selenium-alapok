package com.herokuapp.formy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static java.lang.Thread.sleep;

public class ScrollToElement {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://formy-project.herokuapp.com/");
        WebElement scrollLink = driver.findElement(By.partialLinkText("Page Scroll"));
        scrollLink.click();
        sleep(1000);
        WebElement fullName = driver.findElement(By.id("name"));
        fullName.sendKeys("Teszt User");

    }
}
