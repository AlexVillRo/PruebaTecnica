package com.reserva.turnos.repository;

import com.reserva.turnos.dto.Servicios;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ServiciosRepository extends MongoRepository<Servicios,String> {

    List<Servicios> findByNombreComercio(String comercio);
    Servicios findByNombreComercioAndNombreServicio(String comercio, String servicio);
}
