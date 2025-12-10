
package com.Hospital.Management.System.Hospital.Management.System.controller;

import java.net.URI;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.Hospital.Management.System.Hospital.Management.System.model.Doctor;
import com.Hospital.Management.System.Hospital.Management.System.service.DoctorService;

@RestController
@RequestMapping("api/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    public DoctorController(DoctorService service) {
        this.doctorService = service;
    }
    @PostMapping
    public ResponseEntity<Doctor> create(@RequestBody Doctor doctor) {
        Doctor saved = doctorService.create(doctor);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(saved.getId())
                        .toUri();

        return ResponseEntity.created(location).body(saved);
    }

    @GetMapping
    public List<Doctor>getAll(){
        return doctorService.getAll();
    }

    @GetMapping("/{id}")
    public Doctor getById(@PathVariable Long id){
        return doctorService.getById(id);
    }

    @PutMapping("/{id}")
    public Doctor update(@PathVariable Long id, @RequestBody Doctor doctor){
        return doctorService.update(id, doctor);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        doctorService.delete(id);
    }
    




}
