package org.emt.project.petcatalog.domain.repository;

import org.emt.project.petcatalog.domain.models.Pet;
import org.emt.project.petcatalog.domain.models.PetId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, PetId> {
}
