package com.reserva.turnos.dto;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


@Data
@Builder
@Document("Comercios")
public class Comercios {


    private String nombreComercio;
    private Integer aforoMaximo;

}
