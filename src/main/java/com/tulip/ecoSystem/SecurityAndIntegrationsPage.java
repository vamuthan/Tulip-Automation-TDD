package com.tulip.ecoSystem;

import com.tulip.home.HomePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

public class SecurityAndIntegrationsPage extends HomePage {

    @FindBy(css = "div[data-elementor-type='wp-page'] > section:nth-child(2) > div > div:nth-child(1) > div > " +
            "div:nth-child(4) > div > ul > li")
    protected List<WebElement> integrationsContentContainer;

    @FindBy(css = "div[data-elementor-type='wp-page'] > section:nth-child(3) > div > div:nth-child(2) > div > " +
            "div:nth-child(2) > div > h2")
    protected WebElement extensibilityHeadingContent;

    @FindBy(css = "div[data-elementor-type='wp-page'] > section:nth-child(4) > div > div:nth-child(1) > div > " +
            "div:nth-child(2) > div > h2")
    protected WebElement securityHeadingContent;

    public SecurityAndIntegrationsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Get Integrations features")
    public String[] getIntegrationsFeatures() {
        String[] resultIntegrationContentContainer = new String[integrationsContentContainer.size()];
        for (int i = 0 ; i < integrationsContentContainer.size() ; i++) {
            resultIntegrationContentContainer[i] = integrationsContentContainer.get(i).getText();
        }
        return resultIntegrationContentContainer;
    }

    @Step("Get Extensibility section header")
    public String  getExtensibilitySectionHeader(){
        return extensibilityHeadingContent.getText();
    }

    @Step("Get Security section header")
    public String getSecuritySectionHeader() {
        return securityHeadingContent.getText();
    }
}
