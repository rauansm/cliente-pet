package br.com.petz.clientepet.cliente.application.service;

import br.com.petz.clientepet.cliente.application.api.*;

import java.util.List;
import java.util.UUID;

public interface ClienteService {
    ClienteResponse criaCliente(ClienteRequest clienteRequest);

    List<ClienteListResponse> buscaTodosClientes();

    ClienteDetalhadoResponse buscaClienteAtravesDoId (UUID idCliente);

    void deletaClienteAtravesId(UUID idCliente);

    void alteraCliente(UUID idCliente, ClienteAlteracaoRequest clienteAlteracaoRequest);
}
