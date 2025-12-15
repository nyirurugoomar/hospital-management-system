
package com.Hospital.Management.System.Hospital.Management.System.controller;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Hospital.Management.System.Hospital.Management.System.model.MedicalRecord;

import com.Hospital.Management.System.Hospital.Management.System.service.MedicalRecordService;

@RestController
@RequestMapping("api/medical-records")
public class MedicalRecordController {

    private final MedicalRecordService service;

    public MedicalRecordController(MedicalRecordService service) {
        this.service = service;
    }


    @PostMapping("/patient/{patientId}")
    public MedicalRecord create(
            @RequestBody MedicalRecord medicalRecord,
            @PathVariable Long patientId
    ) {
        return service.create(medicalRecord, patientId);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public List<MedicalRecord> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public MedicalRecord getById (@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public MedicalRecord update(@PathVariable Long id, @RequestBody MedicalRecord medicalRecord) {
        return service.update(id, medicalRecord);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

}
