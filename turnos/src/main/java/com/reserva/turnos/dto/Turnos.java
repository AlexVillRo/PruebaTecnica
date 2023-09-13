package com.reserva.turnos.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Builder
@Document("Turnos")
public class Turnos {

    @Id
    private String idTurno;
    private String nombreComercio;
    private String nombreServicio;
    private String fechaTurno;
    private String horaInicio;
    private String horaFin;
    private String estado;

}
