package org.emt.project.appointmentmanagement.domain.repository;

import org.emt.project.appointmentmanagement.domain.model.Appointment;
import org.emt.project.appointmentmanagement.domain.model.AppointmentId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, AppointmentId> {
}
