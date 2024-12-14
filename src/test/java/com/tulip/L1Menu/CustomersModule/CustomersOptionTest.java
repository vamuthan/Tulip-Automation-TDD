package com.tulip.L1Menu.CustomersModule;

import com.tulip.base.BaseTest;
import com.tulip.home.HomePage;
import com.tulip.customers.CaseStudiesPage;
import com.tulip.customers.CustomerStoriesPage;
import com.tulip.customers.MasterClassPage;
import com.tulip.util.JSONTestDataUtility;
import io.qameta.allure.Description;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Test(dataProviderClass = JSONTestDataUtility.class)
public class CustomersOptionTest extends BaseTest {

    @Description("Validate View all customer stories")
    @Test(priority = 0, dataProvider = "ViewAllCustomerTestData", groups = {"Regression", "CustomerOption"})
    public void searchSpecificViewAllCustomerSuccessStoryTest(String pageURLContent, String searchFilterLabel,
                                                              String searchFilterText) {
        SoftAssert softAssert = new SoftAssert();
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        CustomerStoriesPage customerStoriesPage = homePage.navigateToViewAllCustomerSuccessStoriesPage();
        softAssert.assertTrue(customerStoriesPage.getCurrentPageURL().contains(pageURLContent));
        softAssert.assertTrue(customerStoriesPage.searchInFilter(searchFilterLabel, searchFilterText));
        softAssert.assertTrue(customerStoriesPage.getPostAvailability(searchFilterLabel, searchFilterText));
        softAssert.assertAll();
    }

    @Description("Validate Customer Success story")
    @Test(priority = 1, dataProvider = "CustomerSuccessStoryTestData", groups = {"Regression", "CustomerOption"})
    public void searchSpecificCustomerSuccessStoryTest(String pageURLContent, String searchFilterLabel,
                                                       String searchFilterText) {
        SoftAssert softAssert = new SoftAssert();
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        CustomerStoriesPage customerStoriesPage = homePage.navigateToCustomerSuccessStoriesPage();
        softAssert.assertTrue(customerStoriesPage.getCurrentPageURL().contains(pageURLContent));
        softAssert.assertTrue(customerStoriesPage.searchInFilter(searchFilterLabel, searchFilterText));
        softAssert.assertTrue(customerStoriesPage.getPostAvailability(searchFilterLabel, searchFilterText));
        softAssert.assertAll();
    }

    @Description("Validate Case Study")
    @Test(priority = 2, dataProvider = "CaseStudiesTestData", groups = {"Regression", "CustomerOption"})
    public void searchSpecificCaseStudyTest(String pageURLContent, String postTextValue){
        SoftAssert softAssert = new SoftAssert();
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        CaseStudiesPage caseStudiesPage = homePage.navigateToCaseStudiesPage();
        softAssert.assertTrue(caseStudiesPage.getCurrentPageURL().contains(pageURLContent));
        softAssert.assertTrue(caseStudiesPage.getPostAvailable(postTextValue));
        softAssert.assertAll();
    }

    @Description("Validate Master Class")
    @Test(priority = 3, dataProvider = "MasterClassTestData", groups = {"Regression", "CustomerOption"})
    public void searchSpecificMasterClassTest(String pageURLContent, String postTextValue){
        SoftAssert softAssert = new SoftAssert();
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        MasterClassPage masterClassPage = homePage.navigateToMasterclassesPage();
        softAssert.assertTrue(masterClassPage.getCurrentPageURL().contains(pageURLContent));
        softAssert.assertTrue(masterClassPage.getPostAvailable(postTextValue));
        softAssert.assertAll();
    }
}
