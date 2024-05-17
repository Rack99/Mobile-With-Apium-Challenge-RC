package Adapter.Screens;

import Adapter.Bases.BaseMobileScreen;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pmw.tinylog.Logger;

import java.util.List;

public class WatchlistScreen extends BaseMobileScreen {
    private final By watch_list = By.id("com.imdb.mobile:id/list");
    private final String primary_view = "com.imdb.mobile:id/primary_view";
    private final String linear_layout = "android.widget.LinearLayout";
    private final By primary_text = By.id("com.imdb.mobile:id/primaryText");
    public WatchlistScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    public boolean isMovieInWatchList(String movieName) {
        Logger.info("Checking that the film is on the watchlist.");
        List<MobileElement> watchListMovies = getWatchListMovies();
        boolean movieIsInWatchList = watchListMovies.stream()
                .map(movieElement -> (AndroidElement) movieElement)
                .anyMatch(movieElement -> movieName.equalsIgnoreCase(movieElement.findElement(primary_text).getText()));

        if (!movieIsInWatchList) {
            Logger.error("The movie {} was not found in the watch list.", movieName);
        }
        return movieIsInWatchList;
    }
    public List<MobileElement> getMoviesinWatchlist(){
        List<MobileElement> ListNames;
        WebDriverWait explicitWait = new WebDriverWait(driver, 15);

        AndroidElement names = (AndroidElement) explicitWait.
                until(ExpectedConditions.presenceOfElementLocated(watch_list));
        ListNames = names.findElementsByClassName(linear_layout);
        return ListNames;
    }
    public List<MobileElement> getWatchListMovies()
    {
        long timeOutInSeconds = 15;
        List<MobileElement> watchListMovies;
        WebDriverWait explicitWait = new WebDriverWait(driver, timeOutInSeconds);
        AndroidElement watchListAE = (AndroidElement) explicitWait.
                until(ExpectedConditions.visibilityOf(driver.findElement(watch_list)));
        watchListMovies = watchListAE.findElementsById(primary_view);
        return watchListMovies;
    }


}
