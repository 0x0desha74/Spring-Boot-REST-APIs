package in.springrestapi.Repositories;

import in.springrestapi.Models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Long> {
    //Search by name
    List<Employee> findByName(String name);
    //Search by name and location
    List<Employee> findByNameAndLocation(String name, String location);
    //Search by part of name
    List<Employee> findByNameContaining(String keyword);


}
