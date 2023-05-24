package com.jarodSmith.agenda;

import com.jarodSmith.agenda.model.Contacto;

import com.jarodSmith.agenda.repo.ContactoRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.time.LocalDate;

@Slf4j
@SpringBootApplication
public class AgendaApplication {

	@Autowired
	private ContactoRepository contactoRepository;
	@PostConstruct
	void init(){
		Contacto contacto1 = new Contacto();
		contacto1.setNombre("Darwin Galindo");
		contacto1.setCelular("123456789");
		contacto1.setEmail("darwin@gmail.com");
		contacto1.setFechaNacimiento(LocalDate.now());

		contactoRepository.save(contacto1);

		Contacto contacto2 = new Contacto();
		contacto2.setNombre("María García");
		contacto2.setCelular("987654321");
		contacto2.setEmail("maria@gmail.com");
		contacto2.setFechaNacimiento(LocalDate.now());

		contactoRepository.save(contacto2);

		Contacto contacto3 = new Contacto();
		contacto3.setNombre("Juan Bellido");
		contacto3.setCelular("987654321");
		contacto3.setEmail("juan@gmail.com");
		contacto3.setFechaNacimiento(LocalDate.now());

		contactoRepository.save(contacto3);

		Contacto contacto4 = new Contacto();
		contacto4.setNombre("Deysi Contreras");
		contacto4.setCelular("987654321");
		contacto4.setEmail("deysi@gmail.com");
		contacto4.setFechaNacimiento(LocalDate.now());

		contactoRepository.save(contacto4);


		contactoRepository.findAll().forEach(c -> {
			log.info("Contacto: {}", c);
		});
	}

	public static void main(String[] args) {
		SpringApplication.run(AgendaApplication.class, args);
	}

}
