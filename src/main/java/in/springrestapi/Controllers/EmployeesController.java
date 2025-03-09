package in.springrestapi.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController //@Controller + @ResponseBody
public class EmployeesController {

    //GET : /employees
    @GetMapping(value = "/employees")
    public String getEmployees() {
        return "List of employees";
    }

}
