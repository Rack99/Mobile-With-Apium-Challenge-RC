package Adapter.Screens;

import Adapter.Bases.BaseMobileScreen;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeScreen extends BaseMobileScreen {
    //com.imdb.mobile:id/navigation_search_browse is not the same as com.imdb.mobile:id/navigation_bar_item_icon_view
    // the latter is the icon identifier not the button identifier.
    WebDriverWait wait = new WebDriverWait(driver, 10);
    private final By navigate_search_button =By.id("com.imdb.mobile:id/navigation_search_browse");
    private final By continue_button =By.id("com.imdb.mobile:id/welcome_dialog_continue");
    private final By navigate_login_button = By.id("com.imdb.mobile:id/navigation_you");
    public HomeScreen(AndroidDriver<AndroidElement> driver) {
        super(driver);
    }

    public void GotoSearchScreen() {

        clickContinue();
        wait.until(ExpectedConditions.visibilityOfElementLocated(navigate_search_button));
        driver.findElement(navigate_search_button).click();
    }

    public void GotoLoginScreen(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        clickContinue();
        wait.until(ExpectedConditions.visibilityOfElementLocated(navigate_login_button));
        driver.findElement(navigate_login_button).click();

    }
    public void GotoNavigateyou(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(navigate_login_button));
        driver.findElement(navigate_login_button).click();
    }

    public void clickContinue(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(continue_button));
        driver.findElement(continue_button).click();
    }
    public void clicksearch(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(navigate_search_button));
        driver.findElement(navigate_search_button).click();
    }
}
