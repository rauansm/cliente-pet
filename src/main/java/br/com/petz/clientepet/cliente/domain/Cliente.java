package br.com.petz.clientepet.cliente.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UUID;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class Cliente {
    @Id
    private UUID idCliente;
    @NotBlank
    private String nomeCompleto;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String celular;
    private String telefone;
    private Sexo sexo;
    @NotNull
    private LocalDate dataNascimento;
    @CPF
    private String cpf;
    @NotNull
    private Boolean aceitaTermos;
    private LocalDateTime dataHoraDoCadastro;
    private LocalDateTime dataHoraDaUltimaAlteracao;


    public Cliente(String nomeCompleto, String email, String celular, String telefone, Sexo sexo, LocalDate dataNascimento, String cpf, Boolean aceitaTermos) {
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.celular = celular;
        this.telefone = telefone;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        this.aceitaTermos = aceitaTermos;
        this.dataHoraDoCadastro = LocalDateTime.now();
    }
}
