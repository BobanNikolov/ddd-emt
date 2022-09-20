package org.emt.project.appointmentmanagement.service.impl;

import lombok.AllArgsConstructor;
import org.emt.project.appointmentmanagement.domain.exceptions.AppointmentIdDoesNotExist;
import org.emt.project.appointmentmanagement.domain.exceptions.AppointmentItemIdDoesNotExist;
import org.emt.project.appointmentmanagement.domain.model.Appointment;
import org.emt.project.appointmentmanagement.domain.model.AppointmentId;
import org.emt.project.appointmentmanagement.domain.model.AppointmentItemId;
import org.emt.project.appointmentmanagement.domain.repository.AppointmentRepository;
import org.emt.project.appointmentmanagement.service.AppointmentService;
import org.emt.project.appointmentmanagement.service.forms.AppointmentForm;
import org.emt.project.appointmentmanagement.service.forms.AppointmentItemForm;
import org.emt.project.sharedkernel.domain.events.appointments.AppointmentItemCreated;
import org.emt.project.sharedkernel.infra.DomainEventPublisher;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.time.Instant;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

  private final AppointmentRepository appointmentRepository;
  private final DomainEventPublisher domainEventPublisher;
  private final Validator validator;

  @Override
  public AppointmentId placeAppointment(AppointmentForm appointmentForm) {
    Objects.requireNonNull(appointmentForm, "appointment must not be null.");
    var constraintViolations = validator.validate(appointmentForm);
    if (constraintViolations.size() > 0) {
      throw new ConstraintViolationException("The appointment form is not valid", constraintViolations);
    }
    var newAppointment = appointmentRepository.saveAndFlush(toDomainObject(appointmentForm));
    newAppointment.getAppointmentItems().forEach(item -> domainEventPublisher.publish(new AppointmentItemCreated(item.getPetId().getId(), item.getQuantity())));
    return newAppointment.getId();
  }

  @Override
  public List<Appointment> findAll() {
    return appointmentRepository.findAll();
  }

  @Override
  public Optional<Appointment> findById(AppointmentId id) {
    return appointmentRepository.findById(id);
  }

  @Override
  public void addItem(AppointmentId appointmentId, AppointmentItemForm appointmentItemForm) throws AppointmentIdDoesNotExist {
    Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow(AppointmentIdDoesNotExist::new);
    appointment.addItem(appointmentItemForm.getPet(), appointmentItemForm.getQuantity());
    appointmentRepository.saveAndFlush(appointment);
    domainEventPublisher.publish(new AppointmentItemCreated(appointmentItemForm.getPet().getId().getId(), appointmentItemForm.getQuantity()));
  }

  @Override
  public void deleteItem(AppointmentId appointmentId, AppointmentItemId appointmentItemId) throws AppointmentIdDoesNotExist, AppointmentItemIdDoesNotExist {
    Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow(AppointmentIdDoesNotExist::new);
    appointment.removeItem(appointmentItemId);
    appointmentRepository.saveAndFlush(appointment);
  }

  private Appointment toDomainObject(AppointmentForm appointmentForm) {
    var appointment = new Appointment(Instant.now(), appointmentForm.getCurrency());
    appointmentForm.getItems().forEach(item -> appointment.addItem(item.getPet(), item.getQuantity()));
    return appointment;
  }
}
