package Tests;
import Adapter.Bases.BaseMobileTest;
import Adapter.Screens.*;
import Reader.JsonReader;
import dto.Movie;
import dto.RateMessage;
import org.pmw.tinylog.Logger;
import org.testng.annotations.Test;
import org.testng.Assert;
import java.io.IOException;


public class MyTest extends BaseMobileTest {
    JsonReader jsonReader = new JsonReader();
    Movie movieData = jsonReader.readMovie("MovieData.Json");
    HomeScreen home;
    SearchScreen search;
    MovieScreen movie;
    LoginScreen login;
    WatchlistScreen watch;
    RateScreen rate;
    RateMessage opinion = new RateMessage();

    public MyTest() throws IOException {
    }

    @Test
    void SearchMovies() {
        home = new HomeScreen(driver);
        search = new SearchScreen(driver);
        movie = new MovieScreen(driver);
        home.GotoSearchScreen();
        search.SearchMovie(movieData.getMovie());
        Assert.assertEquals(movieData.getOverview(),movie.getOverview());
        Logger.info("The overview is correct.");
    }
    @Test
    //This test needs an account associated with the device.
    void LoginAndWatchList(){
        String moviename = movieData.getMovie();
        home = new HomeScreen(driver);
        search = new SearchScreen(driver);
        movie = new MovieScreen(driver);
        login = new LoginScreen(driver);
        watch = new WatchlistScreen(driver);
        home.GotoLoginScreen();
        login.Login();
        home.clicksearch();
        search.SearchMovie(moviename);
        movie.addWatchlist();
        home.GotoNavigateyou();
        login.GotoSeAll();
        Assert.assertEquals(true,watch.isMovieInWatchList(moviename));
    }
    @Test
    void LoginAndSaveRateMessage(){
        String moviename = movieData.getMovie();
        home = new HomeScreen(driver);
        search = new SearchScreen(driver);
        movie = new MovieScreen(driver);
        login = new LoginScreen(driver);
        watch = new WatchlistScreen(driver);
        rate = new RateScreen(driver);
        home.GotoLoginScreen();
        login.Login();
        home.clicksearch();
        search.SearchMovie(moviename);
        movie.goToRatePage();
        Assert.assertNotNull(rate.getFirstOpinion(),"");
        opinion.setMessage(rate.getFirstOpinion());

    }
}


