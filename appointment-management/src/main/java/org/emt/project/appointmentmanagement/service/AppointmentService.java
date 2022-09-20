package org.emt.project.appointmentmanagement.service;

import org.emt.project.appointmentmanagement.domain.exceptions.AppointmentIdDoesNotExist;
import org.emt.project.appointmentmanagement.domain.exceptions.AppointmentItemIdDoesNotExist;
import org.emt.project.appointmentmanagement.domain.model.Appointment;
import org.emt.project.appointmentmanagement.domain.model.AppointmentId;
import org.emt.project.appointmentmanagement.domain.model.AppointmentItemId;
import org.emt.project.appointmentmanagement.service.forms.AppointmentForm;
import org.emt.project.appointmentmanagement.service.forms.AppointmentItemForm;

import java.util.List;
import java.util.Optional;

public interface AppointmentService {
  AppointmentId placeAppointment(AppointmentForm appointmentForm);

  List<Appointment> findAll();

  Optional<Appointment> findById(AppointmentId id);

  void addItem(AppointmentId appointmentId, AppointmentItemForm appointmentItemForm) throws AppointmentIdDoesNotExist;

  void deleteItem(AppointmentId appointmentId, AppointmentItemId appointmentItemId) throws AppointmentIdDoesNotExist, AppointmentItemIdDoesNotExist;
}
