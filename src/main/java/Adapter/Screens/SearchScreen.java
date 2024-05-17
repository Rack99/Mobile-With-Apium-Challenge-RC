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
import java.util.Optional;


public class SearchScreen extends BaseMobileScreen {

    private final By search_text_box = By.id("com.imdb.mobile:id/search_src_text");
    private final By option = By.id("com.imdb.mobile:id/recycler_search_suggestions");
    public SearchScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    public void SearchMovie(String movie) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Logger.info("Trying to find the movie.");
        wait.until(ExpectedConditions.visibilityOfElementLocated(search_text_box));

        AndroidElement searchInput =(AndroidElement) driver.findElement(search_text_box);
        searchInput.click();
        AndroidElement text =(AndroidElement) driver.findElement(search_text_box);
        text.sendKeys(movie);
        clickMovie(movie);
    }

    public List<MobileElement> getMoviesTitles(){
        List<MobileElement> ListNames;
        WebDriverWait explicitWait = new WebDriverWait(driver, 15);

        AndroidElement names = (AndroidElement) explicitWait.
                until(ExpectedConditions.presenceOfElementLocated(option));
        ListNames = names.findElementsByClassName("android.widget.LinearLayout");
        return ListNames;
    }

    public void clickMovie(String movieName) {
        List<MobileElement> suggestedMovies = getMoviesTitles();

        Optional<AndroidElement> targetMovie = suggestedMovies.stream()
                .map(movieElement -> (AndroidElement) movieElement)
                .filter(movieElement -> movieName.equalsIgnoreCase(movieElement.findElement(By.id("com.imdb.mobile:id/suggestion")).getText()))
                .findFirst();

        if (targetMovie.isPresent()) {
            targetMovie.get().click();
            Logger.info("The movie has been found and clicked: {}", movieName);
        } else {
            Logger.error("The movie {} was not found in the suggestions list.", movieName);
        }


    }


}