
package com.Hospital.Management.System.Hospital.Management.System.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Hospital.Management.System.Hospital.Management.System.model.MedicalRecord;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalRecordRepository extends JpaRepository<MedicalRecord, Long> {

}
