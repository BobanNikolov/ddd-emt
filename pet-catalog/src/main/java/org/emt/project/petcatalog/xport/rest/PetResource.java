package org.emt.project.petcatalog.xport.rest;

import lombok.AllArgsConstructor;
import org.emt.project.petcatalog.domain.models.Pet;
import org.emt.project.petcatalog.services.PetService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pet")
@AllArgsConstructor
public class PetResource {
  private final PetService petService;

  @GetMapping
  public List<Pet> getAll() {
    return petService.getAll();
  }
}
