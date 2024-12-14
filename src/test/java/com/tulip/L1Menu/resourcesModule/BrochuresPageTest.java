package com.tulip.L1Menu.resourcesModule;

import com.tulip.base.BaseTest;
import com.tulip.home.HomePage;
import com.tulip.resources.BrochuresPage;
import com.tulip.util.JSONTestDataUtility;
import io.qameta.allure.Description;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Test(dataProviderClass = JSONTestDataUtility.class)
public class BrochuresPageTest extends BaseTest {

    @Description("Read the brochure information")
    @Test(priority = 0, dataProvider = "BrochurePageTestData", groups = {"Regression", "Brochure"})
    public void readTheBrochure(String brochureTitle, String brochureURLValue){
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        BrochuresPage brochuresPage = homePage.navigateToBrochuresPage();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(brochuresPage.getTheBrochureName(brochureTitle), brochureTitle);
        softAssert.assertTrue(brochuresPage.getBrochureURL(brochureTitle).contains(brochureURLValue));
        softAssert.assertAll();
    }
}
