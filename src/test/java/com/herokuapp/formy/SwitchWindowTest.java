package com.herokuapp.formy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SwitchWindowTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
        driver.get("https://formy-project.herokuapp.com/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Switch Window")));
        WebElement switchWindowLink = driver.findElement(By.partialLinkText("Switch Window"));
        switchWindowLink.click();
        String originalWindow = driver.getWindowHandle();
        assert driver.getWindowHandles().size() == 1;
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("new-tab-button")));
        WebElement newTabButton = driver.findElement(By.id("new-tab-button"));
        newTabButton.click();
        assert driver.getWindowHandles().size() == 2;
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        for (String windowHandle: driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
            }
        }




    }

}
