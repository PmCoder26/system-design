package book_my_show_design;

import book_my_show_design.enums.SeatCategory;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Seat {
    private int id;
    private int row;
    private SeatCategory category;
    private int price;
}
