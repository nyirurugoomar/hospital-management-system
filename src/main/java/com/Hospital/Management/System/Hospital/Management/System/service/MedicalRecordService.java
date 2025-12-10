
package com.Hospital.Management.System.Hospital.Management.System.service;

import java.util.List;

import org.springframework.stereotype.Service;

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

    public MedicalRecord create(MedicalRecord medicalRecord) {
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
        existing.setPatient(medicalRecord.getPatient());

        return medicalRecordRepository.save(existing);
    }

    public void delete(Long id) {
        medicalRecordRepository.deleteById(id);
    }

}
