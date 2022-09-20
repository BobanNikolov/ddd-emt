package org.emt.project.appointmentmanagement.service.forms;

import lombok.Data;
import org.emt.project.sharedkernel.domain.financial.Currency;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
public class AppointmentForm {
  @NotNull
  private Currency currency;

  @Valid
  @NotEmpty
  private List<AppointmentItemForm> items = new ArrayList<>();
}
