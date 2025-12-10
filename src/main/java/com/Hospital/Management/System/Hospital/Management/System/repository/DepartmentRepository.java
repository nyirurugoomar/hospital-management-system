
package com.Hospital.Management.System.Hospital.Management.System.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.Hospital.Management.System.Hospital.Management.System.model.Department;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
