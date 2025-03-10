package in.springrestapi.Services;

import in.springrestapi.Models.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    private static List<Employee> list = new ArrayList<>();
    static{
        var employee = new Employee();
        employee.setName("Mustafa");
        employee.setAge(22);
        employee.setEmail("mustafa@gmail.com");
        employee.setLocation("Egypt");
        employee.setDepartment("Software Engineering");
        list.add(employee);

        var employee1 = new Employee();
        employee1.setName("Nada");
        employee1.setAge(21);
        employee1.setEmail("nada@gmail.com");
        employee1.setLocation("Egypt");
        employee1.setDepartment("Commercial Engineering");
        list.add(employee1);
    }
    @Override
    public List<Employee> getEmployees() {
        return list;
    }
}
