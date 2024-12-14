package com.tulip.L1Menu.ecoSystemModule;

import com.tulip.base.BaseTest;
import com.tulip.home.HomePage;
import com.tulip.ecoSystem.PartnersPage;
import com.tulip.ecoSystem.RetailExcellencePage;
import com.tulip.ecoSystem.SecurityAndIntegrationsPage;
import com.tulip.util.JSONTestDataUtility;
import io.qameta.allure.Description;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.util.Arrays;
import java.util.List;

@Test(dataProviderClass = JSONTestDataUtility.class)
public class EcosystemOptionTest extends BaseTest {

    @Description("Validate All Partner information")
    @Test(priority = 0, dataProvider = "PartnersTestData", groups = {"Regression", "EcoSystem"})
    public void readAllPartnerInformationTest(String pageURLContent){
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        PartnersPage partnersPage = homePage.navigateToPartnersPage();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(partnersPage.getCurrentPageURL().contains(pageURLContent));
        softAssert.assertEquals(partnersPage.readStrategicPartnersData(), true);
        softAssert.assertEquals(partnersPage.readTechnologyPartnersData(), true);
        softAssert.assertEquals(partnersPage.readSystemIntegratorsAndConsultantsData(), true);
        softAssert.assertAll();
    }

    @Description("Validate Security and Integrators information")
    @Test(priority = 1, dataProvider = "SecurityAndIntegratorsTestData", groups = {"Regression", "EcoSystem"})
    public void readAllSecurityAndIntegratorsInformationTest(String pageURLContent, String[] textContainer,
                                                     String extensibilityHeadingValue, String securityHeadingValue) {
        SoftAssert softAssert = new SoftAssert();
        HomePage homePage =  PageFactory.initElements(driver, HomePage.class);
        SecurityAndIntegrationsPage securityAndIntegrationsPage = homePage.navigateToSecurityAndIntegrationsPage();
        softAssert.assertTrue(securityAndIntegrationsPage.getCurrentPageURL().contains(pageURLContent));
        softAssert.assertTrue(Arrays.equals(securityAndIntegrationsPage.getIntegrationsFeatures(), textContainer));
        softAssert.assertEquals(securityAndIntegrationsPage.getExtensibilitySectionHeader(), extensibilityHeadingValue);
        softAssert.assertEquals(securityAndIntegrationsPage.getSecuritySectionHeader(), securityHeadingValue);
        softAssert.assertAll();
    }

    @Description("Validate Retail Excellence information")
    @Test(priority = 2, dataProvider = "RetailExcellenceTestData", groups = {"Regression", "EcoSystem"})
    public void readAllRetailExcellenceInformationTest(String pageURLContent, List<String> subHeadingContainer,
                                                       String expectedHeaderText) {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        RetailExcellencePage retailExcellencePage = homePage.navigateToRetailExcellencePage();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(retailExcellencePage.getCurrentPageURL().contains(pageURLContent));
        softAssert.assertEquals(retailExcellencePage.getHeaderText(), expectedHeaderText);
        softAssert.assertTrue(subHeadingContainer.equals(retailExcellencePage.getSubHeadingElementsList()));
        softAssert.assertAll();
    }
}
