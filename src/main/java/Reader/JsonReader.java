package Reader;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.Movie;

import java.io.FileReader;
import java.io.IOException;

public class JsonReader {

    private final Gson gson;

    public JsonReader() {
              this.gson = new GsonBuilder().create();
    }

    public Movie readMovie(String filePath) throws IOException {
        try (FileReader reader = new FileReader("src/main/Data/"+filePath)) {
          return gson.fromJson(reader, Movie.class);
        }
    }
}
