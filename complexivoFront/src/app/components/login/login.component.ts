import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Usuario } from 'src/app/models/usuario';
import { LoginService } from 'src/app/service/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  tokensito: Usuario;
  user: any = {
    username: '',
    contrasena: '',
    token: '',
  };

  tkn: any;

  constructor(private usuario: LoginService, private router: Router) {}

  ngOnInit(): void {}

  login() {
    this.usuario
      .login(this.user.username, this.user.contrasena)
      .subscribe((data) => {
        console.log(data);
        this.tokensito = data;
        localStorage.setItem('token', this.tokensito.token);
        this.router.navigate(['/listar']);
      });
  }
}

