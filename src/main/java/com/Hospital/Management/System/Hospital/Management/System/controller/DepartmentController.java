
package com.Hospital.Management.System.Hospital.Management.System.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Hospital.Management.System.Hospital.Management.System.model.Department;
import com.Hospital.Management.System.Hospital.Management.System.service.DepartmentService;

import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("api/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService service) {
        this.departmentService = service;
    }

        @GetMapping
        public List<Department> getAll() {
            return departmentService.getAll();
        }

        @PostMapping
        public Department create(@RequestBody Department department) {
            return departmentService.create(department);
        }

        @GetMapping("/{id}")
        public Department getById(@PathVariable Long id){
            return departmentService.getById(id);
        }

        @PutMapping("/{id}")
        public Department update(@PathVariable Long id,@RequestBody Department department) {
            return departmentService.update(id, department);
        }

        @DeleteMapping("/{id}")
        public void delete(@PathVariable Long id) {
            departmentService.delete(id);
        }
        

}
