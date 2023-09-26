package br.com.fiap.identedade.models;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;

import br.com.fiap.identedade.controllers.ConsultaControllers;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Consulta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cdConsulta;
    private String nomeMedico;
    private String descricao;
    @NotNull(message = "O preço é obrigatório.")
    private float preco;

    @ManyToOne
    private Usuario usuario;
    
    
    @ManyToOne
    private Clinica clinica;

    
    
    public EntityModel<Consulta> toEntityModel() {
		return EntityModel.of(
			this, 
			linkTo(methodOn(ConsultaControllers.class).show(cdConsulta)).withSelfRel(),
			linkTo(methodOn(ConsultaControllers.class).delete(cdConsulta)).withRel("delete"),
            linkTo(methodOn(ConsultaControllers.class).getConsultasByCdUsuario(this.usuario.getCdUsuario(), Pageable.unpaged())).withRel("getByUserId")
		);
	}

	public Long getCdConsulta() {
		return cdConsulta;
	}


	public void setCdConsulta(Long cdConsulta) {
		this.cdConsulta = cdConsulta;
	}


	public String getNomeMedico() {
		return nomeMedico;
	}


	public void setNomeMedico(String nomeMedico) {
		this.nomeMedico = nomeMedico;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public float getPreco() {
		return preco;
	}


	public void setPreco(float preco) {
		this.preco = preco;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public Clinica getClinica() {
		return clinica;
	}


	public void setClinica(Clinica clinica) {
		this.clinica = clinica;
	}
    
    
    
}
