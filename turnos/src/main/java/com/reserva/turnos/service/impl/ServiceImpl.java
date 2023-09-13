package com.reserva.turnos.service.impl;

import com.reserva.turnos.dto.Comercios;
import com.reserva.turnos.dto.Servicios;
import com.reserva.turnos.dto.Turnos;
import com.reserva.turnos.models.Request;
import com.reserva.turnos.models.RequestLeerServicio;
import com.reserva.turnos.models.Response;
import com.reserva.turnos.repository.ComerciosRepository;
import com.reserva.turnos.repository.ServiciosRepository;
import com.reserva.turnos.repository.ShiftRepository;
import com.reserva.turnos.service.ServiceShift;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class ServiceImpl implements ServiceShift {

    @Autowired
    private ShiftRepository repository;

    @Autowired
    private ComerciosRepository comerciosRepository;

    @Autowired
    private ServiciosRepository serviciosRepository;

    public ServiceImpl(ShiftRepository repository, ComerciosRepository comerciosRepository, ServiciosRepository serviciosRepository) {
        this.repository = repository;
        this.comerciosRepository = comerciosRepository;
        this.serviciosRepository = serviciosRepository;
    }

    @Override
    public List<Turnos> readTurnos() {
        return repository.findAll();
    }

    @Override
    public Response saveShift(Request request) {
        Servicios servicio =serviciosRepository.findByNombreComercioAndNombreServicio(request.getNombreComercio(),request.getNombreServicio());
        SimpleDateFormat fechaConvertida=new SimpleDateFormat("dd-MM-yyyy");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(request.getFechaInicio());
        // Bucle que recorre desde la fecha inicial hasta la fecha final
        while (!calendar.getTime().after(request.getFechaFin())) {
            Date fechaActual = calendar.getTime();
            for(int i = servicio.getHoraApertura(); i < servicio.getHoraCierre(); i = i + servicio.getDuracion()){

                String horaFormateada=horaFormateada(i);
                String horaFormateada2=horaFormateada(i+servicio.getDuracion());

                Turnos turnos=Turnos.builder().nombreServicio(request.getNombreServicio())
                        .estado("Activo")
                        .nombreComercio(request.getNombreComercio())
                        .fechaTurno(fechaConvertida.format(fechaActual))
                        .horaInicio(horaFormateada)
                        .horaFin(horaFormateada2)
                        .build();
                repository.save(turnos);
            }


            calendar.add(Calendar.DAY_OF_MONTH, 1); // Avanzar un día
        }
        return Response.builder().response("Creado").build();
    }





    @Override
    public List<Comercios> readComercios() {
       return comerciosRepository.findAll();
    }

    @Override
    public Comercios writeComercios(Comercios request) {
        return comerciosRepository.save(request);
    }

    @Override
    public List<Servicios> readServicios(RequestLeerServicio comercio) {
        return serviciosRepository.findByNombreComercio(comercio.getComercio());
    }

    @Override
    public Servicios writeServicios(Servicios request) {
        return serviciosRepository.save(request);
    }

    public String horaFormateada(Integer i){
        int intValue = i; // Tu valor entero
        LocalTime localTime = LocalTime.of(intValue, 0); // Crea un objeto LocalTime con la hora
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mm a");
        String horaFormateada = localTime.format(formatter);

        return horaFormateada;
    }
}
