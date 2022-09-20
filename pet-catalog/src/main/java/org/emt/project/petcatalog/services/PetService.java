package org.emt.project.petcatalog.services;

import org.emt.project.petcatalog.domain.models.Pet;
import org.emt.project.petcatalog.domain.models.PetId;
import org.emt.project.petcatalog.services.form.PetForm;

import java.util.List;

public interface PetService {
  Pet findById(PetId id);
  Pet createPet(PetForm form);
  Pet appointmentItemCreated(PetId petId);
  Pet petItemRemoved(PetId petId);
  List<Pet> getAll();
}
