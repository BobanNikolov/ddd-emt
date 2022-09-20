package org.emt.project.sharedkernel.domain.events.appointments;

import lombok.Getter;
import org.emt.project.sharedkernel.domain.config.TopicHolder;
import org.emt.project.sharedkernel.domain.events.DomainEvent;

@Getter
public class AppointmentItemCreated extends DomainEvent {

    private String petId;
    private int quantity;

    public AppointmentItemCreated(String topic) {
        super(TopicHolder.TOPIC_APPOINTMENT_ITEM_CREATED);
    }

    public AppointmentItemCreated(String petId, int quantity) {
        super(TopicHolder.TOPIC_APPOINTMENT_ITEM_CREATED);
        this.petId = petId;
        this.quantity = quantity;
    }
}
