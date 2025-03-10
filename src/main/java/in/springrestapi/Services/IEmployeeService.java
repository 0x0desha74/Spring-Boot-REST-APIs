package in.springrestapi.Services;

import in.springrestapi.Models.Employee;

import java.util.List;


public interface IEmployeeService {
    List<Employee> getEmployees();
}
