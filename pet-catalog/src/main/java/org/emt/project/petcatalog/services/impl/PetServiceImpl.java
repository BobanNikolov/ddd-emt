package org.emt.project.petcatalog.services.impl;

import lombok.AllArgsConstructor;
import org.emt.project.petcatalog.domain.exception.PetNotFoundException;
import org.emt.project.petcatalog.domain.models.Pet;
import org.emt.project.petcatalog.domain.models.PetId;
import org.emt.project.petcatalog.domain.repository.PetRepository;
import org.emt.project.petcatalog.services.PetService;
import org.emt.project.petcatalog.services.form.PetForm;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class PetServiceImpl implements PetService {

  private final PetRepository petRepository;

  @Override
  public Pet findById(PetId id) {
    return petRepository.findById(id).orElseThrow(PetNotFoundException::new);
  }

  @Override
  public Pet createPet(PetForm form) {
    Pet p = Pet.build(form.getPetName(), form.getPrice(), form.getAppointments(), form.getPetCode(), form.getPetType());
    petRepository.save(p);
    return p;
  }

  @Override
  public Pet appointmentItemCreated(PetId petId) {
    Pet p = petRepository.findById(petId).orElseThrow(PetNotFoundException::new);
    p.addAppointment();
    return p;
  }

  @Override
  public Pet petItemRemoved(PetId petId) {
    Pet p = petRepository.findById(petId).orElseThrow(PetNotFoundException::new);
    p.removeAppointment();
    return p;
  }

  @Override
  public List<Pet> getAll() {
    return petRepository.findAll();
  }
}
