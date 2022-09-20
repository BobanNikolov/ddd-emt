package org.emt.project.appointmentmanagement.domain.model;

import lombok.NonNull;
import org.emt.project.sharedkernel.domain.base.DomainObjectId;

public class AppointmentId extends DomainObjectId {

  private AppointmentId() {
    super(AppointmentId.randomId(AppointmentId.class).getId());
  }

  public AppointmentId(@NonNull String uuid) {
    super(uuid);
  }
}
