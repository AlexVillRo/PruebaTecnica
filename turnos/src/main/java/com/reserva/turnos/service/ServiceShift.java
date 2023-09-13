package com.reserva.turnos.service;

import com.reserva.turnos.dto.Comercios;
import com.reserva.turnos.dto.Servicios;
import com.reserva.turnos.dto.Turnos;
import com.reserva.turnos.models.Request;
import com.reserva.turnos.models.RequestLeerServicio;
import com.reserva.turnos.models.Response;

import java.text.ParseException;
import java.util.List;

public interface ServiceShift {

    List<Turnos> readTurnos();
    Response saveShift(Request request) throws ParseException;
    List<Comercios> readComercios();
    Comercios writeComercios(Comercios request);

    List<Servicios> readServicios(RequestLeerServicio comercio);

    Servicios writeServicios(Servicios request);



}
