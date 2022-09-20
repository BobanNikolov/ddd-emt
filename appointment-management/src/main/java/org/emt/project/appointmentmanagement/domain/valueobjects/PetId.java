package org.emt.project.appointmentmanagement.domain.valueobjects;

import org.emt.project.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;

@Embeddable
public class PetId extends DomainObjectId {
  private PetId() {
    super(PetId.randomId(PetId.class).getId());
  }

  public PetId(String uuid) {
    super(uuid);
  }
}
