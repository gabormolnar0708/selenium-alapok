package com.herokuapp.theinternet;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DropdownTest {

    WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    void selectValueByVisibleText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
        driver.get("https://the-internet.herokuapp.com");
        //navigateToTheDropDownPage
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Dropdown")));
        WebElement dropdownLink = driver.findElement(By.partialLinkText("Dropdown"));
        dropdownLink.click();
        //select
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dropdown")));
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Option 2");

        assertEquals("Option 2", select.getFirstSelectedOption().getText());
    }
    @Test
    void selectValueByIndex() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
        driver.get("https://the-internet.herokuapp.com");
        //navigateToTheDropDownPage
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Dropdown")));
        WebElement dropdownLink = driver.findElement(By.partialLinkText("Dropdown"));
        dropdownLink.click();
        //select
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dropdown")));
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);
        select.selectByIndex(1);

        assertEquals("Option 1", select.getFirstSelectedOption().getText());
    }

    @Test
    void selectValueByValue() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
        driver.get("https://the-internet.herokuapp.com");
        //navigateToTheDropDownPage
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Dropdown")));
        WebElement dropdownLink = driver.findElement(By.partialLinkText("Dropdown"));
        dropdownLink.click();
        //select
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dropdown")));
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);
        select.selectByValue("1");

        assertEquals("Option 1", select.getFirstSelectedOption().getText());
    }
}
