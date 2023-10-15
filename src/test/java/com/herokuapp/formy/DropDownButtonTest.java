package com.herokuapp.formy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DropDownButtonTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(5000));
        driver.get("https://formy-project.herokuapp.com/");
        //navigateToTheDropDownPage
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Dropdown")));
        WebElement keyAndMouseLink = driver.findElement(By.partialLinkText("Dropdown"));
        keyAndMouseLink.click();
        //select
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dropdownMenuButton")));
        WebElement dropdownButton = driver.findElement(By.id("dropdownMenuButton"));
        dropdownButton.click();
        By autocompleteOptionLocator = By.id("autocomplete");
        wait.until(ExpectedConditions.visibilityOfElementLocated(autocompleteOptionLocator));
        WebElement autocompleteOption = driver.findElement(autocompleteOptionLocator);
        autocompleteOption.click();

    }
}
