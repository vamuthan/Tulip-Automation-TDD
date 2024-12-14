package com.tulip.customers;

import com.tulip.home.HomePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class CaseStudiesPage extends HomePage {

    @FindBy(css = "div > article > div > h3 > a")
    protected List<WebElement> caseStudyHeadingContainer;

    @FindBy(css = "input[id='Email']")
    protected WebElement emailAddressInputField;

    public CaseStudiesPage(WebDriver driver) {
        super(driver);
    }

    @Step("Get post Availability")
    public boolean getPostAvailable(String postHeadingValue){
        for(int i = 0 ; i < caseStudyHeadingContainer.size() ; i++) {
            if(caseStudyHeadingContainer.get(i).getText().equals(postHeadingValue)) {
                caseStudyHeadingContainer.get(i).click();
                javascriptExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'})",
                        emailAddressInputField);
                return emailAddressInputField.isDisplayed();
            }
        }
        return false;
    }
}
