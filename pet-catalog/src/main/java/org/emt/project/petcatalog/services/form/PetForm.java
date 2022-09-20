package org.emt.project.petcatalog.services.form;

import lombok.Data;
import org.emt.project.petcatalog.domain.valueobjects.PetCode;
import org.emt.project.petcatalog.domain.valueobjects.PetType;
import org.emt.project.sharedkernel.domain.financial.Money;

@Data
public class PetForm {
  private String petName;
  private Money price;
  private PetCode petCode;
  private PetType petType;
  private int appointments;
}
