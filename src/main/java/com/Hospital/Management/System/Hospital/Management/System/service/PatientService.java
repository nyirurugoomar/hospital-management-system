
package com.Hospital.Management.System.Hospital.Management.System.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Hospital.Management.System.Hospital.Management.System.model.Patient;
import com.Hospital.Management.System.Hospital.Management.System.repository.PatientRepository;

@Service
public class PatientService {
    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public PatientRepository getPatientRepository() {
        return patientRepository;
    }

    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }
    public List<Patient> getAll() {
        return patientRepository.findAll();
    }

    public Patient getById(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    public Patient update(Long id, Patient patient) {
    Patient existing = getById(id);

    if (existing == null) return null;

    existing.setFullName(patient.getFullName());
    existing.setAge(patient.getAge());
    existing.setGender(patient.getGender());
    existing.setPhone(patient.getPhone());

    return patientRepository.save(existing);
}
    public void delete(Long id) {
        patientRepository.deleteById(id);
    }

}
