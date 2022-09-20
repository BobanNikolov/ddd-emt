package org.emt.project.appointmentmanagement.domain.valueobjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import org.emt.project.sharedkernel.domain.base.ValueObject;
import org.emt.project.sharedkernel.domain.financial.Currency;
import org.emt.project.sharedkernel.domain.financial.Money;

@Getter
public class Pet implements ValueObject {
  private final PetId id;
  private final String name;
  private final PetType petType;
  private final Money price;
  private final int sales;

  private Pet() {
    this.id=PetId.randomId(PetId.class);
    this.name= "";
    this.petType = PetType.DOG;
    this.price = Money.valueOf(Currency.MKD,0);
    this.sales = 0;
  }

  @JsonCreator
  public Pet(@JsonProperty("id") PetId id,
                 @JsonProperty("productName") String name,
                 @JsonProperty("petType") PetType petType,
                 @JsonProperty("price") Money price,
                 @JsonProperty("sales") int sales) {
    this.id = id;
    this.name = name;
    this.petType = petType;
    this.price = price;
    this.sales = sales;
  }
}
