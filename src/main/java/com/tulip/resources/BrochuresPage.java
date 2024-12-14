package com.tulip.resources;

import com.tulip.home.HomePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class BrochuresPage extends HomePage {

    @FindBy(css = "a[class='page-numbers next']")
    protected WebElement nextPageButton;

    @FindBy(css = "a[class='page-numbers prev']")
    protected WebElement previousPageButton;

    @FindBy(css = "h3 > a[href]")
    protected List<WebElement> pageOneBrochureTitleContainer;

    @FindBy(css = "h3 > a[href]")
    protected List<WebElement> pageTwoBrochureTitleContainer;

    public BrochuresPage(WebDriver driver) {
        super(driver);
    }

    @Step("Navigate to Next page")
    public void navigateToNextPage(){
        waitForElementToBeClickable(nextPageButton);
        javascriptExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'})", nextPageButton);
        nextPageButton.click();
    }

    @Step("Navigate to Previous page")
    public void navigateToPreviousPage(){
        waitForElementToBeClickable(previousPageButton);
        javascriptExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'})", previousPageButton);
        previousPageButton.click();
    }

    @Step("Get the Brochure URL")
    public String getBrochureURL(String brochureTitle) {
        for(WebElement currentElement : pageOneBrochureTitleContainer) {
            if(validateTextFromTheWebElement(currentElement, brochureTitle)) {
                javascriptExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'})",
                        currentElement);
                String windowHandleBeforeClick = driver.getWindowHandle();
                currentElement.click();
                changeWindowTabs(windowHandleBeforeClick);
                stopExecution(2);
                return getCurrentPageURL();
            }
        }
        navigateToNextPage();
        for (WebElement currentElement : pageTwoBrochureTitleContainer) {
            if(validateTextFromTheWebElement(currentElement, brochureTitle)) {
                javascriptExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'})",
                        currentElement);
                currentElement.click();
                stopExecution(2);
                return getCurrentPageURL();
            }
        }
        return null;
    }

    @Step("Get the Brochure name")
    public String getTheBrochureName(String brochureTitle){
        for(WebElement currentElement : pageOneBrochureTitleContainer) {
            if (validateTextFromTheWebElement(currentElement, brochureTitle)) {
                javascriptExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'})",
                        currentElement);
                return currentElement.getText();
            }
        }
        navigateToNextPage();
        for (WebElement currentElement : pageTwoBrochureTitleContainer) {
            if (validateTextFromTheWebElement(currentElement, brochureTitle)) {
                javascriptExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'})",
                        currentElement);
                return currentElement.getText();
            }
        }
        navigateToPreviousPage();
        return null;
    }
}
