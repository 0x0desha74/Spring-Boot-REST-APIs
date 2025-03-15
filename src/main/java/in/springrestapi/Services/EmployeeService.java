package in.springrestapi.Services;

import in.springrestapi.Models.Employee;
import in.springrestapi.Repositories.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {
   @Autowired
    private IEmployeeRepository eRepository;
    @Override
    public List<Employee> getEmployees() {
        return eRepository.findAll();
    }

    @Override
    public Employee SaveEmployee(Employee entity) {
        return eRepository.save(entity);
    }

    @Override
    public Employee getEmployee(Long id) {
        Optional<Employee> employee =  eRepository.findById(id);
        if(employee.isPresent())
        return employee.get();
            throw new RuntimeException("Employee not found");
    }

    @Override
    public void deleteEmployee(Long id) {
         eRepository.deleteById(id);
    }

    @Override
    public Employee updateEmployee(Employee entity) {
        var employee = eRepository.save(entity);
        return employee;
    }

    @Override
    public List<Employee> getEmployeeByName(String name) {
        var employees = eRepository.findByName(name);
        return employees;
    }

    @Override
    public List<Employee> getEmployeesByNameAndLocation(String name, String location) {
        var employees = eRepository.findByNameAndLocation(name,location);
        return employees;
    }
}
