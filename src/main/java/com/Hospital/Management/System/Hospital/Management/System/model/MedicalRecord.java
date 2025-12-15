
package com.Hospital.Management.System.Hospital.Management.System.model;
import jakarta.persistence.*;
import lombok.*;




@Entity
@Table(name = "medical_records")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MedicalRecord {
  
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String diagnosis;
    private String treatment;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", nullable = true)
    private Patient patient;

}
