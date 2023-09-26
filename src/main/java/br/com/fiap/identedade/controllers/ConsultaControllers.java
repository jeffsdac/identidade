package br.com.fiap.identedade.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.identedade.models.Consulta;
import br.com.fiap.identedade.repository.ClinicaRepository;
import br.com.fiap.identedade.repository.ConsultaRepository;
import br.com.fiap.identedade.repository.UsuarioRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/consulta")
@SecurityRequirement(name = "bearer-key")
@Tag(name = "Consultas", description = "Consultas que os usuários marcam nas clinicas")
public class ConsultaControllers {

	
	@Autowired
	UsuarioRepository repositoryUser;
	
	@Autowired
	ClinicaRepository repositoryClinica;
	
	@Autowired
	ConsultaRepository repositoryConsulta;
	
	 @Autowired
    PagedResourcesAssembler<Object> assembler;

    @PostMapping
    public ResponseEntity<Consulta> create(@RequestBody Consulta consulta){
        consulta.setUsuario(repositoryUser.findById(consulta.getUsuario().getCdUsuario()).get());
    	consulta.setClinica(repositoryClinica.findById(consulta.getClinica().getCdClinica()).get());
    	
    	repositoryConsulta.save(consulta);
    	
    	return ResponseEntity.status(HttpStatus.CREATED).body(consulta);
    }


    @GetMapping("{id}")
    public EntityModel<Consulta>  show(@PathVariable Long id){
        var findConsulta = repositoryConsulta.findById(id)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "nÃO FOI POSSÍVEL ACHAR UMA CONSULTA COM ESSE ID"));
    	
    	
    	return findConsulta.toEntityModel();
    }


    @DeleteMapping("{id}")
    public ResponseEntity<Consulta> delete(@PathVariable Long id){
    	return null;
    }

    @PutMapping("{id}")
    public ResponseEntity<Consulta> update(@PathVariable Long id, @RequestBody Consulta consulta){
        return null;
    }
    
    @GetMapping("/usuario/{cdUsuario}")
    public PagedModel<EntityModel<Object>> getConsultasByCdUsuario(
            @PathVariable Long cdUsuario,
            @PageableDefault(size=5) Pageable peageble) {

        Page<Consulta> consultas = repositoryConsulta.findByUsuarioCdUsuario(cdUsuario, peageble);
        
        return assembler.toModel(consultas.map(Consulta::toEntityModel));
    }
    
    @GetMapping("/clinica/{cdClinica}")
    public PagedModel<EntityModel<Object>> getConsultasByCdClinica(
            @PathVariable Long cdClinica,
            @PageableDefault(size=5) Pageable peageble) {

        Page<Consulta> consultas = repositoryConsulta.findByClinicaCdClinica(cdClinica, peageble);
        
        return assembler.toModel(consultas.map(Consulta::toEntityModel));
    }
}
