package in.springrestapi.service;

import in.springrestapi.dto.DepartmentToReturnDto;
import in.springrestapi.model.Department;

import java.util.List;

public interface DepartmentService {

    List<DepartmentToReturnDto> getAllDepartments();
    Department getDepartmentById(Long id);
    Department addDepartment(Department entity);

}
