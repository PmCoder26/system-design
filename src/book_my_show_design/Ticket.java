package book_my_show_design;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Ticket {
    private int id;
    private Show show;
    private User user;
}
