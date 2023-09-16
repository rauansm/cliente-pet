package br.com.petz.clientepet.pet.application.service;

import br.com.petz.clientepet.pet.application.api.*;

import java.util.List;
import java.util.UUID;

public interface PetService {

    PetResponse criaPet(UUID idCliente, PetRequest petRequest);

    List<PetListResponse> buscaPetsDoClienteComId(UUID idCliente);

    PetDetalhadoResponse buscaPetDoCliente(UUID idCliente, UUID idPet);

    void deletaPetDoCliente(UUID idCliente, UUID idPet);

    void alteraPet(UUID idCliente, UUID idPet, PetAlteracaoRequest petAlteracaoRequest);
}
