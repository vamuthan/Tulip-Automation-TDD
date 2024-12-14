package com.tulip.L1Menu.companyModule;

import com.tulip.base.BaseTest;
import com.tulip.careers.BambooHRCareerPage;
import com.tulip.home.HomePage;
import com.tulip.careers.CareersPage;
import com.tulip.util.JSONTestDataUtility;
import io.qameta.allure.Description;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Test(dataProviderClass = JSONTestDataUtility.class)
public class CompanyOptionTest extends BaseTest {

    @Description("Validate the available job openings")
    @Test(priority = 0, dataProvider = "JobCountTestData", groups = {"Regression", "CompanyOption"})
    public void searchJobOpeningTest(int jobCount, String pageURLContent, String tableHeadingValue) {
        SoftAssert softAssert = new SoftAssert();
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        CareersPage careersPage = homePage.navigateToCareersPage();
        softAssert.assertTrue(careersPage.getCurrentPageURL().contains(pageURLContent));
        BambooHRCareerPage bambooHRCareerPage = careersPage.navigateToBambooHRJobListingPage();
        softAssert.assertEquals(bambooHRCareerPage.getTableHeading(), tableHeadingValue);
        softAssert.assertEquals(bambooHRCareerPage.getAvailableJobCount(), jobCount);
        softAssert.assertAll();
    }
}
