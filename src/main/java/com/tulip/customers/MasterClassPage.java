package com.tulip.customers;

import com.tulip.home.HomePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class MasterClassPage extends HomePage {

    @FindBy(css = "div > article > div > h3 > a")
    protected List<WebElement> postHeaderContainer;

    @FindBy(css = "input[name='Email']")
    protected List<WebElement> emailAddressInputFieldContainer;

    public MasterClassPage(WebDriver driver) {
        super(driver);
    }

    @Step("Get Post Availability")
    public boolean getPostAvailable(String postHeaderValue) {

        for (int i = 0 ; i < postHeaderContainer.size() ; i++) {
            if(postHeaderContainer.get(i).getText().equals(postHeaderValue)) {
                postHeaderContainer.get(i).click();
                isTheElementDisplayed(getEmailAddressInputFieldElement());
                javascriptExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});",
                        getEmailAddressInputFieldElement());
                return true;
            }
        }
        return false;
    }

    private WebElement getEmailAddressInputFieldElement(){
        return emailAddressInputFieldContainer.get(1);
    }
}
