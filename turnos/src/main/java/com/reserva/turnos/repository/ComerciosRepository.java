package com.reserva.turnos.repository;

import com.reserva.turnos.dto.Comercios;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ComerciosRepository extends MongoRepository<Comercios,String> {
}
