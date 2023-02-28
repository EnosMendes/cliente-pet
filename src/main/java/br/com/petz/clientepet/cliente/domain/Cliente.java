package br.com.petz.clientepet.cliente.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Entity
public class Cliente {
	@Id
    private UUID IdCliente;
	@NotBlank
	private String nomeCompleto;
	@NotBlank
	@Email
	private String email;
	@NotBlank
	private String celular;
	private String telefone;
	@Enumerated(EnumType.STRING)
	private Sexo sexo;
	@NotNull
	private LocalDate dataNascimento;
	@CPF
	private String cpf;
	@NotNull
	private Boolean aceitaRermos = true;
	
	private LocalDateTime dataHoraDoCadrastro;
	private LocalDateTime dataHoraDaUltimaAlteracao;
	
	public Cliente(@NotBlank String nomeCompleto, @NotBlank @Email String email, @NotBlank String celular,
			String telefone, Sexo sexo, @NotNull LocalDate dataNascimento, @CPF String cpf,
			@NotNull Boolean aceitaRermos) {
		
		this.IdCliente = UUID.randomUUID();
		this.nomeCompleto = nomeCompleto;
		this.email = email;
		this.celular = celular;
		this.telefone = telefone;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
		this.aceitaRermos = aceitaRermos;
		this.dataHoraDoCadrastro = LocalDateTime.now();
	}
}
