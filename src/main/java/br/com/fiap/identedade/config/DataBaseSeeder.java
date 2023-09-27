package br.com.fiap.identedade.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.com.fiap.identedade.models.Clinica;
import br.com.fiap.identedade.models.Consulta;
import br.com.fiap.identedade.models.Endereco;
import br.com.fiap.identedade.models.Usuario;
import br.com.fiap.identedade.repository.ClinicaRepository;
import br.com.fiap.identedade.repository.ConsultaRepository;
import br.com.fiap.identedade.repository.EnderecoRepository;
import br.com.fiap.identedade.repository.UsuarioRepository;

@Configuration
@Profile("dev")
public class DataBaseSeeder implements CommandLineRunner{
	@Autowired
	ClinicaRepository repositoryClinica;
	
	@Autowired
	EnderecoRepository repositoryEndereco;
	
	@Autowired
	UsuarioRepository repositoryUser;
	
	@Autowired
	ConsultaRepository repositoryConsulta;
	
	@Autowired
    PasswordEncoder encoder;
	

	@Override
	 public void run(String... args) throws Exception {
		
		
		Usuario u1 = new Usuario();
		u1.setNome("Jefferson");
		u1.setEmail("email@email.com");
		String senhaUser = "amominhamae";
		u1.setSenha(encoder.encode(senhaUser));
		u1.setAtivo(true);
		u1.setRole("ROLE_USUARIO");
		repositoryUser.save(u1);
		
		
		Usuario u2 = new Usuario();
		u2.setNome("Dentes felizes");
		u2.setEmail("email@dentesfelizes.com");
		String senhaUserDois = "amomeupai";
		u2.setSenha(encoder.encode(senhaUserDois));
		u2.setAtivo(true);
		u2.setRole("ROLE_CLINICA");
		repositoryUser.save(u2);
		
		Clinica c1 = new Clinica();
		c1.setAtivo(true);
		c1.setEmail("clinica@email.com");
		c1.setNome("Clinica sorriso bom");
		repositoryClinica.save(c1);
		
		Endereco e1 = new Endereco();
		e1.setLogradouro("Rua Joao Da Silva");
		e1.setEstado("São Paulo");
		e1.setNumero(231);
		e1.setClinica(c1);
		repositoryEndereco.save(e1);
		
		Consulta cons = new Consulta();
		cons.setClinica(c1);
		cons.setUsuario(u1);
		cons.setDescricao("Verificação mensal");
		cons.setNomeMedico("Frederico");
		cons.setPreco(50);
		repositoryConsulta.save(cons);		
		
		
		
		
	}
}
