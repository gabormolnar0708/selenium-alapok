package com.herokuapp.formy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckboxTest {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
        driver.get("https://formy-project.herokuapp.com/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Checkbox")));
        WebElement keyAndMouseLink = driver.findElement(By.partialLinkText("Checkbox"));
        keyAndMouseLink.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkbox-1")));
        WebElement checkbox1 = driver.findElement(By.id("checkbox-1"));
        System.out.println(checkbox1.isSelected());
        assert !checkbox1.isSelected();
        checkbox1.click();
        assert checkbox1.isSelected();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        driver.quit();

    }

}
