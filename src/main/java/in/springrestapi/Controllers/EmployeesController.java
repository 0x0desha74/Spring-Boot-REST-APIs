    package in.springrestapi.Controllers;


    import in.springrestapi.Models.Employee;
    import org.springframework.beans.factory.annotation.Value;
    import org.springframework.stereotype.Controller;
    import org.springframework.web.bind.annotation.*;


    @RestController
    ///@Controller + @ResponseBody
    @RequestMapping(value = "/api")
    public class EmployeesController {

        //GET : /api/employees
        @GetMapping("/employees")
        public String getEmployees() {
            return "List of employees";
        }

        @Value("${app.name}")
        private String appName;
        @Value("${app.version}")
        private String appVersion;

        @GetMapping("/version")
        public String getVersion() {
            return appName + " - " + appVersion;
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
