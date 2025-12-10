
package com.Hospital.Management.System.Hospital.Management.System.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Hospital.Management.System.Hospital.Management.System.model.Appointment;
import com.Hospital.Management.System.Hospital.Management.System.model.Doctor;
import com.Hospital.Management.System.Hospital.Management.System.model.Patient;
import com.Hospital.Management.System.Hospital.Management.System.repository.AppointmentRepository;
import com.Hospital.Management.System.Hospital.Management.System.repository.DoctorRepository;
import com.Hospital.Management.System.Hospital.Management.System.repository.PatientRepository;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepo;
    private final DoctorRepository doctorRepo;


    public AppointmentService(AppointmentRepository appointmentRepository, PatientRepository patientRepo, DoctorRepository doctorRepo) {
        this.appointmentRepository = appointmentRepository;
        this.patientRepo = patientRepo;
        this.doctorRepo = doctorRepo;
    }

    public List<Appointment> getAll() {
        return appointmentRepository.findAll();
    }

   public Appointment create(Appointment appointment, Long patientId, Long doctorId) {
    // Fetch patient and doctor from DB
    Patient patient = patientRepo.findById(patientId)
            .orElseThrow(() -> new RuntimeException("Patient not found with id " + patientId));

    Doctor doctor = doctorRepo.findById(doctorId)
            .orElseThrow(() -> new RuntimeException("Doctor not found with id " + doctorId));

    // Set them to the appointment
    appointment.setPatient(patient);
    appointment.setDoctor(doctor);

    // Save
    return appointmentRepository.save(appointment);
}

    public Appointment getAppointmentById(Long id) {
        return appointmentRepository.findById(id).orElse(null);
    }


    public Appointment updateAppointment(Long id, Appointment appointment) {
        Appointment existing = getAppointmentById(id);

        if (existing == null) return null;

        existing.setAppointmentDate(appointment.getAppointmentDate());
        existing.setPatient(appointment.getPatient());
        existing.setDoctor(appointment.getDoctor());

        return appointmentRepository.save(existing);
    }
    public void deleteAppointment(Long id) {
        appointmentRepository.deleteById(id);
    }

}
