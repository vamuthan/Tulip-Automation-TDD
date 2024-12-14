package com.tulip.base;

import io.qameta.allure.Step;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected static RemoteWebDriver driver;
    protected static ChromeOptions chromeOptions;

    @Step("Setting up the test")
    @BeforeTest(alwaysRun = true)
    public void setup() {
        chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.tulip.com/");
    }

    @Step("Performing the pre-condition for the test mehtod")
    @AfterMethod(alwaysRun = true)
    public void testMethodSetup(){
        closeInactiveWindows();
        driver.get("https://www.tulip.com");
    }

    @Step("Clearing up the test")
    @AfterTest(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }

    public void stopExecution(int seconds) {
        try{
            Thread.sleep(TimeUnit.SECONDS.toMillis(seconds));
        }
        catch (InterruptedException e) {
            System.out.println("An exception has been thrown");
        }
    }

    /***
     * this method closes all the unwanted tabs and does not close the wanted tab.
     */
    @Step("Closing the inactive windows")
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
}
