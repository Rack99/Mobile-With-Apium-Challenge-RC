package Adapter.Screens;

import Adapter.Bases.BaseMobileScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pmw.tinylog.Logger;

public class RateScreen extends BaseMobileScreen {
    private final String first_opinion_location ="com.imdb.mobile:id/list_user_reviews_item";
    private final By reviews = By.id("com.imdb.mobile:id/list");
    WebDriverWait wait = new WebDriverWait(driver, 10);
    public RateScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }public String getFirstOpinion(){
        Logger.info("Saving the first message.");
        wait.until(ExpectedConditions.visibilityOfElementLocated(reviews));

        return driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\""+ first_opinion_location + "\").instance(0);").getText();
    }
}
