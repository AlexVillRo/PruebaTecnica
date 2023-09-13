import { Component } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { ConsumosService } from 'src/service/consumos.service';
import {Comercio, RequestGuardarTurno, RequestLeerServicio, Servicios, Turnos } from '../../interfaces/turnos'
import Swal from 'sweetalert2';

@Component({
  selector: 'app-principal',
  templateUrl: './principal.component.html',
  styleUrls: ['./principal.component.scss']

})
export class PrincipalComponent {
  usuario:any;

  constructor(private activeRouter: ActivatedRoute,private router: Router,private consumo:ConsumosService){
  }
  turnos:Turnos[];
  comercio:Comercio[];
  servicios:Servicios[];
  comercioSeleccionado: string;
  servicioSeleccionado: string;
  fechaInicialSeleccionada:string;
  fechafinalSeleccionada:string;
  requestServicio:RequestLeerServicio;
  requestGuardarTurno:RequestGuardarTurno;

  ngOnInit(){

    this.consumo.obtenerTurnos().subscribe({
      next: (response) => {
       this.turnos=response;
       console.log(this.turnos);
      },
      error: (error) => {
        console.log(error);
      }
    });

    this.consumo.obtenerComercio().subscribe({
      next: (response) => {
       this.comercio=response;
       console.log(this.comercio);
      },
      error: (error) => {
        console.log(error);
      }
    });


    this.activeRouter.params.subscribe((data:Params) =>{
      this.usuario=data['usuario'];
  });




  }

  seleccionarOpcion(){
    this.requestServicio={
      comercio:this.comercioSeleccionado
    }

    this.consumo.obtenerServicio(this.requestServicio).subscribe({
      next: (response) => {
        this.servicios=response;
       },
       error: (error) => {
         console.log(error);
       }
    });
  }

  onSave(){
    Swal.fire({
      title: '¡Cargando!',
      html: 'Guardando, espere',
      timerProgressBar: true,
      didOpen: () => {
        Swal.showLoading();
      },
    });
    this.requestGuardarTurno={
      nombreComercio:this.comercioSeleccionado,
      nombreServicio:this.servicioSeleccionado,
      fechaInicio:this.fechaInicialSeleccionada,
      fechaFin:this.fechafinalSeleccionada
    }

    this.consumo.guardarTurno(this.requestGuardarTurno).subscribe({
      next: (response) => {
        Swal.close();
        Swal.fire(
          'Buen trabajo!',
          response.response,
          'success'
        )
       },
       error: (error) => {
         console.log(error);
       }
    })

    console.log(this.requestGuardarTurno)
  }


}


