import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { API } from '../app.api';
import { Login } from './login.mode';

@Injectable()
export class LoginService {

  constructor(
    private http: HttpClient
  ) { }

  // Requisição HTTP para login
  postLogin(formularioLogin) {
    console.log(formularioLogin);
    return this.http.post<Login[]>(`${API}login`, formularioLogin);
  }

}
