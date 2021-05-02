import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ListarUsuariosService } from 'src/app/service/listar-usuarios.service';

@Component({
  selector: 'app-listar',
  templateUrl: './listar.component.html',
  styleUrls: ['./listar.component.css']
})
export class ListarComponent implements OnInit {

  usuarios: any[];
  constructor(private usuario: ListarUsuariosService, private route: Router) {
    console.log(localStorage.getItem('token'));
  }

  ngOnInit(): void {
    this.usuario.listarUsuarios().subscribe((data) => {
      this.usuarios = data;
      console.log(data);
    });
  }

  eliminarToken() {
    localStorage.removeItem('token');
    console.log(localStorage.getItem('token'));
    this.route.navigate(['/']);
  }
}