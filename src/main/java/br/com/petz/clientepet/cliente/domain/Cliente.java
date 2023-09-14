package br.com.petz.clientepet.cliente.domain;


import br.com.petz.clientepet.cliente.application.api.ClienteAlteracaoRequest;
import br.com.petz.clientepet.cliente.application.api.ClienteRequest;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "uuid", name = "idCliente", updatable = false, unique = true, nullable = false)
    private UUID idCliente;
    @NotBlank
    private String nomeCompleto;
    @NotBlank
    @Email
    @Column(unique = true)
    private String email;
    @NotBlank
    private String celular;
    private String telefone;
    @Enumerated(EnumType.STRING)
    private Sexo sexo;
    @NotNull
    private LocalDate dataNascimento;
    @CPF
    @Column(unique = true)
    private String cpf;
    @NotNull
    private Boolean aceitaTermos;
    private LocalDateTime dataHoraDoCadastro;
    private LocalDateTime dataHoraDaUltimaAlteracao;


    public Cliente(ClienteRequest clienteRequest) {
        this.nomeCompleto = clienteRequest.getNomeCompleto();
        this.email = clienteRequest.getEmail();
        this.celular = clienteRequest.getCelular();
        this.telefone = clienteRequest.getTelefone();
        this.sexo = clienteRequest.getSexo();
        this.dataNascimento = clienteRequest.getDataNascimento();
        this.cpf = clienteRequest.getCpf();
        this.aceitaTermos = clienteRequest.getAceitaTermos();
        this.dataHoraDoCadastro = LocalDateTime.now();
    }

    public void altera(ClienteAlteracaoRequest clienteAlteracaoRequestRequest) {
        this.nomeCompleto = clienteAlteracaoRequestRequest.getNomeCompleto();
        this.celular = clienteAlteracaoRequestRequest.getCelular();
        this.telefone = clienteAlteracaoRequestRequest.getTelefone();
        this.sexo = clienteAlteracaoRequestRequest.getSexo();
        this.dataNascimento = clienteAlteracaoRequestRequest.getDataNascimento();
        this.aceitaTermos = clienteAlteracaoRequestRequest.getAceitaTermos();
        this.dataHoraDaUltimaAlteracao = LocalDateTime.now();
    }
}

