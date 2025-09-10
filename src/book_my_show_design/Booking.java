package book_my_show_design;

import lombok.Data;

import java.util.List;

@Data
public class Booking {
    private int id;
    private Show show;
    private List<Seat> bookedSeats;
    private Payment payment;
}
