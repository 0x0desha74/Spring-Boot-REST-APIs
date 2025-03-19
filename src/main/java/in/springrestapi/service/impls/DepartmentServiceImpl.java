package in.springrestapi.service.impls;

import in.springrestapi.model.Department;
import in.springrestapi.repository.DepartmentRepository;
import in.springrestapi.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.RuntimeErrorException;
import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository dRepo;

    @Override
    public List<Department> getAllDepartments() {
        return dRepo.findAll();
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
