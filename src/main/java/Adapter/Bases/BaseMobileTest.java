package Adapter.Bases;


import Core.ConfigCapabilities;
import Core.MobileAppDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.*;


public class BaseMobileTest {

    protected AndroidDriver<AndroidElement> driver;

    @BeforeTest(alwaysRun = true)
    public void setUp(){
        driver = new MobileAppDriver().GetMoviesAppDriver(new ConfigCapabilities().GetCapabilities());
    }

    @AfterTest(alwaysRun = true)
    public void tearDown()
    {
       driver.quit();
    }


}


