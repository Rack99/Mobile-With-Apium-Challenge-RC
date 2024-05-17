package dto;

public class Movie {
    private String movie;
    private String overview;


    public Movie() {
    }

    // Getters y setters
    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }
}