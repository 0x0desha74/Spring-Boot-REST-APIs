package in.springrestapi.service.impls;

import in.springrestapi.model.Employee;
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


    @Override
    public List<Employee> getEmployees(int pageNumber, int pageSize) {
        Pageable  pages = PageRequest.of(pageNumber,pageSize, Sort.Direction.DESC,"id");
        return eRepository.findAll(pages).getContent();
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


}
