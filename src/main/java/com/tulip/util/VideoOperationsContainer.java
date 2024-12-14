package com.tulip.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.tulip.base.WebPage;
import java.util.List;

public class VideoOperationsContainer extends WebPage {

    @FindBy(css = "button[type='button']")
    public WebElement middleVideoPlayButton;

    @FindBy(css = "button[title='Play Video']")
    public WebElement bottomLeftCornerVideoPlayButton;

    @FindBy(css = "button[title='Mute']")
    public WebElement videoMuteButton;

    @FindBy(css = "button[title='Unmute']")
    public WebElement videoUnMuteButton;

    @FindBy(css = "div[class='w-playbar__time']")
    public WebElement timeStampTextContent;

    @FindBy(css = "div[aria-label='Playbar'] > div:nth-child(2)")
    public WebElement videoSliderButton;

    @FindBy(css = "div[class='w-volume-grabber'] > div")
    public WebElement volumeSliderButton;

    @FindBy(css = "button[title='Hide settings menu']")
    public WebElement hideSettingsButton;

    @FindBy(css = "button[title='Show settings menu']")
    public WebElement showSettingsButton;

    @FindBy(css = "button[title='Pause']")
    public WebElement videoPauseButton;

    @FindBy(css = "button[title='Show captions menu']")
    public WebElement showCaptionsMenu;

    @FindBy(css = "button[title='Hide captions menu']")
    public WebElement hideCaptionMenu;

    @FindBy(css = "button[title='Hide captions menu'] ~ div > div > div > div > div > button")
    public WebElement captionOptionSearchVideo;

    @FindBy(css = "button[title='Hide captions menu'] ~ div > div > div > div > div > fieldset > div:nth-child(2) > " +
            "label")
    public WebElement captionOptionOff;

    @FindBy(css = "button[title='Hide captions menu'] ~ div > div > div > div > div > fieldset > div:nth-child(3) > " +
            "label")
    public WebElement captionOptionEnglish;

    @FindBy(css = "button[data-handle='quality']")
    public WebElement videoQualityMenu;

    @FindBy(css = "button[data-handle='playbackRate']")
    public WebElement videoSpeedMenu;

    @FindBy(css = "button[data-handle='quality'] ~ div > fieldset > div > label")
    public List<WebElement> videoQualityContainer;

    @FindBy(css = "button[data-handle='playbackRate'] ~ div > fieldset > div > label")
    public List<WebElement> videoSpeedContainer;

    @FindBy(css = "button[title='Fullscreen']")
    public WebElement fullScreenButton;

    @FindBy(css = "button[title='Unfullscreen']")
    public WebElement unFullScreenButton;

    @FindBy(css = "video")
    public WebElement videoElement;

    public VideoOperationsContainer(WebDriver driver) {
        super(driver);
    }

}
