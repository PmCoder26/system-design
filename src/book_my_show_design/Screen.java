package book_my_show_design;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class Screen {
    private int id;
    private List<Seat> seats;
}
