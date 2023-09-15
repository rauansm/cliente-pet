package br.com.petz.clientepet.pet.application.infra;

import br.com.petz.clientepet.pet.application.repository.PetRepository;
import br.com.petz.clientepet.pet.domain.Pet;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

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

    @Override
    public List<Pet> listaTodosPet(UUID idCliente) {
        log.info("[inicia] PetRepositoryInfra - listaTodosPet");
        var pets = petSpringData.findByIdClienteTutor(idCliente);
        log.info("[finaliza] PetRepositoryInfra - listaTodosPet");
        return pets;
    }
}
