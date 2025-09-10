package book_my_show_design;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Movie {
    private int id;
    private String name;
    private int duration;   // in minutes.
}
