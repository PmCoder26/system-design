package book_my_show_design;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
public class MovieController {
    private Map<String, List<Movie>> cityVsMovies;
    private List<Movie> allMovies;


    public void addMovie(Movie movie, String city) {
        allMovies.add(movie);
        List<Movie> movies = cityVsMovies.getOrDefault(city, new ArrayList<>());
        movies.add(movie);
        cityVsMovies.put(city, movies);
    }

    public Movie getMovieByName(String movieName) {
        for(Movie movie: allMovies)
            if(movie.getName().equals(movieName)) return movie;
        return null;
    }

    public List<Movie> getMoviesByCityName(String cityName) {
        return cityVsMovies.get(cityName);
    }
}
