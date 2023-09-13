import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Comercio, RequestGuardarTurno, RequestLeerServicio, Turnos } from 'src/interfaces/turnos';

@Injectable({
  providedIn: 'root'
})
export class ConsumosService {

  constructor(private httpClient: HttpClient) { }


  obtenerTurnos():Observable<any>{
    return this.httpClient.get<Turnos[]>(
      'http://localhost:8080/prueba/leerShift',{}
    )
  }

  obtenerComercio():Observable<any>{
    return this.httpClient.get<Comercio[]>(
      'http://localhost:8080/prueba/leerComercio',{}
    )
  }

  obtenerServicio(requestLeerServicio:RequestLeerServicio):Observable<any>{
    return this.httpClient.post<Comercio[]>(
      'http://localhost:8080/prueba/leerServicios',requestLeerServicio
    );
  }

  guardarTurno(requestGuardarTurno:RequestGuardarTurno):Observable<any>{
    return this.httpClient.post<Comercio[]>(
      'http://localhost:8080/prueba/guardarShift',requestGuardarTurno
    );
  }
}
