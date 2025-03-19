package in.springrestapi.service;

import in.springrestapi.model.Department;

import java.util.List;

public interface DepartmentService {

    List<Department> getAllDepartments();
    Department getDepartmentById(Long id);
    Department addDepartment(Department entity);

}
