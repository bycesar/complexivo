import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Usuario } from '../models/usuario';

@Injectable({
  providedIn: 'root',
})
export class ListarUsuariosService {
  httpHeaders: any;
  constructor(private http: HttpClient) {
    this.httpHeaders = new HttpHeaders({
      Authorization: localStorage.getItem('token'),
    });
  }

  private url = 'http://localhost:8080/listarUsuarios';

  listarUsuarios() {
    return this.http.get<Usuario[]>(this.url, { headers: this.httpHeaders });
  }
}