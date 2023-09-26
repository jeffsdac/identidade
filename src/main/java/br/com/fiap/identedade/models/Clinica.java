package br.com.fiap.identedade.models;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;

import br.com.fiap.identedade.controllers.ClinicaController;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Clinica {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long cdClinica;
	@NotBlank(message = "O nome é obrigatorio.")
	private String nome;
	@NotBlank(message = "O E-mail é obrigatorio.")
	private String email;

	private boolean ativo;

	public EntityModel<Clinica> toEntityModel() {
		return EntityModel.of(
				this, 
				linkTo(methodOn(ClinicaController.class).show(cdClinica)).withSelfRel()
		);
		
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public Long getCdClinica() {
		return cdClinica;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}



	public boolean isAtivo() {
		return ativo;
	}

	public void setCdClinica(Long cdClinica) {
		this.cdClinica = cdClinica;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEmail(String email) {
		this.email = email;
	}


}
