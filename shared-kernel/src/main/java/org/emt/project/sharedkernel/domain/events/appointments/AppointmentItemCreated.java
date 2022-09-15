package org.emt.project.sharedkernel.domain.events.appointments;

import lombok.Getter;
import org.emt.project.sharedkernel.domain.config.TopicHolder;
import org.emt.project.sharedkernel.domain.events.DomainEvent;

@Getter
public class AppointmentItemCreated extends DomainEvent {

    private String productId;
    private int quantity;

    public AppointmentItemCreated(String topic) {
        super(TopicHolder.TOPIC_APPOINTMENT_ITEM_CREATED);
    }

    public AppointmentItemCreated(String productId, int quantity) {
        super(TopicHolder.TOPIC_APPOINTMENT_ITEM_CREATED);
        this.productId = productId;
        this.quantity = quantity;
    }
}
