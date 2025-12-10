package com.Hospital.Management.System.Hospital.Management.System.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Hospital.Management.System.Hospital.Management.System.model.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

}
