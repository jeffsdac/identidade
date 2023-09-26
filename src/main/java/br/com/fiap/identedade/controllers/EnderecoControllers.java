package br.com.fiap.identedade.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
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

import br.com.fiap.identedade.models.Endereco;
import br.com.fiap.identedade.repository.ClinicaRepository;
import br.com.fiap.identedade.repository.EnderecoRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
// Já estava boa
@RestController
@RequestMapping("/api/endereco")
@SecurityRequirement(name = "bearer-key")
@Tag(name = "Endreço", description = "Endereços tanto das clínicas quanto dos usuários")
public class EnderecoControllers {

	@Autowired
	EnderecoRepository repositoryEndereco;
	
	@Autowired
	ClinicaRepository repositoryClinica;
	
	@PostMapping
	public ResponseEntity<Endereco> save(@RequestBody Endereco endereco){
		endereco.setClinica(repositoryClinica.findById(endereco.getClinica().getCdClinica()).get());
		repositoryEndereco.save(endereco);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(endereco);
	}
	
    @GetMapping("{id}")
    public EntityModel<Endereco> show(@PathVariable Long id){
        
    	var findEndereco = repositoryEndereco.findById(id)
    	.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Código de endereço não encontrado"));
    	return findEndereco.toEntityModel();
    }


    @DeleteMapping("{id}")
    public ResponseEntity<Endereco> delete(@PathVariable Long id){
    	var findEndereco = repositoryEndereco.findById(id)
    	    	.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Código de endereço não encontrado"));
    	
    	repositoryEndereco.delete(findEndereco);
    	
    	return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public EntityModel<Endereco> update(@PathVariable Long id, @RequestBody Endereco endereco){
    	repositoryEndereco.findById(id)
    	.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Código de endereço não encontrado"));
    	
    	endereco.setCdEndereco(id);
    	repositoryEndereco.save(endereco);
    	return endereco.toEntityModel();
    }
}
