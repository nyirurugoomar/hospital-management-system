
package com.Hospital.Management.System.Hospital.Management.System.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Hospital.Management.System.Hospital.Management.System.model.Doctor;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {


}
