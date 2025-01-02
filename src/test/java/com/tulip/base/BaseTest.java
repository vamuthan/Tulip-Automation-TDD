package com.tulip.base;

import io.qameta.allure.Step;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;


public class BaseTest {
    protected static RemoteWebDriver driver;
    protected static ChromeOptions chromeOptions;
    protected static String executionMode;
    protected static String browserType;
    protected static final String LT_USERNAME = System.getProperty("lt_username");
    protected static final String LT_ACCESS_KEY = System.getProperty("lt_access_key");
    protected static final String GRID_URL = "@hub.lambdatest.com/wd/hub";

    @Step("Setting up the test")
    @BeforeTest(alwaysRun = true)
    public void setup() {
        executionMode = System.getProperty("executionMode", "local");
        browserType = System.getProperty("browserType", "chrome");
        if(executionMode.equalsIgnoreCase("lambdatest")){
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("browserName", "edge");
            capabilities.setCapability("browserVersion", "131.0");
            capabilities.setCapability("platformName", "Windows 11");
            try {
                driver = new RemoteWebDriver(new URL("https://" + LT_USERNAME + ":" + LT_ACCESS_KEY + GRID_URL),
                        capabilities);
            } catch (MalformedURLException e) {
                System.out.println("Invalid grid URL");
            } catch (Exception e) {
                System.out.println("Failed to initialize RemoteWebDriver: " + e.getMessage());
            }
        }
        else{
            switch (browserType) {
                case "chrome":
                    chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--start-maximized");
                    driver = new ChromeDriver(chromeOptions);
                    break;

                case "firefox":
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    break;

                case "edge":
                    driver = new EdgeDriver();
                    driver.manage().window().maximize();
                    break;

                default:
                    throw new IllegalArgumentException("Unsupported browser type: " + browserType);
            }
        }
        driver.get("https://www.tulip.com/");
    }

    @Step("Performing the pre-condition for the test method")
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
