package org.emt.project.petcatalog.domain.models;

import lombok.Getter;
import org.emt.project.petcatalog.domain.valueobjects.PetCode;
import org.emt.project.petcatalog.domain.valueobjects.PetType;
import org.emt.project.sharedkernel.domain.base.AbstractEntity;
import org.emt.project.sharedkernel.domain.financial.Money;

import javax.persistence.*;

@Entity
@Table(name="pet")
@Getter
public class Pet extends AbstractEntity<PetId> {
  private String petName;

  private int appointments = 0;

  private PetCode petCode;

  private PetType petType;

  @AttributeOverrides({
      @AttributeOverride(name="amount", column = @Column(name="price_amount")),
      @AttributeOverride(name="currency", column = @Column(name="price_currency"))
  })
  private Money price;

  public Pet() {
    super(PetId.randomId(PetId.class));
  }

  public static Pet build(String petName, Money price, int appointments, PetCode petCode, PetType petType) {
    Pet p = new Pet();
    p.price = price;
    p.petName = petName;
    p.appointments = appointments;
    p.petCode = petCode;
    p.petType = petType;
    return p;
  }

  public void addAppointment() {
    this.appointments+=1;
  }

  public void removeAppointment() {
    this.appointments -= 1;
  }
}
