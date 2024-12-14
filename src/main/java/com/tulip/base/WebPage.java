package com.tulip.base;

import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WebPage {
    protected WebDriver driver;
    protected WebDriverWait webDriverWait;
    protected JavascriptExecutor javascriptExecutor;
    protected Actions actions;

    public WebPage(WebDriver driver) {
        this.driver = driver;
        javascriptExecutor = (JavascriptExecutor) driver;
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
    }

    public void stopExecution(int seconds) {
        try{
            Thread.sleep(TimeUnit.SECONDS.toMillis(seconds));
        }
        catch (InterruptedException e) {
            System.out.println("An exception has occured");
        }
    }

    public void waitForVisibility(WebElement element){
        webDriverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementToBeClickable(WebElement element) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public boolean isTheElementDisplayed(WebElement element){
        return element.isDisplayed();
    }

    @Step("Change the window tabs")
    public boolean changeWindowTabs(String windowHandleBeforeClick) {
        Set<String> windowHandlesContainer = driver.getWindowHandles();
        for(String currentHandle : windowHandlesContainer) {
            if(!windowHandleBeforeClick.equals(currentHandle)) {
                driver.switchTo().window(currentHandle);
                return true;
            }
        }
        return false;
    }

    public void closeInactiveWindows() {
        String activeWindowHandle = driver.getWindowHandle();
        Set<String> windowHandleContainer = driver.getWindowHandles();
        for (String currentWindowHandle : windowHandleContainer) {
            if(!currentWindowHandle.equals(activeWindowHandle)) {
                driver.switchTo().window(currentWindowHandle);
                driver.close();
            }
        }
        driver.switchTo().window(activeWindowHandle);
    }

    public boolean validateTextFromTheWebElement(WebElement webElement, String textToValidate) {
        return webElement.getText().equals(textToValidate);
    }

    @Step("Get Current page URL")
    public String getCurrentPageURL() {
        return driver.getCurrentUrl();
    }
}
