package book_my_show_design;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class User {
    private int id;
    private String username;
    private String mobileNumber;
}
