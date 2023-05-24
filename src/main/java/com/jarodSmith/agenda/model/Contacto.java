package com.jarodSmith.agenda.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class Contacto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcontacto")
    private Integer id;

    private String nombre;
    @Column(name = "fechanac")
    private LocalDate fechaNacimiento;

    private String celular;

    private String email;

}
