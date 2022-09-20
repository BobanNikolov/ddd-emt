package org.emt.project.appointmentmanagement.service.forms;

import lombok.Data;
import org.emt.project.appointmentmanagement.domain.valueobjects.Pet;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class AppointmentItemForm {

  @NotNull
  private Pet pet;

  @Min(1)
  private int quantity = 1;
}
