    package in.springrestapi.Controllers;


    import in.springrestapi.Models.Employee;
    import in.springrestapi.Services.IEmployeeService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.beans.factory.annotation.Value;
    import org.springframework.stereotype.Controller;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;


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
        public String getEmployee(@PathVariable int id) {
            return "employee with id : " + id;
        }

        @PostMapping("/employees")
        public String addEmployee(@RequestBody Employee employee) {
            return employee.toString();
        }

        @PutMapping("/employees/{id}")
        public Employee editEmployee(@PathVariable int id, @RequestBody Employee employee) {
            System.out.println("Update employee with id: " + id);
            return employee;
        }


        // DELETE : /api/employees?id=1&name=Mustafa
        @DeleteMapping("/employees")
        public String deleteEmployee(@RequestParam int id, @RequestParam String name) {
            return "employee with id: " + id + " and name: " + name;
        }

    }
