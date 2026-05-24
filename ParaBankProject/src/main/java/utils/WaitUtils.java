//package utils;
//
//import java.time.Duration;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//public class WaitUtils {
//
//    private WebDriver driver;
//    private WebDriverWait wait;
//    private final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(10);
//
//    public WaitUtils(WebDriver driver) {
//        this.driver = driver;
//        this.wait = new WebDriverWait(this.driver, DEFAULT_TIMEOUT);
//    }
//
//   
//    public WebElement waitForVisibility(WebElement element) {
//        return wait.until(ExpectedConditions.visibilityOf(element));
//    }
//
//    
//    public WebElement waitForElementToBeClickable(WebElement element) {
//        return wait.until(ExpectedConditions.elementToBeClickable(element));
//    }
//}
//   
package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {

    private WebDriver driver;
    private WebDriverWait wait;

    public WaitUtils(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // Wait using WebElement
    public WebElement waitForVisibility(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    // Wait using By locator
    public WebElement waitForVisibility(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public WebElement waitForClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public boolean waitForTitleContains(String title) {
        return wait.until(ExpectedConditions.titleContains(title));
    }
}
