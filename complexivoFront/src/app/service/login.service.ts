import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Usuario } from '../models/usuario';

@Injectable({
  providedIn: 'root',
})
export class LoginService {
  constructor(private http: HttpClient) {}

  private url = 'http://localhost:8080/login';

  login(username: string, contrasena: string): any {
    return this.http.get<Usuario>(this.url + '/' + username + '/' + contrasena);
  }
}