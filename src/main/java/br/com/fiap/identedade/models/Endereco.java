package br.com.fiap.identedade.models;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;

import br.com.fiap.identedade.controllers.ClinicaController;
import br.com.fiap.identedade.controllers.EnderecoControllers;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cdEndereco;
    @NotBlank(message = "O Logradouro é obrigatorio.")
    private String logradouro;
    @NotBlank(message = "O estado é obrigatorio.")
    private String estado;
    //@NotBlank(message = "O número é obrigatorio.")
    private int numero;
    

    @ManyToOne
    private Clinica clinica;
    
    
    public EntityModel<Endereco> toEntityModel() {
		return EntityModel.of(
			this, 
			linkTo(methodOn(EnderecoControllers.class).show(cdEndereco)).withSelfRel());
	}


    public Long getCdEndereco() {
		return cdEndereco;
	}

	public void setCdEndereco(Long cdEndereco) {
		this.cdEndereco = cdEndereco;
	}

	public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getNumero() {
        return numero;
    }

    public Clinica getClinica() {
		return clinica;
	}

	public void setClinica(Clinica clinica) {
		this.clinica = clinica;
	}

	public void setNumero(int numero) {
        this.numero = numero;
    }

    
    
}
