package in.springrestapi.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDto {
    @NotBlank(message = "Name should not be null")
    private String name;
    private Long department_id;
    private String location;
    @NotBlank(message = "Email should not be null")
    private String email;
    private int age;

}
