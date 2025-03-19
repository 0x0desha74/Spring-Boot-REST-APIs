package in.springrestapi.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class DepartmentToReturnDto {
    private Long id;
    private String DepartmentName;
    private List<EmployeeToReturnDto> employees;
}
