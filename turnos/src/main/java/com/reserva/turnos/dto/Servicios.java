package com.reserva.turnos.dto;


import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Timestamp;

@Data
@Builder
@Document("Servicios")
public class Servicios {

    private String nombreComercio;
    private String nombreServicio;
    private Integer horaApertura;
    private Integer horaCierre;
    private Integer duracion;

}
