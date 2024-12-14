package com.tulip.resources;

import com.tulip.home.HomePage;
import com.tulip.util.VideoOperationsContainer;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;
import java.util.Random;

public class DemoVideosPage extends HomePage {

    public static VideoOperationsContainer videoOperationsContainer;

    public static final int VIDEO_COUNT = 6;

    public static final int RANDOM_NUMBER = new Random().nextInt(6) + 1;

    @FindBy(css = "article")
    public List<WebElement> videoBlockContainer;

    @FindBy(css = "article > div > h3 > a")
    public List<WebElement> videoTittleContainer;

    public DemoVideosPage(WebDriver driver) {
        super(driver);
        videoOperationsContainer = PageFactory.initElements(driver, VideoOperationsContainer.class);
    }

    @Step("Get available video count")
    public int getVideoCount(){
        return videoBlockContainer.size() == VIDEO_COUNT ? videoBlockContainer.size() : 0;
    }

    @Step("Read the video title")
    public boolean readVideoTitle(List<String > videoTittleContainerInput) {
        for (int i = 0 ; i < videoTittleContainerInput.size() ;  i++) {
            if(!videoTittleContainerInput.get(i).equals(videoTittleContainer.get(i).getText())) {
                return false;
            }
        }
        return true;
    }

    @Step("Access the video")
    public boolean accessTheVideo(){
        WebElement videoImage = webDriverWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector
                ("article:nth-child(" + RANDOM_NUMBER + ") > a > div > picture > img")));
        javascriptExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'})", videoImage);
        videoImage.click();
        return isTheElementDisplayed(videoOperationsContainer.middleVideoPlayButton) &&
                isTheElementDisplayed(videoOperationsContainer.bottomLeftCornerVideoPlayButton);
    }

    @Step("Play the video")
    public boolean playTheVideo(){
        javascriptExecutor.executeScript("arguments[0].scrollIntoView({block: 'center'})",
                videoOperationsContainer.bottomLeftCornerVideoPlayButton);
        waitForElementToBeClickable(videoOperationsContainer.bottomLeftCornerVideoPlayButton);
        videoOperationsContainer.bottomLeftCornerVideoPlayButton.click();
        waitForElementToBeClickable(videoOperationsContainer.videoPauseButton);
        return isTheElementDisplayed(videoOperationsContainer.videoPauseButton);
    }

    @Step("Pause the video")
    public boolean pauseTheVideo() {
        waitForElementToBeClickable(videoOperationsContainer.videoPauseButton);
        videoOperationsContainer.videoPauseButton.click();
        waitForElementToBeClickable(videoOperationsContainer.bottomLeftCornerVideoPlayButton);
        return isTheElementDisplayed(videoOperationsContainer.bottomLeftCornerVideoPlayButton);
    }

    @Step("Change the video subtitle")
    public boolean changeVideoSubtitle(String optionToBeSelected) {
        try {
            waitForElementToBeClickable(videoOperationsContainer.showCaptionsMenu);
            videoOperationsContainer.showCaptionsMenu.click();
            if(optionToBeSelected.equals("English")){
                waitForElementToBeClickable(videoOperationsContainer.captionOptionEnglish);
                videoOperationsContainer.captionOptionEnglish.click();
                waitForVisibility(videoOperationsContainer.showCaptionsMenu);
                return isTheElementDisplayed(videoOperationsContainer.showCaptionsMenu);
            }
            else if(optionToBeSelected.equals("Off")) {
                waitForElementToBeClickable(videoOperationsContainer.captionOptionOff);
                videoOperationsContainer.captionOptionOff.click();
                waitForVisibility(videoOperationsContainer.showCaptionsMenu);
                return isTheElementDisplayed(videoOperationsContainer.showCaptionsMenu);
            }
            return false;
        }
        catch (Exception e) {
            System.out.println("There is no Caption option present for the video");
            return true;
        }
    }

    @Step("Mute the video")
    public boolean muteTheVideo() {
        actions.moveToElement(videoOperationsContainer.videoMuteButton).perform();
        waitForElementToBeClickable(videoOperationsContainer.videoMuteButton);
        videoOperationsContainer.videoMuteButton.click();
        waitForElementToBeClickable(videoOperationsContainer.videoUnMuteButton);
        return isTheElementDisplayed(videoOperationsContainer.videoUnMuteButton);
    }

    @Step("UnMute the video")
    public boolean unMuteTheVideo() {
        waitForElementToBeClickable(videoOperationsContainer.videoUnMuteButton);
        videoOperationsContainer.videoUnMuteButton.click();
        waitForElementToBeClickable(videoOperationsContainer.videoMuteButton);
        return isTheElementDisplayed(videoOperationsContainer.videoMuteButton);
    }

    @Step("Change the video Quality")
    public boolean changeTheVideoQuality(String qualityValue) {
        waitForElementToBeClickable(videoOperationsContainer.showSettingsButton);
        videoOperationsContainer.showSettingsButton.click();
        waitForElementToBeClickable(videoOperationsContainer.videoQualityMenu);
        videoOperationsContainer.videoQualityMenu.click();
        for(WebElement currentElement : videoOperationsContainer.videoQualityContainer) {
            String currentText = (String) javascriptExecutor.executeScript("return arguments[0].textContent;",
                    currentElement);
            if(currentText.equals(qualityValue)) {
                waitForElementToBeClickable(currentElement);
                currentElement.click();
                stopExecution(2);
                return isTheElementDisplayed(videoOperationsContainer.hideSettingsButton);
            }
        }
        return false;
    }

    @Step("Change the video playback rate")
    public boolean changeTheVideoPlaybackRate(String videoSpeedRate) {
        waitForElementToBeClickable(videoOperationsContainer.videoSpeedMenu);
        videoOperationsContainer.videoSpeedMenu.click();
        for(WebElement currentElement : videoOperationsContainer.videoSpeedContainer) {
            String currentText = (String) javascriptExecutor.executeScript("return arguments[0].textContent;",
                    currentElement);
            if(currentText.equals(videoSpeedRate)) {
                waitForElementToBeClickable(currentElement);
                currentElement.click();
                stopExecution(2);
                return isTheElementDisplayed(videoOperationsContainer.hideSettingsButton);
            }
        }
        return false;
    }

    @Step("Play the video in full screen")
    public boolean playTheVideoInFullScreen() {
        waitForElementToBeClickable(videoOperationsContainer.fullScreenButton);
        videoOperationsContainer.fullScreenButton.click();
        waitForElementToBeClickable(videoOperationsContainer.unFullScreenButton);
        return isTheElementDisplayed(videoOperationsContainer.unFullScreenButton);
    }

    @Step("Play the video in unFull screen")
    public boolean playTheVideoInUnFullScreen() {
        waitForElementToBeClickable(videoOperationsContainer.unFullScreenButton);
        videoOperationsContainer.unFullScreenButton.click();
        actions.moveToElement(videoOperationsContainer.fullScreenButton).perform();
        waitForElementToBeClickable(videoOperationsContainer.fullScreenButton);
        return true;
    }

    @Step("Move to a different time stamp in the video")
    public boolean scrubTheVideo(int secondsToOffset) {
        double currentTime = (Double) javascriptExecutor.executeScript("return arguments[0].currentTime;",
                videoOperationsContainer.videoElement);
        if(secondsToOffset >= 0 ) {
            double newTimeForward = currentTime + secondsToOffset;
            javascriptExecutor.executeScript("arguments[0].currentTime = arguments[1];",
                    videoOperationsContainer.videoElement, newTimeForward);
            stopExecution(2);
            return true;
        }
        else {
            double newTimeBackward = currentTime - Math.abs(secondsToOffset);
            javascriptExecutor.executeScript("arguments[0].currentTime = arguments[1];",
                    videoOperationsContainer.videoElement, newTimeBackward);
            return true;
        }
    }
}
