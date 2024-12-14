package com.tulip.careers;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class BambooHRCareerPage extends CareersPage {

    @FindBy(css = "ul > div")
    protected List<WebElement> currentOpeningContainer;

    @FindBy(css = "h3")
    protected WebElement headingElement;

    public BambooHRCareerPage(WebDriver driver) {
        super(driver);
    }

    public int getAvailableJobCount() {
        try {
            return currentOpeningContainer.size();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    @Step("Get Table heading")
    public String getTableHeading() {
        return headingElement.getText();
    }
}
