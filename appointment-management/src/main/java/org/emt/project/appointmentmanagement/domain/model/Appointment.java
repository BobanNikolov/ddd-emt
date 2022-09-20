package org.emt.project.appointmentmanagement.domain.model;

import lombok.Getter;
import lombok.NonNull;
import org.emt.project.appointmentmanagement.domain.valueobjects.Pet;
import org.emt.project.sharedkernel.domain.base.AbstractEntity;
import org.emt.project.sharedkernel.domain.financial.Currency;
import org.emt.project.sharedkernel.domain.financial.Money;

import javax.persistence.*;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="appointments")
@Getter
public class Appointment extends AbstractEntity<AppointmentId> {
  private Instant appointmentScheduledOn;

  @Enumerated(EnumType.STRING)
  private AppointmentState appointmentState;

  @Column(name="appointment_currency")
  @Enumerated(EnumType.STRING)
  private Currency currency;


  @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.EAGER)
  private Set<AppointmentItem> appointmentItems = new HashSet<>();

  private Appointment() {
    super(AppointmentId.randomId(AppointmentId.class));
  }

  public Appointment(Instant now, Currency currency) {
    super(AppointmentId.randomId(AppointmentId.class));
    this.appointmentScheduledOn = now;
    this.currency = currency;
  }

  public Money total() {
    return appointmentItems.stream().map(AppointmentItem::subtotal).reduce(new Money(currency, 0), Money::add);
  }

  public AppointmentItem addItem(@NonNull Pet pet, int qty) {
    Objects.requireNonNull(pet,"pet must not be null");
    var item  = new AppointmentItem(pet.getId(),pet.getPrice(),qty);
    appointmentItems.add(item);
    return item;
  }

  public void removeItem(@NonNull AppointmentItemId appointmentItemId) {
    Objects.requireNonNull(appointmentItemId,"Appointment Item must not be null");
    appointmentItems.removeIf(v->v.getId().equals(appointmentItemId));
  }
}
