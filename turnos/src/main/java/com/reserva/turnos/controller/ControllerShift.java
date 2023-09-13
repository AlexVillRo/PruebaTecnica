package com.reserva.turnos.controller;


import com.reserva.turnos.dto.Comercios;
import com.reserva.turnos.dto.Servicios;
import com.reserva.turnos.dto.Turnos;
import com.reserva.turnos.models.Request;
import com.reserva.turnos.models.RequestLeerServicio;
import com.reserva.turnos.models.Response;
import com.reserva.turnos.service.ServiceShift;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@CrossOrigin("*")
public class ControllerShift {

    @Autowired
    private ServiceShift service;


    @PostMapping("prueba/guardarShift")
    public Response saveDataShift(@RequestBody Request request) throws ParseException {
        return service.saveShift(request);
    }

    @GetMapping("prueba/leerShift")
    public List<Turnos> readDataShift(){
        return service.readTurnos();
    }

    @GetMapping("prueba/leerComercio")
    public List<Comercios> readDataComercio(){
        return service.readComercios();
    }

    @PostMapping("prueba/guardarComercio")
    public Comercios saveDataComercio(@RequestBody Comercios request){
        return service.writeComercios(request);
    }

    @CrossOrigin("localhost:4200/")
    @PostMapping("prueba/leerServicios")
    public List<Servicios> readDataServicios(@RequestBody RequestLeerServicio comercio){
        return service.readServicios(comercio);
    }
    @PostMapping("prueba/guardarServicios")
    public Servicios saveDataServicios(@RequestBody Servicios request){
        return service.writeServicios(request);
    }

}
