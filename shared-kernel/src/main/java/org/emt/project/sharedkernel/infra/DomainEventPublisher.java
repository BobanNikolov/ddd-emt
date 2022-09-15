package org.emt.project.sharedkernel.infra;

import org.emt.project.sharedkernel.domain.events.DomainEvent;

public interface DomainEventPublisher {
    void publish(DomainEvent event);
}
