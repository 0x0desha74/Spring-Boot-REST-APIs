package in.springrestapi.service.impls;

import in.springrestapi.dto.EmployeeDto;
import in.springrestapi.model.Department;
import in.springrestapi.model.Employee;
import in.springrestapi.repository.DepartmentRepository;
import in.springrestapi.repository.EmployeeRepository;
import in.springrestapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
   @Autowired
    private EmployeeRepository eRepository;
    @Autowired
    private DepartmentRepository dRepository;

    @Override
    public List<Employee> getEmployees(int pageNumber, int pageSize) {
        Pageable  pages = PageRequest.of(pageNumber,pageSize, Sort.Direction.DESC,"id");
        return eRepository.findAll(pages).getContent();
    }

    @Override
    public Employee SaveEmployee(EmployeeDto employeeDto) {
        //Retrieve the department
        Department department = dRepository.findById(employeeDto.getDepartment_id())
                .orElseThrow(()-> new RuntimeException("Department not found"));
        //Mapping dto to entity
         Employee employee = new Employee(employeeDto);
         //Set the department
        employee.setDepartment(department);
        //Create Employee
        return eRepository.save(employee);
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
        return eRepository.save(entity);

    }

    @Override
    public List<Employee> getEmployeeByName(String name) {
        return eRepository.findByName(name);

    }

    @Override
    public List<Employee> getEmployeesByNameAndLocation(String name, String location) {
        return eRepository.findByNameAndLocation(name,location);

    }

    @Override
    public List<Employee> getEmployeesByKeyword(String keyword)
    {
        Sort sort = Sort.by(Sort.Direction.DESC,"id");

        return eRepository.findByNameContaining(keyword,sort);
    }

    @Override
    public List<Employee> getEmployeesByNameOrLocation(String name, String location) {
       return eRepository.getEmployeesByNameOrLocation(name, location);
    }

    @Override
    public int deleteEmployeeByName(String name) {
        return eRepository.deleteEmployeeByName(name);
    }

    @Override
    public List<Employee> getEmployeeByDepartmentId(Long id) {
        return eRepository.findByDepartmentId(id);
    }


}
