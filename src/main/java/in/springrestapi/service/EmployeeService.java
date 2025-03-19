package in.springrestapi.service;

import in.springrestapi.model.Employee;

import java.util.List;


public interface EmployeeService {
    List<Employee> getEmployees(int pageNumber,int pageSize);
    Employee SaveEmployee(Employee employee);
    Employee getEmployee(Long id);
    void deleteEmployee(Long id);
    Employee updateEmployee(Employee entity);
    List<Employee> getEmployeeByName(String name);
    List<Employee> getEmployeesByNameAndLocation(String name, String location);
    List<Employee> getEmployeesByKeyword(String keyword);
    List<Employee> getEmployeesByNameOrLocation(String name,String location);
    int deleteEmployeeByName(String name);
}
