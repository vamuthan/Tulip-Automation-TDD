package com.tulip.careers;

import com.tulip.home.HomePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.Set;

public class CareersPage extends HomePage {

    @FindBy(css = "main[id='content'] > div > div:nth-child(1) > section:nth-child(1) > div:nth-child(2) a")
    protected WebElement viewJobOpeningButton;

    public CareersPage(WebDriver driver) {
        super(driver);
    }

    @Step("Navigate to BambooHR page")
    public BambooHRCareerPage  navigateToBambooHRJobListingPage() {
        String originalWindowHandle = driver.getWindowHandle();
        waitForElementToBeClickable(viewJobOpeningButton);
        viewJobOpeningButton.click();
        stopExecution(6);
        Set<String> getAvailableWindowHandles = driver.getWindowHandles();
        for (String currentValue : getAvailableWindowHandles) {
            if(!currentValue.equals(originalWindowHandle)) {
                driver.switchTo().window(currentValue);
                break;
            }
        }
        return PageFactory.initElements(driver, BambooHRCareerPage.class);
    }
}
