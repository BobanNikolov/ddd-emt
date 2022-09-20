package org.emt.project.appointmentmanagement.domain.model;

import org.emt.project.sharedkernel.domain.base.DomainObjectId;

public class AppointmentItemId extends DomainObjectId {

  public AppointmentItemId() {
    super(AppointmentItemId.randomId(AppointmentItemId.class).getId());
  }

  public AppointmentItemId(String uuid) {
    super(uuid);
  }
}
