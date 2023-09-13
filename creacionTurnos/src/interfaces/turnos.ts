export interface Turnos {

  idTurno:string;
  nombreComercio:string;
  nombreServicio:string;
  fechaTurno:string;
  horaInicio:string;
  horaFin:string;
  estado:string;
}

export interface Comercio {

  nombreComercio:string;
  aforoMaximo:number;
}

export interface Servicios {

  nombreComercio:string;
  nombreServicio:string;
  horaApertura:number;
  horaCierre:number;
  duracion:string;

}

export class RequestLeerServicio{
  comercio:string;
  constructor(comercio:string){
      this.comercio = comercio;
  }
}


export class RequestGuardarTurno{
  nombreComercio:string;
  nombreServicio:string;
  fechaInicio:string;
  fechaFin:string;
  constructor(nombreComercio:string,nombreServicio:string,fechaInicio:string,fechaFin:string){
      this.nombreComercio=nombreComercio;
      this.nombreServicio=nombreServicio;
      this.fechaInicio=fechaInicio;
      this.fechaFin=fechaFin;
  }
}

