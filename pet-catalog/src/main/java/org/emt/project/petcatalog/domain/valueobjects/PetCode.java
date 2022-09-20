package org.emt.project.petcatalog.domain.valueobjects;

import org.emt.project.sharedkernel.domain.base.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
public class PetCode implements ValueObject {
  private String code;

  public PetCode(String code) {
    this.code = code;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }
}
