package com.tulip.ecoSystem;

import com.tulip.home.HomePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PartnersPage extends HomePage {

    @FindBy(css = "img[src*='Apple']")
    protected WebElement strategicAllianceApple;

    @FindBy(css = "img[src*='SalesforceVentures']")
    protected WebElement strategicAllianceSalesForceVentures;

    @FindBy(css = "img[src*='Stripe']")
    protected WebElement strategicAllianceStripe;

    @FindBy(css = "div[style*='Adyen']")
    protected WebElement technologyPartnerAdyen;

    @FindBy(css = "div[style*='Avalara']")
    protected WebElement technologyPartnerAvalara;

    @FindBy(css = "div[style*='Shopify']")
    protected WebElement technologyPartnerShopify;

    @FindBy(css = "div[style*='Vertex']")
    protected WebElement technologyPartnerVertex;

    @FindBy(css = "div[style*='Jamf']")
    protected WebElement technologyPartnerJamf;

    @FindBy(css = "div[style*='GoogleCloud']")
    protected WebElement technologyPartnerGoogleCloud;

    @FindBy(css = "div[style*='Cisco']")
    protected WebElement technologyPartnerCisco;

    @FindBy(css = "div[style*='SAP']")
    protected WebElement technologyPartnerSap;

    @FindBy(css = "div[style*='Zendesk']")
    protected WebElement technologyPartnerZendesk;

    @FindBy(css = "img[src*='Deloitte']")
    protected WebElement systemIntegratorsAndConsultantsDeloitte;

    @FindBy(css = "img[src*='Demand']")
    protected WebElement systemIntegratorsAndConsultantsDemand;

    @FindBy(css = "img[src*='Accenture']")
    protected WebElement systemIntegratorsAndConsultantsAccenture;

    @FindBy(css = "img[src*='Onestep']")
    protected WebElement systemIntegratorsAndConsultantsOnestep;

    @FindBy(css = "img[src*='MODO']")
    protected WebElement systemIntegratorsAndConsultantsMODO;

    public PartnersPage(WebDriver driver) {
        super(driver);
    }

    @Step("Read Strategic partner data")
    public boolean readStrategicPartnersData(){
        javascriptExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'})",
                strategicAllianceApple);
        return isTheElementDisplayed(strategicAllianceApple) && isTheElementDisplayed(strategicAllianceSalesForceVentures)
                && isTheElementDisplayed(strategicAllianceStripe);
    }

    @Step("Read Technology partner data")
    public boolean readTechnologyPartnersData(){
        waitForVisibility(technologyPartnerAdyen);
        javascriptExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'})",
                technologyPartnerAdyen);
        return isTheElementDisplayed(technologyPartnerAdyen) && isTheElementDisplayed(technologyPartnerAvalara) &&
                isTheElementDisplayed(technologyPartnerShopify) && isTheElementDisplayed(technologyPartnerVertex) &&
                isTheElementDisplayed(technologyPartnerJamf) && isTheElementDisplayed(technologyPartnerGoogleCloud) &&
                isTheElementDisplayed(technologyPartnerCisco) && isTheElementDisplayed(technologyPartnerSap) &&
                isTheElementDisplayed(technologyPartnerZendesk);
    }

    @Step("Read System Integrators data")
    public boolean readSystemIntegratorsAndConsultantsData() {
        javascriptExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'})",
                systemIntegratorsAndConsultantsAccenture);
        return isTheElementDisplayed(systemIntegratorsAndConsultantsDeloitte) &&
                isTheElementDisplayed(systemIntegratorsAndConsultantsDemand) &&
                isTheElementDisplayed(systemIntegratorsAndConsultantsAccenture) &&
                isTheElementDisplayed(systemIntegratorsAndConsultantsOnestep) &&
                isTheElementDisplayed(systemIntegratorsAndConsultantsMODO);
    }


}
