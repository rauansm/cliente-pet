package br.com.petz.clientepet.pet.application.infra;

import br.com.petz.clientepet.pet.application.repository.PetRepository;
import br.com.petz.clientepet.pet.domain.Pet;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

@Repository
@Log4j2
@RequiredArgsConstructor
public class PetRepositoryInfra implements PetRepository {
    private final PetSpringData petSpringData;

    @Override
    public Pet salvaPet(Pet pet) {
        log.info("[inicia] PetRepositoryInfra - salvaPet");
        petSpringData.save(pet);
        log.info("[finaliza] PetRepositoryInfra - salvaPet");
        return pet;
    }
}
