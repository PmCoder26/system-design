package book_my_show_design;

import lombok.Data;

import java.util.List;

@Data
public class Show {
    private int id;
    private Movie movie;
    private Screen screen;
    private int startTime;
    private List<Integer> bookedSeatsIds;
}
