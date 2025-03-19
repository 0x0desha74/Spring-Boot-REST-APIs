package in.springrestapi.service;

import in.springrestapi.dto.EmployeeDTO;
import in.springrestapi.model.Employee;

import java.util.List;


public interface EmployeeService {
    List<Employee> getEmployees(int pageNumber,int pageSize);
    Employee SaveEmployee(EmployeeDTO employeeDto);
    Employee getEmployee(Long id);
    void deleteEmployee(Long id);
    Employee updateEmployee(Employee entity);
    List<Employee> getEmployeeByName(String name);
    List<Employee> getEmployeesByNameAndLocation(String name, String location);
    List<Employee> getEmployeesByKeyword(String keyword);
    List<Employee> getEmployeesByNameOrLocation(String name,String location);
    int deleteEmployeeByName(String name);
    List<Employee> getEmployeeByDepartmentId(Long id);
}
