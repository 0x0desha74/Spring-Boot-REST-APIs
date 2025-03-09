    package in.springrestapi.Controllers;


    import in.springrestapi.Models.Employee;
    import org.springframework.stereotype.Controller;
    import org.springframework.web.bind.annotation.*;


    @RestController ///@Controller + @ResponseBody
    @RequestMapping(value = "/api")
    public class EmployeesController {

        //GET : /api/employees
        @GetMapping( "/employees")
        public String getEmployees() {
            return "List of employees";
        }

        //GET : /api/employee/1

    @GetMapping("/employees/{id}")
        public String getEmployee(@PathVariable int id){
            return "employee with id : " + id;
    }

    @PostMapping("/employees")
    public String addEmployee(@RequestBody Employee employee){
            return  employee.toString();
    }

        @PutMapping("/employees")
        public Employee editEmployee(@RequestBody Employee employee){
            return  employee;
        }


    // DELETE : /api/employees?id=1&name=Mustafa
    @DeleteMapping("/employees")
    public String deleteEmployee(@RequestParam int id,@RequestParam String name ){
            return "employee with id: " + id + " and name: " + name ;
    }

    }
