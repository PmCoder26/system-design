package book_my_show_design;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Data
public class TheatreController {
    private Map<String, List<Theatre>> cityVsTheatre;
    private List<Theatre> allTheatres;


    void addTheatre(Theatre theatre, String city) {
        allTheatres.add(theatre);
        List<Theatre> theatres = cityVsTheatre.getOrDefault(city, new ArrayList<>());
        theatres.add(theatre);
        cityVsTheatre.put(city, theatres);
    }

    public Map<Theatre, List<Show>> getAllShows(Movie movie, String city) {
        // getting all the theatres of this city.
        Map<Theatre, List<Show>> theatreVsShows = new HashMap<>();
        List<Theatre> theatres = cityVsTheatre.get(city);

        // filtering the theatres which run this movie.
        for(Theatre theatre: theatres) {
            List<Show> availableMovieShows = theatre.getShows().stream()
                    .filter(show -> show.getMovie().getId() == movie.getId())
                    .toList();
            if(!availableMovieShows.isEmpty()) theatreVsShows.put(theatre, availableMovieShows);
        }

        return theatreVsShows;
    }

}
