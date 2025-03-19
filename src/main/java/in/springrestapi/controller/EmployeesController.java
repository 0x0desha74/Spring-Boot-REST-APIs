    package in.springrestapi.controller;
    import in.springrestapi.model.Department;
    import in.springrestapi.model.Employee;
    import in.springrestapi.repository.DepartmentRepository;
    import in.springrestapi.repository.EmployeeRepository;
    import in.springrestapi.request.EmployeeRequest;
    import in.springrestapi.service.EmployeeService;
    import jakarta.validation.Valid;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;
    import java.util.List;


    @RestController
    ///@Controller + @ResponseBody

    public class EmployeesController {
        @Autowired
        private EmployeeService eService;
        @Autowired
        private DepartmentRepository dRepo;
        @Autowired
        private EmployeeRepository eRepo;

        //GET : /api/v1/employees
        @GetMapping("/employees")
        public ResponseEntity<List<Employee>> getEmployees( @RequestParam(required = false) String name,@RequestParam int pageNumber,@RequestParam int pageSize) {
            if(name == null || name.isEmpty()){
                return new ResponseEntity<>(eService.getEmployees(pageNumber,pageSize),HttpStatus.OK);
            }
                return new ResponseEntity<>(eService.getEmployeesByKeyword(name),HttpStatus.OK);
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

        @GetMapping("employees/filterByKeyword")
        public ResponseEntity<List<Employee>> getEmployeesByPartOfName(@RequestParam String name)
        {
            return new ResponseEntity<>(eService.getEmployeesByKeyword(name),HttpStatus.OK);
        }


        @GetMapping("employees/filter")
        public ResponseEntity<List<Employee>> getEmployeeByNameOrLocation(@RequestParam String name,@RequestParam String location){
            return new ResponseEntity<>(eService.getEmployeesByNameOrLocation(name,location),HttpStatus.OK);
        }

        @GetMapping("employees/filterByDepartment")
        public ResponseEntity<List<Employee>> getEmployeeByDepartmentName(@RequestParam String department){
            return new ResponseEntity<>(eRepo.findByDepartmentName(department),HttpStatus.OK);
        }



        //POST : /api/v1/employees
        @PostMapping("/employees")
        public ResponseEntity<Employee> addEmployee( @RequestBody @Valid EmployeeRequest employeeReq) {
            var department = new Department();
            department.setName(employeeReq.getDepartment());
           department= dRepo.save(department);
            Employee employee = new Employee(employeeReq);
            employee.setDepartment(department);
            employee =  eRepo.save(employee);
            return new ResponseEntity<>( employee,HttpStatus.CREATED);
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


        @DeleteMapping("employees/delete")
        public ResponseEntity<String> deleteByName(@RequestParam String name){
            return new ResponseEntity<>(eService.deleteEmployeeByName(name)+ "Deleted Records",HttpStatus.NO_CONTENT);
        }

    }
