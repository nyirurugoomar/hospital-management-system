
package com.Hospital.Management.System.Hospital.Management.System.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Hospital.Management.System.Hospital.Management.System.model.Department;
import com.Hospital.Management.System.Hospital.Management.System.model.Doctor;
import com.Hospital.Management.System.Hospital.Management.System.repository.DepartmentRepository;
import com.Hospital.Management.System.Hospital.Management.System.repository.DoctorRepository;

@Service
public class DoctorService {
  private final DoctorRepository doctorRepo;
    private final DepartmentRepository departmentRepo;

    public DoctorService(DoctorRepository doctorRepo, DepartmentRepository departmentRepo) {
        this.doctorRepo = doctorRepo;
        this.departmentRepo = departmentRepo;
    }

    public Doctor create(Doctor doctor) {
        Long deptId = doctor.getDepartment().getId();

        Department department = departmentRepo.findById(deptId)
                .orElseThrow(() -> new RuntimeException("Department not found"));

        doctor.setDepartment(department);
        return doctorRepo.save(doctor);
    }

    public List<Doctor> getAll() {
        return doctorRepo.findAll();
    }

    public Doctor getById(Long id) {
        return doctorRepo.findById(id).orElse(null);
    }

    public Doctor update(Long id, Doctor doctor) {
        Doctor existing = getById(id);

        if (existing == null) return null;

        existing.setName(doctor.getName());
        existing.setSpecialization(doctor.getSpecialization());

        if (doctor.getDepartment() != null) {
            Department department = departmentRepo.findById(doctor.getDepartment().getId())
                    .orElseThrow(() -> new RuntimeException("Department not found"));
            existing.setDepartment(department);
        }

        return doctorRepo.save(existing);
    }

    public void delete(Long id) {
        doctorRepo.deleteById(id);
    }
    

}
