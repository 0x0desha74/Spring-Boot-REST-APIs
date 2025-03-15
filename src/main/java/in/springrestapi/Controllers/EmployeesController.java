    package in.springrestapi.Controllers;
    import in.springrestapi.Models.Employee;
    import in.springrestapi.Services.IEmployeeService;
    import jakarta.annotation.Nullable;
    import jakarta.validation.Valid;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.HttpStatusCode;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;
    import java.util.List;
    import java.util.Optional;


    @RestController
    ///@Controller + @ResponseBody

    public class EmployeesController {
        @Autowired
        private IEmployeeService eService;



        //GET : /api/employees
        @GetMapping("/employees")
        public ResponseEntity<List<Employee>> getEmployees( @RequestParam(required = false) String name) {
            if(name == null || name.isEmpty()){
                return new ResponseEntity<>(eService.getEmployees(),HttpStatus.OK);
            }
                return new ResponseEntity<>(eService.getEmployeeByName(name),HttpStatus.OK);
        }

        @GetMapping("employees/filterByName")
        public ResponseEntity<List<Employee>> getEmployeesByName(@RequestParam String name) {
            return new ResponseEntity<>(eService.getEmployeeByName(name), HttpStatus.OK);
        }

        @GetMapping("employees/filterByNameAndLocation")
        public ResponseEntity<List<Employee>> getEmployeesByNameAndLocation(@RequestParam String name,@RequestParam String location)
        {
            return new ResponseEntity<>(eService.getEmployeesByNameAndLocation(name,location),HttpStatus.OK);
        }

        //GET : /api/employee/1
        @GetMapping("/employees/{id}")
        public ResponseEntity<Employee> getEmployee( @PathVariable Long id) {
            return new ResponseEntity<>(eService.getEmployee(id),HttpStatus.OK) ;
        }

        @PostMapping("/employees")
        public ResponseEntity<Employee> addEmployee( @RequestBody @Valid Employee employee) {
            return new ResponseEntity<>( eService.SaveEmployee(employee),HttpStatus.CREATED);
        }

        //PUT : /api/v1/employees
        @PutMapping("/employees")
        public ResponseEntity<Employee> editEmployee( @RequestBody @Valid Employee model) {

            return new ResponseEntity<>(eService.updateEmployee(model),HttpStatus.OK);

        }


        // DELETE : /api/employees?id=1
        @DeleteMapping("/employees")
        public ResponseEntity<HttpStatus> deleteEmployee(@RequestParam Long id) {
            eService.deleteEmployee(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

    }
