package in.springrestapi.controller;


import in.springrestapi.model.Department;
import in.springrestapi.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService dService;

    @GetMapping("departments")
    public ResponseEntity<List<Department>> getDepartments(){
        return new ResponseEntity<>(dService.getAllDepartments(), HttpStatus.OK);
    }

    @GetMapping("departments/{id}")
    public ResponseEntity<Department> getDepartment(@PathVariable Long id){
        return new ResponseEntity<>(dService.getDepartmentById(id),HttpStatus.OK);
    }


    @PostMapping("departments")
    public ResponseEntity<Department> addDepartment(@RequestBody Department department){
        return new ResponseEntity<>(dService.addDepartment(department),HttpStatus.CREATED);
    }
}
