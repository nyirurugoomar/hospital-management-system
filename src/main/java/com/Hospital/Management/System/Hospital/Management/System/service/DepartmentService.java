

package com.Hospital.Management.System.Hospital.Management.System.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Hospital.Management.System.Hospital.Management.System.model.Department;
import com.Hospital.Management.System.Hospital.Management.System.repository.DepartmentRepository;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public Department create(Department department) {
        return departmentRepository.save(department);
    }

    public List<Department> getAll() {
        return departmentRepository.findAll();
    }

    public Department getById(Long id) {
        return departmentRepository.findById(id).orElse(null);
    }

    public Department update(Long id, Department department) {
        Department existing = getById(id);

        if (existing == null) return null;

        existing.setName(department.getName());
        return departmentRepository.save(existing);
    }

    public void delete(Long id) {
        departmentRepository.deleteById(id);
    }

}
