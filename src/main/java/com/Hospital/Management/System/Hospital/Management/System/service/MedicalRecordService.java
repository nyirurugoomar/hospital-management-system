
package com.Hospital.Management.System.Hospital.Management.System.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.Hospital.Management.System.Hospital.Management.System.model.Patient;


import com.Hospital.Management.System.Hospital.Management.System.model.MedicalRecord;
import com.Hospital.Management.System.Hospital.Management.System.repository.MedicalRecordRepository;
import com.Hospital.Management.System.Hospital.Management.System.repository.PatientRepository;

@Service
public class MedicalRecordService {

    private final MedicalRecordRepository medicalRecordRepository;
    private final PatientRepository patientRepository;

    public MedicalRecordService(
            MedicalRecordRepository medicalRecordRepository,
            PatientRepository patientRepository) {
        this.medicalRecordRepository = medicalRecordRepository;
        this.patientRepository = patientRepository;
    }

   public MedicalRecord create(MedicalRecord medicalRecord, Long patientId) {

    Patient patient = patientRepository.findById(patientId)
            .orElseThrow(() -> new RuntimeException("Patient not found"));

    medicalRecord.setPatient(patient);

    return medicalRecordRepository.save(medicalRecord);
}

    public List<MedicalRecord> getAll() {
        return medicalRecordRepository.findAll();
    }

    public MedicalRecord getById(Long id) {
        return medicalRecordRepository.findById(id).orElse(null);
    }

    public MedicalRecord update(Long id, MedicalRecord medicalRecord) {
    MedicalRecord existing = getById(id);
    if (existing == null) return null;

    existing.setDiagnosis(medicalRecord.getDiagnosis());
    existing.setTreatment(medicalRecord.getTreatment());

    if (medicalRecord.getPatient() != null && medicalRecord.getPatient().getId() != null) {
        Patient patient = patientRepository.findById(medicalRecord.getPatient().getId())
                .orElseThrow(() -> new RuntimeException("Patient not found"));
        existing.setPatient(patient);
    } else {
        // if you want to remove the relation when incoming patient is null:
        existing.setPatient(null);
    }

    return medicalRecordRepository.save(existing);
}

    public void delete(Long id) {
        medicalRecordRepository.deleteById(id);
    }

}
