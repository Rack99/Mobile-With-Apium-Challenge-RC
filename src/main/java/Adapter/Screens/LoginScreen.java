package Adapter.Screens;

import Adapter.Bases.BaseMobileScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.pmw.tinylog.Logger;

import java.util.concurrent.TimeUnit;

public class LoginScreen extends BaseMobileScreen {
    private  final By sing_in_button = By.id("com.imdb.mobile:id/sign_in_button");
    private  final By google_auth_button =By.id("com.imdb.mobile:id/google_oauth");
    private  final By see_all_button = By.id("com.imdb.mobile:id/see_all");
    private  final By watch_list_header = By.id("com.imdb.mobile:id/you_tab_empty_watchlist_header");
    WebDriverWait wait = new WebDriverWait(driver, 10);

    public LoginScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }
    public void Login (){
        Logger.info("Logging in");
        wait.until(ExpectedConditions.visibilityOfElementLocated(sing_in_button));
        driver.findElement(sing_in_button).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(google_auth_button));
        driver.findElement(google_auth_button).click();
        wait.withTimeout(20, TimeUnit.SECONDS).until(ExpectedConditions.visibilityOfElementLocated(watch_list_header));
    }

    public void GotoSeAll(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(see_all_button));
        driver.findElement(see_all_button).click();

    }

}
