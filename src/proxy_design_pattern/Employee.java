package proxy_design_pattern;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Employee {
    private int id;
    private String name;
    private int salary;
    private String designation;
}
