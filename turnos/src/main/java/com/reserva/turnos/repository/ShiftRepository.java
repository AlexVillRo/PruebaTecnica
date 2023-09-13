package com.reserva.turnos.repository;

import com.reserva.turnos.dto.Turnos;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ShiftRepository extends MongoRepository<Turnos,String> {
}
