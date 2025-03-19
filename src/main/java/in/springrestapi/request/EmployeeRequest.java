package in.springrestapi.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeRequest {
    private String name;
    private String department;
    private String location;
    private String email;
    private int age;
}
