package org.emt.project.petcatalog.xport.events;

import lombok.AllArgsConstructor;
import org.emt.project.petcatalog.domain.models.PetId;
import org.emt.project.petcatalog.services.PetService;
import org.emt.project.sharedkernel.domain.config.TopicHolder;
import org.emt.project.sharedkernel.domain.events.DomainEvent;
import org.emt.project.sharedkernel.domain.events.appointments.AppointmentItemCreated;
import org.emt.project.sharedkernel.domain.events.appointments.AppointmentItemRemoved;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PetEventListener {
  private final PetService petService;

  @KafkaListener(topics = TopicHolder.TOPIC_APPOINTMENT_ITEM_CREATED, groupId = "petCatalog")
  public void consumeAppointmentItemCreatedEvent(String jsonMessage) {
    try {
      AppointmentItemCreated event = DomainEvent.fromJson(jsonMessage, AppointmentItemCreated.class);
      petService.appointmentItemCreated(PetId.of(event.getPetId()));
    } catch (Exception e) {
    }
  }

  @KafkaListener(topics = TopicHolder.TOPIC_APPOINTMENT_ITEM_REMOVED, groupId = "petCatalog")
  public void consumeAppointmentItemRemovedEvent(String jsonMessage) {
    try {
      AppointmentItemRemoved event = DomainEvent.fromJson(jsonMessage, AppointmentItemRemoved.class);
      petService.petItemRemoved(PetId.of(event.getProductId()));
    } catch (Exception e) {
    }
  }
}
