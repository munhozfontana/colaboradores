import { Component, OnInit, ElementRef, ViewChild } from '@angular/core';
import { COMMA, ENTER } from '@angular/cdk/keycodes';
import { FormGroup, FormControl } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { MatAutocompleteSelectedEvent, MatChipInputEvent } from '@angular/material';



import { ColaboradoresService } from '../colaboradores.service';

@Component({
  selector: 'app-editar-adicionar',
  templateUrl: './editar-adicionar.component.html',
  styleUrls: ['./editar-adicionar.component.scss']
})
export class EditarAdicionarComponent implements OnInit {

  // variáveis da API da Google Material para input de Cargo e Competencia
  visible = true;
  selectable = true;
  removable = true;
  addOnBlur = true;
  readonly separatorKeysCodes: number[] = [ENTER, COMMA];
  competenciasTags = [];

  @ViewChild('competenciaInput') competenciaInput: ElementRef;

  // declaração de variáveis de cadastro
  cargos: any;
  departamentos: any;
  competencias: any;
  endereco: any;
  params: any;
  tipoContato: any;
  lngMarker: Number;
  latMarker: Number;
  lat = -15.0000;
  lng = -52.0000;

  form = {
    nome: '',
    cargo: '',
    departamento: '',
    descricao: '',
    competencias: ''
  };

  departamentoAP: any;
  colaborador: any;
  enderecoGoogle: any;



  constructor(
    private colaboradoresService: ColaboradoresService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit() {
    this.route.params.subscribe(res => this.params = res);
    if (this.params.id) {
      this.getColaborador();
    }
    this.getDepartamentos();
    this.getCargos();
    this.getCompetenciasAll();

  }

  // função para cadastrar e salvar o colaborador
  salvarColaborador(formularioColaborador) {
    if (formularioColaborador.status !== 'INVALID' && this.endereco.coords.lat) {
      formularioColaborador = this.tratamentoForm(formularioColaborador);
      if (!this.params.id) {
        console.log(formularioColaborador.value);

        this.colaboradoresService.postColaboradores(formularioColaborador.value).subscribe(
          res => {
            console.log(res);
            formularioColaborador.reset();
            this.router.navigate(['/colaborador']);
          },
          error => {
            console.log(error);
          }
        );
      } else {
        this.colaboradoresService.putColaboradores(formularioColaborador.value, this.params.id).subscribe(
          res => {
            console.log(res);
            formularioColaborador.reset();
          },
          error => {
            console.log(error);
          }
        );
      }
    } else {
      console.log('Campos obrigatorios faltando');
    }
  }

  tratamentoForm(form) {

    this.colaboradoresService.getGeocoding(this.endereco.coords.lat, this.endereco.coords.lng).subscribe(
      res => {
        this.enderecoGoogle = res;
        form.value.latitude = this.endereco.coords.lat;
        form.value.longitude = this.endereco.coords.lng;
        form.value.cargo_id = form.value.cargo.id;
        form.value.departamento_id = form.value.departamento.id;
        form.value.foto = 1;
        form.value.usuario_id = localStorage.getItem('usuario');
        delete form.value.competencias;
        delete form.value.cargo;
        delete form.value.departamento;

        if (this.enderecoGoogle.error_message) {
          return form.value.endereco = this.enderecoGoogle.status;
        } else {
          return form.value.endereco = this.enderecoGoogle.results[0].formatted_address;
        }
      }
    );

    return form;

  }

  salvarContato(contato) {

  }

  location(value) {
    this.endereco = value;
    this.latMarker = value.coords.lat;
    this.lngMarker = value.coords.lng;
  }

  getColaborador() {
    this.colaboradoresService.getColaborador(this.params.id).subscribe(
      res => {
        this.colaborador = res;
        this.form.cargo = this.colaborador.cargo;
        this.form.descricao = this.colaborador.descricao;
        this.form.nome = this.colaborador.nome;
        this.form.departamento = this.colaborador.departamento;
        this.lat = parseFloat(this.colaborador.latitude);
        this.lng = parseFloat(this.colaborador.longitude);
      }
    );
  }

  departamento(option) {
    this.departamentoAP = option.nome;
  }

  getDepartamentos() {
    this.colaboradoresService.getDepartamentos().subscribe(
      res => {
        this.departamentos = res;
      }
    );
  }

  getCargos() {
    this.colaboradoresService.getCargos().subscribe(
      res => {
        console.log(res);
        this.cargos = res;
      }
    );
  }

  getCompetenciasAll() {
    this.colaboradoresService.getCompetenciasAll().subscribe(
      res => {
        this.competencias = res;
        console.log(this.competencias);
      }
    );
  }

  getTipoContato() {
    this.colaboradoresService.getTipoContato().subscribe(
      res => {
        this.tipoContato = res;
        for (let i = 0; i < this.tipoContato.length; i++) {
          this.tipoContato[i] = this.tipoContato[i].id;
        }
      }
    );
  }

  competenciaTag(valor) {
    console.log(valor);
    let verifica = true;
    for (let i = 0; i < this.competenciasTags.length; i++) {
      if (valor.nome === this.competenciasTags[i].name) {
        verifica = false;
        break;
      }
    }
    if (verifica) {
      this.competenciasTags[this.competenciasTags.length] = { name: valor.nome };
    }
    verifica = true;
  }


  add(event: MatChipInputEvent): void {
    const input = event.input;
    const value = event.value;
    if ((value || '').trim()) {
      this.competenciasTags.push({ name: value.trim() });
    }
    if (input) {
      input.value = '';
    }
  }

  remove(competencia): void {
    const index = this.competenciasTags.indexOf(competencia);

    if (index >= 0) {
      this.competenciasTags.splice(index, 1);
    }
  }



}
