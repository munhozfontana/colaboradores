import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { API } from '../app.api';

@Injectable()
export class ColaboradoresService {

  constructor(
    private http: HttpClient
  ) { }




  // Requisição HTTP para atualizar o colaborador
  putColaboradores(colaborador, idColaborador) {
    return this.http.put(`${API}colaborador/${idColaborador}`, colaborador);
  }

  // Requisição HTTP para cadastrar o colaborador
  postColaboradores(colaborador) {
    return this.http.post(`${API}colaborador`, colaborador);
  }

  // Requisição HTTP remover colaborador
  removerColaborador(idColaborador) {
    return this.http.delete(`${API}colaborador/${idColaborador}`);
  }
  // Requisição HTTP para cadastrar o telefone do colaborador
  getTipoContato() {
    return this.http.get(`${API}contato/tipo`);
  }

  // Requisição HTTP para listar todos os colaboradores, passando a página
  getColaboradores(page) {
    return this.http.get(`${API}colaborador/page?page=${page}&linesPerPage=12`);
  }

  // Requisição HTTP para trazer um colaborador do colaborador
  getColaborador(idColaborador) {
    return this.http.get(`${API}colaborador/${idColaborador}`);
  }

  // Requisição HTTP para trazer a competência do colaborador
  getCompetencias(idColaborador) {
    return this.http.get(`${API}competencia/${idColaborador}`);
  }

  // Requisição HTTP para trazer os contatos do colaborador
  getContatos(idColaborador) {
    return this.http.get(`${API}contato/${idColaborador}`);
  }

  // Requisição HTTP para trazer os contatos do colaborador
  getDepartamentos() {
    return this.http.get(`${API}departamentos`);
  }

  // Requisição HTTP para trazer os cargos
  getCargos() {
    return this.http.get(`${API}cargo`);
  }

    // Requisição HTTP para listar todos as competencias
  getCompetenciasAll() {
    return this.http.get(`${API}competencia`);
  }

  getGeocoding(lat, lng) {
    // tslint:disable-next-line:max-line-length
    return this.http.get(`https://maps.googleapis.com/maps/api/geocode/json?latlng=${lat},${lng}&key=AIzaSyDhuOka4HYKv-TW8vk6ggeM_kEz640rVi8`);
  }

}
