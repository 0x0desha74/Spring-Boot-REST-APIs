package in.springrestapi.Models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Employee {
    private String name;
    private int age;
    private String email;
    private String location;
    private String department;

}
