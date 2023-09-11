package br.com.petz.clientepet.cliente.application.api;

import br.com.petz.clientepet.cliente.domain.Cliente;
import lombok.Value;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Value
public class ClienteListResponse {
    private UUID idCliente;
    private String nomeCompleto;
    private String cpf;
    private String celular;
    private String email;

    public static List<ClienteListResponse> converte(List<Cliente> clientes) {
        return clientes.stream()
                .map(c -> new ClienteListResponse(c))
                .collect(Collectors.toList());
    }

    public ClienteListResponse(Cliente cliente) {
        this.idCliente = cliente.getIdCliente();
        this.nomeCompleto = cliente.getNomeCompleto();
        this.cpf = cliente.getCpf();
        this.celular = cliente.getCelular();
        this.email = cliente.getEmail();
    }
}
