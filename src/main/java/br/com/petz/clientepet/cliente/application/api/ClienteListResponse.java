package br.com.petz.clientepet.cliente.application.api;

import jakarta.validation.constraints.NotBlank;
import lombok.Value;

import java.util.UUID;
@Value
public class ClienteListResponse {
    private UUID idCliente;
    private String nomeCompleto;
    private String cpf;
    private String celular;
    private String email;
}
