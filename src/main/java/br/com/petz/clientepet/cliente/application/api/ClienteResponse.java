package br.com.petz.clientepet.cliente.application.api;

import lombok.Value;
import org.hibernate.validator.constraints.UUID;
@Value
public class ClienteResponse {
    private UUID idCliente;
}
