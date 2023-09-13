import { Component } from '@angular/core';
import { FormGroup, FormControl, Validators} from '@angular/forms';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {
  public loginForm: FormGroup;
  username="Alexander Rodriguez";
  password="admin123";
  constructor(private router: Router){
    this.loginForm = new FormGroup({
      'username': new FormControl('', [
        Validators.required
      ]),
      'password': new FormControl('', [
        Validators.required
      ])
    });
  }

  sendLogin(){
    if(this.loginForm.value.username!==this.username || this.loginForm.value.password!==this.password){
      Swal.fire(
        'Error',
        'Contraseña incorrecta',
        'error'
      )
    }else{
      this.router.navigate(
        [
        '/principal',
        { usuario : this.loginForm.value.username
      }
      ]);
    }
  }
  }

