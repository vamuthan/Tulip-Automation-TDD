package com.tulip.home;

import com.tulip.careers.CareersPage;
import com.tulip.customers.CaseStudiesPage;
import com.tulip.customers.CustomerStoriesPage;
import com.tulip.customers.MasterClassPage;
import com.tulip.ecoSystem.PartnersPage;
import com.tulip.ecoSystem.RetailExcellencePage;
import com.tulip.ecoSystem.SecurityAndIntegrationsPage;
import com.tulip.resources.*;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.tulip.base.WebPage;
import java.util.List;

public class HomePage extends WebPage {

    @FindBy(css = "div[data-elementor-type='header'] > div:nth-child(1) > div:nth-child(2) > div > " +
            "div:nth-child(2) > div > div > div div[aria-label='Company']")
    protected WebElement companyModuleButton;

    @FindBy(css = "div[data-elementor-type='header'] > div> div > div > div > div > div > div > nav > ul > " +
            "li:nth-child(2) > div > div > div > div > div > div > div> div > div> div > div > ul > li")
    protected List<WebElement> companySubModulesButtonContainer;

    @FindBy(css = "div[data-elementor-type='header'] > div:nth-child(1) > div:nth-child(2) > div > div:nth-child(2)" +
            " > div > div > div div[aria-label='Customers']")
    protected WebElement customersButton;

    @FindBy(css = "div[data-elementor-type='header'] > div> div > div > div > div > div > div > nav > ul > " +
            "li:nth-child(3) > div > div > div > div > div > div > div > div > div > div > div > ul > li > a")
    protected List<WebElement> customerSubModulesButtonContainer;

    @FindBy(css = "div[data-elementor-type='header'] > div:nth-child(1) > div:nth-child(2) > div > div:nth-child(2) >" +
            " div > div > div div[aria-label='Ecosystem']")
    protected WebElement ecoSystemButton;

    @FindBy(css = "div[data-elementor-type='header'] > div:nth-child(1) > div > div > div > div > div > div > nav > " +
            "ul > li:nth-child(4) > div > div > div > div > div > div > div > div > div > div > div > ul > li > a")
    protected List<WebElement> ecoSystemSubModulesButton;

    @FindBy(css = "div[data-elementor-type='header'] > div:nth-child(1) > div:nth-child(2) > div > div:nth-child(2) " +
            "> div > div > div div[aria-label='Resources']")
    protected WebElement resourcesButton;

    @FindBy(css = "div[data-elementor-type='header'] > div:nth-child(1) > div:nth-child(2) > div > div:nth-child(2)" +
            " > div > div > div div[aria-label='Resources'] ~ div ul > li:nth-child(1)")
    protected WebElement blogsButton;

    @FindBy(css = "div[data-elementor-type='header'] > div:nth-child(1) > div:nth-child(2) > div > div:nth-child(2)" +
            " > div > div > div div[aria-label='Resources'] ~ div ul > li:nth-child(2)")
    protected WebElement webinarsButton;

    @FindBy(css = "div[data-elementor-type='header'] > div:nth-child(1) > div:nth-child(2) > div > div:nth-child(2)" +
            " > div > div > div div[aria-label='Resources'] ~ div ul > li:nth-child(3)")
    protected WebElement demoVideosButton;

    @FindBy(css = "div[data-elementor-type='header'] > div:nth-child(1) > div:nth-child(2) > div > div:nth-child(2)" +
            " > div > div > div div[aria-label='Resources'] ~ div ul > li:nth-child(4)")
    protected WebElement whitePapersButton;

    @FindBy(css = "div[data-elementor-type='header'] > div:nth-child(1) > div:nth-child(2) > div > div:nth-child(2)" +
            " > div > div > div div[aria-label='Resources'] ~ div ul > li:nth-child(5)")
    protected WebElement brochuresButton;

    @FindBy(css = "div[data-elementor-type='header'] > div:nth-child(1) > div:nth-child(2) > div > div:nth-child(2)" +
            " > div > div > div div[aria-label='Resources'] ~ div ul > li:nth-child(6)")
    protected WebElement viewAllResourcesButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private WebElement getCareerPageButton() {
        return companySubModulesButtonContainer.get(1);
    }

    @Step("Navigate to Careers page")
    public CareersPage navigateToCareersPage(){
        waitForElementToBeClickable(companyModuleButton);
        companyModuleButton.click();
        waitForElementToBeClickable(getCareerPageButton());
        getCareerPageButton().click();
        return PageFactory.initElements(driver, CareersPage.class);
    }

    private WebElement getViewAllCustomerSuccessStoriesButton() {
        return customerSubModulesButtonContainer.get(3);
    }

    @Step("Navigate to View All Customer stories page")
    public CustomerStoriesPage navigateToViewAllCustomerSuccessStoriesPage() {
        waitForElementToBeClickable(customersButton);
        customersButton.click();
        waitForElementToBeClickable(getViewAllCustomerSuccessStoriesButton());
        getViewAllCustomerSuccessStoriesButton().click();
        return PageFactory.initElements(driver, CustomerStoriesPage.class);
    }

    private WebElement getCustomerSuccessStoriesButton() {
        return customerSubModulesButtonContainer.get(0);
    }

    @Step("Navigate to Customer Success stories page")
    public CustomerStoriesPage navigateToCustomerSuccessStoriesPage() {
        waitForElementToBeClickable(customersButton);
        customersButton.click();
        waitForElementToBeClickable(getCustomerSuccessStoriesButton());
        getCustomerSuccessStoriesButton().click();
        return PageFactory.initElements(driver, CustomerStoriesPage.class);
    }

    private WebElement getCaseStudiesPageButton() {
        return customerSubModulesButtonContainer.get(1);
    }

    @Step("Navigate to Case Study page")
    public CaseStudiesPage navigateToCaseStudiesPage(){
        waitForElementToBeClickable(customersButton);
        customersButton.click();
        waitForElementToBeClickable(getCaseStudiesPageButton());
        getCaseStudiesPageButton().click();
        return PageFactory.initElements(driver, CaseStudiesPage.class);
    }

    private WebElement getMasterClassPageButton() {
        return customerSubModulesButtonContainer.get(2);
    }

    @Step("Navigate to Master Class page")
    public MasterClassPage navigateToMasterclassesPage(){
        waitForElementToBeClickable(customersButton);
        customersButton.click();
        waitForElementToBeClickable(getMasterClassPageButton());
        getMasterClassPageButton().click();
        return PageFactory.initElements(driver, MasterClassPage.class);
    }

    private WebElement getPartnerPageButton() {
        return ecoSystemSubModulesButton.get(0);
    }

    @Step("Navigate to Partner page")
    public PartnersPage navigateToPartnersPage(){
        waitForElementToBeClickable(ecoSystemButton);
        ecoSystemButton.click();
        waitForElementToBeClickable(getPartnerPageButton());
        getPartnerPageButton().click();
        return PageFactory.initElements(driver, PartnersPage.class);
    }

    private WebElement getSecurityAndIntegrationPageButton() {
        return ecoSystemSubModulesButton.get(1);
    }

    @Step("Navigate to Security and Integrations page")
    public SecurityAndIntegrationsPage navigateToSecurityAndIntegrationsPage() {
        waitForElementToBeClickable(ecoSystemButton);
        ecoSystemButton.click();
        waitForElementToBeClickable(getSecurityAndIntegrationPageButton());
        getSecurityAndIntegrationPageButton().click();
        return PageFactory.initElements(driver, SecurityAndIntegrationsPage.class);
    }

    private WebElement getRetailExcellencePageButton() {
        return ecoSystemSubModulesButton.get(2);
    }

    @Step("Navigate to retail excellence page")
    public RetailExcellencePage navigateToRetailExcellencePage() {
        waitForElementToBeClickable(ecoSystemButton);
        ecoSystemButton.click();
        waitForElementToBeClickable(getRetailExcellencePageButton());
        getRetailExcellencePageButton().click();
        return PageFactory.initElements(driver, RetailExcellencePage.class);
    }

    @Step("Navigate to Demo Videos page")
    public DemoVideosPage navigateToDemoVideosPage() {
        waitForElementToBeClickable(resourcesButton);
        resourcesButton.click();
        waitForElementToBeClickable(demoVideosButton);
        demoVideosButton.click();
        return PageFactory.initElements(driver, DemoVideosPage.class);
    }

    @Step("Navigate to Brochure page")
    public BrochuresPage navigateToBrochuresPage() {
        waitForElementToBeClickable(resourcesButton);
        resourcesButton.click();
        waitForElementToBeClickable(brochuresButton);
        brochuresButton.click();
        return PageFactory.initElements(driver, BrochuresPage.class);
    }
}
