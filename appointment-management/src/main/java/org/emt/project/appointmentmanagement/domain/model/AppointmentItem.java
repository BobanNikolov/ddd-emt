package org.emt.project.appointmentmanagement.domain.model;

import lombok.Getter;
import org.emt.project.appointmentmanagement.domain.valueobjects.PetId;
import org.emt.project.sharedkernel.domain.base.AbstractEntity;
import org.emt.project.sharedkernel.domain.base.DomainObjectId;
import org.emt.project.sharedkernel.domain.financial.Money;
import org.springframework.lang.NonNull;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "appointment_item")
@Getter
public class AppointmentItem extends AbstractEntity<AppointmentItemId> {

  private Money itemPrice;

  @Column(name = "qty", nullable = false)
  private int quantity;

  @AttributeOverride(name = "id", column = @Column(name = "product_id", nullable = false))
  private PetId petId;

  private AppointmentItem() {
    super(DomainObjectId.randomId(AppointmentItemId.class));
  }

  public AppointmentItem(@NonNull PetId petId, @NonNull Money itemPrice, int qty) {
    super(DomainObjectId.randomId(AppointmentItemId.class));
    this.petId = petId;
    this.itemPrice = itemPrice;
    this.quantity = qty;
  }

  public Money subtotal() {
    return itemPrice.multiply(quantity);
  }
}
