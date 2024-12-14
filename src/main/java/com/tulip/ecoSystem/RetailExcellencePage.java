package com.tulip.ecoSystem;

import com.tulip.home.HomePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.ArrayList;
import java.util.List;

public class RetailExcellencePage extends HomePage {

    @FindBy(css = "div[class='page-content'] > div > section:nth-child(3) > div > div:nth-child(2) > div > div >" +
            " div > h2 > span")
    protected WebElement headingElement;

    @FindBy(css = "div[class='page-content'] > div > section:nth-child(3) > div > div:nth-child(2) > div > " +
            "section:nth-child(2) > div > div:nth-child(1) > div > div > div > div > div:nth-child(2) > h2 > span")
    protected WebElement subHeadingElementOne;

    @FindBy(css = "div[class='page-content'] > div > section:nth-child(3) > div > div:nth-child(2) > div > " +
            "section:nth-child(2) > div > div:nth-child(2) > div > div > div > div > div:nth-child(2) > h2 > span")
    protected WebElement subHeadingElementTwo;

    @FindBy(css = "div[class='page-content'] > div > section:nth-child(3) > div > div:nth-child(2) > div > " +
            "section:nth-child(3) > div > div:nth-child(1) > div > div > div > div > div:nth-child(2) > h2 > span")
    protected WebElement subHeadingElementThree;

    @FindBy(css = "div[class='page-content'] > div > section:nth-child(3) > div > div:nth-child(2) > div > " +
            "section:nth-child(3) > div > div:nth-child(2) > div > div > div > div > div:nth-child(2) > h2 > span")
    protected WebElement subHeadingElementFour;

    public RetailExcellencePage(WebDriver driver) {
        super(driver);
    }

    @Step("Get Header text")
    public String getHeaderText(){
        return headingElement.getText();
    }

    @Step("Get Subheading Element list")
    public List<String> getSubHeadingElementsList() {
        List<String> resultSubHeadingElementsText = new ArrayList<>();
        resultSubHeadingElementsText.add(subHeadingElementOne.getText());
        resultSubHeadingElementsText.add(subHeadingElementTwo.getText());
        resultSubHeadingElementsText.add(subHeadingElementThree.getText());
        resultSubHeadingElementsText.add(subHeadingElementFour.getText());
        return resultSubHeadingElementsText;
    }
}
