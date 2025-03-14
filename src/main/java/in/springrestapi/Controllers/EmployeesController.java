    package in.springrestapi.Controllers;


    import in.springrestapi.Models.Employee;
    import in.springrestapi.Services.IEmployeeService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.beans.factory.annotation.Value;
    import org.springframework.stereotype.Controller;
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
        public List<Employee> getEmployees() {
            var employees = eService.getEmployees();
            return employees;
        }


        //GET : /api/employee/1

        @GetMapping("/employees/{id}")
        public Employee getEmployee(@PathVariable Long id) {
            return eService.getEmployee(id);
        }

        @PostMapping("/employees")
        public Employee addEmployee(@RequestBody Employee employee) {
            return eService.SaveEmployee(employee);
        }

        @PutMapping("/employees")
        public Employee editEmployee( @RequestBody Employee model) {

            return eService.updateEmployee(model);

        }


        // DELETE : /api/employees?id=1&name=Mustafa
        @DeleteMapping("/employees")
        public String deleteEmployee(@RequestParam Long id) {
            eService.deleteEmployee(id);
            return "Employee was deleted";
        }

    }
