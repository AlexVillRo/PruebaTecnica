package com.reserva.turnos.models;

import lombok.Data;

import java.util.Date;

@Data
public class Request {
    private String nombreComercio;
    private String nombreServicio;
    private Date fechaInicio;
    private Date fechaFin;

}
