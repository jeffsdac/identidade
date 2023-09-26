package br.com.fiap.identedade.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.identedade.models.Clinica;
import br.com.fiap.identedade.repository.ClinicaRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/clinica")
@SecurityRequirement(name = "bearer-key")
@Tag(name = "Clinicas", description = "Clínicas que podem atender os usuários")
public class ClinicaController {
	
	@Autowired
	ClinicaRepository repositoryClinica;

    @PostMapping
    public ResponseEntity<Clinica> create(@RequestBody @Valid Clinica clinica){
    	clinica.setAtivo(true);
    	repositoryClinica.save(clinica);
    	
    	return ResponseEntity.status(HttpStatus.CREATED).body(clinica);
    }


    @GetMapping("{id}")
    public EntityModel<Clinica> show(@PathVariable Long id){
        var clinicaFind = repositoryClinica.findById(id)
        		.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Clinica não encontrada"));
        
        return clinicaFind.toEntityModel();
    }

    @PutMapping("{id}")
    public EntityModel<Clinica> update(@PathVariable Long id, @RequestBody Clinica clinica){
    	repositoryClinica.findById(id)
    	.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Não foi possível encontrar um clinica com esse Código"));
    	
    clinica.setCdClinica(id);
    repositoryClinica.save(clinica);
    	
    	
    	return clinica.toEntityModel();
    }
}
