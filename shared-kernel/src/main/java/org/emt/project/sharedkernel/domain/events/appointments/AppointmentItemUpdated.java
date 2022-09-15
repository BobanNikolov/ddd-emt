package org.emt.project.sharedkernel.domain.events.appointments;

import lombok.Getter;
import org.emt.project.sharedkernel.domain.config.TopicHolder;
import org.emt.project.sharedkernel.domain.events.DomainEvent;

@Getter
public class AppointmentItemUpdated extends DomainEvent {
  private String productId;
  private int quantity;

  public AppointmentItemUpdated(String topic) {
    super(TopicHolder.TOPIC_APPOINTMENT_ITEM_UPDATED);
  }

  public AppointmentItemUpdated(String topic, String productId, int quantity) {
    super(TopicHolder.TOPIC_APPOINTMENT_ITEM_UPDATED);
    this.productId = productId;
    this.quantity = quantity;
  }
}
