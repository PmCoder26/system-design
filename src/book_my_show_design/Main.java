package book_my_show_design;

import book_my_show_design.enums.PaymentMethod;
import book_my_show_design.enums.SeatCategory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static MovieController movieController;
    private static TheatreController theatreController;

    private static void initialize() {
        // creating movies.
        createMovies();

        // creating theatres.
        createTheatres();
    }

    private static void createMovies() {
        Movie avengersMovie = new Movie(1, "Avengers", 180);
        Movie bahubaliMovie = new Movie(2, "Bahubali", 200);

        movieController.addMovie(avengersMovie, "Delhi");
        movieController.addMovie(bahubaliMovie, "Delhi");
    }

    private static void createTheatres() {
        Movie avengersMovie = movieController.getMovieByName("Avengers");
        Movie bahubaliMovie = movieController.getMovieByName("Bahubali");

        Theatre imaxTheatre = new Theatre();
        imaxTheatre.setId(1);
        imaxTheatre.setScreens(createScreens());
        imaxTheatre.setCity("Delhi");
        List<Show> imaxShows = new ArrayList<>();
        Show iMaxMorningShow = createShow(1, avengersMovie, imaxTheatre.getScreens().get(0), 8);
        Show iMaxEveningShow = createShow(2, bahubaliMovie, imaxTheatre.getScreens().get(0), 16);
        imaxShows.add(iMaxMorningShow);
        imaxShows.add(iMaxEveningShow);
        imaxTheatre.setShows(imaxShows);

        Theatre pvrTheatre = new Theatre();
        pvrTheatre.setId(2);
        pvrTheatre.setScreens(createScreens());
        pvrTheatre.setCity("Delhi");
        List<Show> pvrShows = new ArrayList<>();
        Show pvrMorningShow = createShow(3, avengersMovie, pvrTheatre.getScreens().get(0), 13);
        Show pvrEveningShow = createShow(4, bahubaliMovie, pvrTheatre.getScreens().get(0), 20);
        pvrShows.add(pvrMorningShow);
        pvrShows.add(pvrEveningShow);
        pvrTheatre.setShows(pvrShows);

        theatreController.addTheatre(imaxTheatre, "Delhi");
        theatreController.addTheatre(pvrTheatre, "Delhi");
    }

    private static List<Screen> createScreens() {
        Screen screen = new Screen(1, createSeats());
        List<Screen> screens = new ArrayList<>();
        screens.add(screen);
        return screens;
    }

    private static List<Seat> createSeats() {
        // creating 100 seats.
        List<Seat> seats = new ArrayList<>();

        // 1 to 40 for Silver.
        for(int x = 0; x < 40; x++) {
            Seat seat = new Seat(x, x % 10, SeatCategory.SILVER, 200);
            seats.add(seat);
        }

        // 41 to 70 for Gold.
        for(int x = 40; x < 70; x++) {
            Seat seat = new Seat(x, x % 10, SeatCategory.GOLD, 350);
            seats.add(seat);
        }

        // 71 to 100 for Platinum.
        for(int x = 70; x < 100; x++) {
            Seat seat = new Seat(x, x % 10, SeatCategory.PLATINUM, 500);
            seats.add(seat);
        }

        return seats;
    }

    private static Show createShow(int id, Movie movie, Screen screen, int startTime) {
        Show show = new Show();
        show.setId(id);
        show.setMovie(movie);
        show.setScreen(screen);
        show.setStartTime(startTime);
        show.setBookedSeatsIds(new ArrayList<>());
        return show;
    }

    private static void createBooking(String city, String movieName) {
        // searching the movie by location.
        List<Movie> movies = movieController.getMoviesByCityName(city);

        Movie interstedMovie = movies.stream()
                .filter(movie -> movie.getName().equals(movieName))
                .toList().get(0);

        // getting all the shows of this movie.
        Map<Theatre, List<Show>> theatreVsShows = theatreController.getAllShows(interstedMovie, city);

        // select the particular theatre the user is interested in.
        Map.Entry<Theatre, List<Show>> entry = theatreVsShows.entrySet().iterator().next();
        List<Show> runningShows = entry.getValue();
        Show interestedShow = runningShows.get(0);

        // select the seat.
        int seatNumber = 40;
        List<Integer> bookedSeats = interestedShow.getBookedSeatsIds();
        if(!bookedSeats.contains(seatNumber)) {
            // book the seat.
            bookedSeats.add(seatNumber);

            // start payment.
            Booking booking = new Booking();
            List<Seat> myBookedSeats = new ArrayList<>();
            for(Seat screenSeat: interestedShow.getScreen().getSeats()) {
                if(screenSeat.getId() == seatNumber) {
                    myBookedSeats.add(screenSeat);
                }
            }
            booking.setId(1);
            booking.setShow(interestedShow);
            booking.setBookedSeats(myBookedSeats);
            booking.setPayment(new Payment(1, PaymentMethod.UPI));
        } else {
            System.out.println("Seat already booked, try again.");
            return;
        }
        System.out.println("Booking successful!!!");
    }

    public static void main(String[] args) {

        // initializing movie and theatre controllers.
        movieController = new MovieController(new HashMap<>(), new ArrayList<>());
        theatreController = new TheatreController(new HashMap<>(), new ArrayList<>());

        // initializing the BookMyShow.
        initialize();

        // booking a show.
        createBooking("Delhi", "Avengers");
    }

}
