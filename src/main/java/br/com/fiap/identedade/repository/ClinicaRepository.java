package br.com.fiap.identedade.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.identedade.models.Clinica;

public interface ClinicaRepository extends JpaRepository<Clinica, Long>{
	
}
