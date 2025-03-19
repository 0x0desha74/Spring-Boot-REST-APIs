package in.springrestapi.repository;

import in.springrestapi.model.Employee;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    //Search by name
    List<Employee> findByName(String name);
    //Search by name and location
    List<Employee> findByNameAndLocation(String name, String location);
    //Search by part of name
    List<Employee> findByNameContaining(String keyword, Sort sort);
    @Query("FROM Employee WHERE name = :name OR location = :location")
    List<Employee> getEmployeesByNameOrLocation(String name,String location);
    @Transactional
    @Modifying
    @Query("DELETE Employee WHERE name = :name")
    int deleteEmployeeByName(String name);
    List<Employee> findByDepartmentId(Long id);

}
