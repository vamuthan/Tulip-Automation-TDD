package com.tulip.L1Menu.resourcesModule;

import com.tulip.base.BaseTest;
import com.tulip.home.HomePage;
import com.tulip.resources.DemoVideosPage;
import com.tulip.util.JSONTestDataUtility;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.util.List;

@Test(dataProviderClass = JSONTestDataUtility.class)
public class ResourcesOptionTest extends BaseTest {

    @Test(priority = 0, dataProvider = "VideoOperationsTestData", groups = {"Regression", "VideoStreaming"})
    @Description("verify that all the video streaming functionalities are working correctly")
    @Severity(SeverityLevel.BLOCKER)
    public void performVideoOperationsInDemoVideoTest(List<String> videoTitleContainer,String videoSubtitleValue,
                      String videoQualityRate, String videoPlaybackRate, int secondsToOffsetTheVideo, int videoCount) {
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        DemoVideosPage demoVideosPage = homePage.navigateToDemoVideosPage();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(demoVideosPage.getVideoCount(), videoCount);
        softAssert.assertTrue(demoVideosPage.readVideoTitle(videoTitleContainer));
        softAssert.assertTrue(demoVideosPage.accessTheVideo());
        softAssert.assertTrue(demoVideosPage.playTheVideo());
        softAssert.assertTrue(demoVideosPage.pauseTheVideo());
        softAssert.assertTrue(demoVideosPage.playTheVideo());
        softAssert.assertTrue(demoVideosPage.changeVideoSubtitle(videoSubtitleValue));
        softAssert.assertTrue(demoVideosPage.muteTheVideo());
        softAssert.assertTrue(demoVideosPage.unMuteTheVideo());
        softAssert.assertTrue(demoVideosPage.changeTheVideoQuality(videoQualityRate));
        softAssert.assertTrue(demoVideosPage.changeTheVideoPlaybackRate(videoPlaybackRate));
        softAssert.assertTrue(demoVideosPage.playTheVideoInFullScreen());
        softAssert.assertTrue(demoVideosPage.playTheVideoInUnFullScreen());
        softAssert.assertTrue(demoVideosPage.scrubTheVideo(secondsToOffsetTheVideo));
        softAssert.assertAll();
    }
}
