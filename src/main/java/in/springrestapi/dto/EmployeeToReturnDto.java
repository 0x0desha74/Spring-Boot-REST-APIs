package in.springrestapi.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeToReturnDto {
    private Long id;
    private String name;
    private String email;
}
