package book_my_show_design;

import lombok.Data;

import java.util.List;


@Data
public class Theatre {
    private int id;
    private String address;
    private String city;
    private List<Screen> screens;
    private List<Show> shows;
}
