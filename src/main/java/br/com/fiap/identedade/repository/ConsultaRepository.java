package br.com.fiap.identedade.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.identedade.models.Consulta;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
	Page<Consulta> findByUsuarioCdUsuario(Long cdUsuario, Pageable pageable);
	Page<Consulta> findByClinicaCdClinica(Long cdClinica, Pageable pageable);
}
