package book_my_show_design;

import book_my_show_design.enums.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Payment {
    private int id;
    private PaymentMethod paymentMethod;
}
