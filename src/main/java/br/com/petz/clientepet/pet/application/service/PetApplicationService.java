package br.com.petz.clientepet.pet.application.service;


import br.com.petz.clientepet.cliente.application.service.ClienteService;
import br.com.petz.clientepet.pet.application.api.PetListResponse;
import br.com.petz.clientepet.pet.application.api.PetRequest;
import br.com.petz.clientepet.pet.application.api.PetResponse;
import br.com.petz.clientepet.pet.application.repository.PetRepository;
import br.com.petz.clientepet.pet.domain.Pet;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Log4j2
@Service
@RequiredArgsConstructor
public class PetApplicationService implements PetService {
    private final PetRepository petRepository;
    private final ClienteService clienteService;
    @Override
    public PetResponse criaPet(UUID idCliente, PetRequest petRequest) {
        log.info("[inicia] PetApplicationService - criaPet");
        clienteService.buscaClienteAtravesDoId(idCliente);
        Pet pet = petRepository.salvaPet(new Pet(idCliente, petRequest));
        log.info("[finaliza] PetApplicationService - criaPet");
        return PetResponse.builder()
                .idPet(pet.getIdPet())
                .build();
    }

    @Override
    public List<PetListResponse> buscaPetsDoClienteComId(UUID idCliente) {
        log.info("[inicia] PetApplicationService - buscaPetsDoClienteComId");
        clienteService.buscaClienteAtravesDoId(idCliente);
        List<Pet> listaPet = petRepository.listaTodosPet(idCliente);
        log.info("[finaliza] PetApplicationService - buscaPetsDoClienteComId");
        return PetListResponse.converte(listaPet);
    }
}
