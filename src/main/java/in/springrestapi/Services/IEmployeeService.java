package in.springrestapi.Services;

import in.springrestapi.Models.Employee;

import java.util.List;


public interface IEmployeeService {
    List<Employee> getEmployees();
    Employee SaveEmployee(Employee employee);
    Employee getEmployee(Long id);
    void deleteEmployee(Long id);
    Employee updateEmployee(Employee entity);
    List<Employee> getEmployeeByName(String name);
}
