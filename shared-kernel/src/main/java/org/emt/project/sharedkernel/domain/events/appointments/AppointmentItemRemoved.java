package org.emt.project.sharedkernel.domain.events.appointments;

import lombok.Getter;
import org.emt.project.sharedkernel.domain.config.TopicHolder;
import org.emt.project.sharedkernel.domain.events.DomainEvent;

@Getter
public class AppointmentItemRemoved extends DomainEvent {

    private String productId;
    private int quantity;

    public AppointmentItemRemoved(String topic) {
        super(TopicHolder.TOPIC_APPOINTMENT_ITEM_REMOVED);
    }

    public AppointmentItemRemoved(String topic, String productId, int quantity) {
        super(TopicHolder.TOPIC_APPOINTMENT_ITEM_REMOVED);
        this.productId = productId;
        this.quantity = quantity;
    }
}
