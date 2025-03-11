package in.springrestapi.Services;

import in.springrestapi.Models.Employee;
import in.springrestapi.Repositories.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
   @Autowired
    private IEmployeeRepository eRepository;
    @Override
    public List<Employee> getEmployees() {
        return eRepository.findAll();
    }
}
