package com.tulip.customers;

import com.tulip.home.HomePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class CustomerStoriesPage extends HomePage {

    @FindBy(css = "div[class='nav-filter'] > form > div > div:nth-child(1)")
    protected WebElement allCustomerStoriesButton;

    @FindBy(css = "div[class='nav-filter'] > form > div > div:nth-child(2)")
    protected WebElement caseStudiesButton;

    @FindBy(css = "div[class='nav-filter'] > form > div > div:nth-child(3)")
    protected WebElement customerSuccessStoriesButton;

    @FindBy(css = "div[class='nav-filter'] > form > div > div:nth-child(4)")
    protected WebElement masterClassButton;

    @FindBy(css = "div[class='nav-filter'] > div > form > div:nth-child(1) > input")
    protected WebElement searchResourcesInputField;

    @FindBy(css = "div[class='grid-items'] > div > div > div > div:nth-child(2) > a")
    protected List<WebElement> postFilterTagContainer;

    @FindBy(css = "div[class='grid-items'] > div > div > div > div:nth-child(3) > a")
    protected List<WebElement> postHeadingContainer;

    public CustomerStoriesPage(WebDriver driver) {
        super(driver);
    }

    @Step("Performing the search operation")
    public boolean searchInFilter(String filterBy, String textValue) {
            switch (filterBy) {
                case "All Customer Stories":
                    allCustomerStoriesButton.click();
                    break;
                case "Case Studies":
                    caseStudiesButton.click();
                    break;
                case "Customer Success Stories":
                    customerSuccessStoriesButton.click();
                    break;
                case "Masterclasses":
                    masterClassButton.click();
                    break;
                default:
                    System.out.println("No filter by option found");
                    break;
            }
            waitForVisibility(searchResourcesInputField);
            javascriptExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'});",
                    searchResourcesInputField);
            searchResourcesInputField.sendKeys(textValue);
            return true;
    }

    @Step("Get the post availability")
    public boolean getPostAvailability(String filterName, String postContentName){
        for(int i = 0 ; i < postFilterTagContainer.size() ; i++) {
            if(postFilterTagContainer.get(i).getText().contains(filterName) &&
                postHeadingContainer.get(i).getText().contains(postContentName)) {
                return true;
            }
        }
        return false;
    }
}
