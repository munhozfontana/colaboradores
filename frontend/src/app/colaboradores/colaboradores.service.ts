import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { API } from '../app.api';

@Injectable()
export class ColaboradoresService {

  constructor(
    private http: HttpClient
  ) { }


  // Requisições PUT ----------------------------
  // Requisição HTTP para atualizar o colaborador
  putColaboradores(colaborador, idColaborador) {
    return this.http.put(`${API}colaborador/${idColaborador}`, colaborador);
  }




  // Requisições POST------------------------------
  // Requisição HTTP para cadastrar o colaborador
  postColaboradores(colaborador) {
    return this.http.post(`${API}colaborador`, colaborador);
  }
  // Requisição HTTP para cadastrar a competencia do colaborador
  postCompetencias(colaborador) {
    return this.http.post(`${API}competencia`, colaborador);
  }

  // Requisição HTTP para cadastrar a telefone do colaborador
  postTelefones(telefone) {
    return this.http.post(`${API}contatos`, telefone);
  }




  // Requisições DELETE-------------------------------
  // Requisição HTTP remover colaborador
  removerColaborador(idColaborador) {
    return this.http.delete(`${API}colaborador/${idColaborador}`);
  }

  // Requisição HTTP remover toas as competencias de colaborador
  deleteCompetenciasId(idColaborador) {
    return this.http.delete(`${API}competencia/${idColaborador}`);
  }

  // Requisição HTTP remover toas os telefones de colaborador
  deleteTelefonesId(idColaborador) {
    return this.http.delete(`${API}contatos/${idColaborador}`);
  }




  // Requisições GET ------------------------------------
  // Requisição HTTP para cadastrar o telefone do colaborador
  getTipoContato() {
    return this.http.get(`${API}contatos/tipo`);
  }

  // Requisição HTTP para listar todos os colaboradores, passando a página
  getColaboradores(page, pesquisa) {
    if (!pesquisa) {
      pesquisa = '';
    }
    return this.http.get(`${API}colaborador/page?page=${page}&linesPerPage=12&find=${pesquisa}`);
  }

  // Requisição HTTP para trazer um colaborador do colaborador
  getColaborador(idColaborador) {
    return this.http.get(`${API}colaborador/${idColaborador}`);
  }

  // Requisição HTTP para trazer os contatos do colaborador
  getContatos(idColaborador) {
    return this.http.get(`${API}contatos/${idColaborador}`);
  }

  // Requisição HTTP para trazer os contatos do colaborador
  getDepartamentos() {
    return this.http.get(`${API}departamentos`);
  }

  // Requisição HTTP para trazer os cargos
  getCargos() {
    return this.http.get(`${API}cargo`);
  }

  // Requisição HTTP para trazer a competência do colaborador
  getCompetencias(idColaborador) {
    return this.http.get(`${API}competencia/${idColaborador}`);
  }

  // Requisição HTTP para listar todos as competencias
  getCompetenciasAll() {
    return this.http.get(`${API}competencia`);
  }

  getGeocoding(lat, lng) {
    return this.http
    .get(`https://maps.googleapis.com/maps/api/geocode/json?latlng=${lat},${lng}&key=AIzaSyDhuOka4HYKv-TW8vk6ggeM_kEz640rVi8`);
  }

}
