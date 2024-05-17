package Adapter.Screens;

import Adapter.Bases.BaseMobileScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pmw.tinylog.Logger;

public class MovieScreen extends BaseMobileScreen {
    WebDriverWait wait = new WebDriverWait(driver, 10);
    private final By movie_description = By.id("com.imdb.mobile:id/plot_overview");
    private final By watch_list_button = By.id("com.imdb.mobile:id/watchlist_button");
    private final String rate_button = "See all user reviews";
    public MovieScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }
    public String getOverview(){

        return wait.until(ExpectedConditions.visibilityOfElementLocated(movie_description)).getText();
    }

    public void addWatchlist (){
        Logger.info("Adding the movie to watchlist.");
        wait.until(ExpectedConditions.elementToBeClickable(watch_list_button));
        driver.findElement(watch_list_button).click();
    }

    public void goToRatePage(){
        Logger.info("Scroll down to go to rate section. ");
        driver.findElementByAndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView("
                        + "new UiSelector().text(\"" + rate_button + "\"));"
        ).click();

    }

}
