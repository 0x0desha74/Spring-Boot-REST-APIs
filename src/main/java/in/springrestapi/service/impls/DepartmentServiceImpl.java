package in.springrestapi.service.impls;

import in.springrestapi.dto.DepartmentToReturnDto;
import in.springrestapi.dto.EmployeeToReturnDto;
import in.springrestapi.model.Department;
import in.springrestapi.repository.DepartmentRepository;
import in.springrestapi.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.RuntimeErrorException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository dRepo;

    @Override
    public List<DepartmentToReturnDto> getAllDepartments() {
        var departments = dRepo.findAll();
        List<DepartmentToReturnDto> departmentsDto = new ArrayList<>();

        departments.forEach(d -> {
            DepartmentToReturnDto deptDto = new DepartmentToReturnDto();
            deptDto.setDepartmentName(d.getName());
            deptDto.setId(d.getId());

            // Convert Employee List to EmployeeToReturnDto List
            List<EmployeeToReturnDto> employeeDtos = d.getEmployees().stream()
                    .map(emp -> {
                        EmployeeToReturnDto empDto = new EmployeeToReturnDto();
                        empDto.setId(emp.getId());
                        empDto.setName(emp.getName());

                        empDto.setEmail(emp.getEmail());
                        return empDto;
                    })
                    .collect(Collectors.toList());

            deptDto.setEmployees(employeeDtos);
            departmentsDto.add(deptDto);
        });

        return departmentsDto;
    }
    @Override
    public Department getDepartmentById(Long id) {
        Optional<Department> department =  dRepo.findById(id);
        if(department.isPresent())
            return department.get();
        throw new RuntimeException("Department not found");
    }

    @Override
    public Department addDepartment( Department entity) {
        return dRepo.save(entity);
    }
}
