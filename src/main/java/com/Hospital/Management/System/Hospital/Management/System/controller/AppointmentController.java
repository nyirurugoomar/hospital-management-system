
package com.Hospital.Management.System.Hospital.Management.System.controller;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Hospital.Management.System.Hospital.Management.System.model.Appointment;
import com.Hospital.Management.System.Hospital.Management.System.service.AppointmentService;

@RestController
@RequestMapping("api/appointments")
public class AppointmentController {

    private final AppointmentService service;

    public AppointmentController(AppointmentService service) {
        this.service = service;
    }


    @PostMapping("/{patientId}/{doctorId}")
public Appointment create(
        @RequestBody Appointment appointment,
        @PathVariable Long patientId,
        @PathVariable Long doctorId
) {
    return service.create(appointment, patientId, doctorId);
}

    @GetMapping
    public List<Appointment> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Appointment getById(@PathVariable Long id) {
        return service.getAppointmentById(id);
    }

    @PutMapping("/{id}")
    public Appointment update(
            @PathVariable Long id,
            @RequestBody Appointment appointment
    ) {
        return service.updateAppointment(id, appointment); 
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteAppointment(id);
    }

    

    

}
