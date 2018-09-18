import { Component, OnInit, OnDestroy } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';



import { ColaboradoresService } from '../colaboradores.service';



@Component({
  selector: 'app-editar-adicionar',
  templateUrl: './editar-adicionar.component.html',
  styleUrls: ['./editar-adicionar.component.scss']
})
export class EditarAdicionarComponent implements OnInit, OnDestroy {
  // declaração de variáveis de cadastro
  cargos: any;
  departamentos: any;
  competencias: any;
  competenciasPost: any;
  endereco: any;
  params: any;
  tipoContato: any;
  lngMarker: Number;
  latMarker: Number;
  lat: Number;
  lng: Number;

  form = {
    nome: '',
    cargo: '',
    departamento: '',
    bibliografia: '',
    latitude: '',
    longitude: '',
    endereco: '',
  };

  competencia: any;

  departamentoAP: any;
  colaborador: any;
  enderecoGoogle: any;
  geoCoding: any;
  contatosPost = [];
  competenciasColaborador: any;
  teste: string;
  telefonesPost: any;
  contatos: any;


  constructor(
    private colaboradoresService: ColaboradoresService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit() {
    this.route.params.subscribe(res => this.params = res);
    if (this.params.id) {
      this.getColaborador();
      this.getCompetencias();
      this.getContatos();
    }
    this.getDepartamentos();
    this.getCargos();
    this.getCompetenciasAll();
    this.getTipoContato();
  }

  // função para cadastrar e salvar o colaborador
  salvarColaborador(formularioColaborador) {
    const cordenadas = {
      coords: {
        lat: this.latMarker,
        lng: this.lngMarker
      }
    };
    this.location(cordenadas);

    if (formularioColaborador.status !== 'INVALID') {
      formularioColaborador = this.tratamentoForm(formularioColaborador);
      if (!this.params.id) {
        this.colaboradoresService.postColaboradores(formularioColaborador.value).subscribe(
          res => {
            this.postCompetencias(res);
            this.postTelefone(res);
            this.router.navigate(['/colaborador/visualizar', res]);
            this.ngOnDestroy();
          },
          error => {
            console.log(error);
          }
        );
      } else {
        this.colaboradoresService.putColaboradores(formularioColaborador.value, this.params.id).subscribe(
          res => {
            this.postCompetencias(this.params.id);
            this.postTelefone(this.params.id);
            this.router.navigate(['/colaborador/visualizar', this.params.id]);
            this.ngOnDestroy();
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
    form.value.cargo_id = form.value.cargo.id;
    form.value.departamento_id = form.value.departamento.id;
    form.value.foto = 1;
    form.value.endereco = this.geoCoding;
    form.value.latitude = this.latMarker;
    form.value.longitude = this.lngMarker;
    // tslint:disable-next-line:radix
    form.value.usuario_id = parseInt(localStorage.getItem('usuario'));
    delete form.value.competencia;
    delete form.value.cargo;
    delete form.value.departamento;
    return form;
  }

  guardaContato(contato) {
    this.contatosPost[this.contatosPost.length] = contato.value;
  }

  removerContato(contato) {
    this.contatosPost.splice(contato, 1);
  }

  departamento(option) {
    this.departamentoAP = option.nome;
  }

  guardaCompetencia(value) {
    this.competenciasPost = value;
  }


  // Função para cadastrar todas as competencias
  postCompetencias(res) {
    if (this.params.id && this.competenciasPost) {
      this.colaboradoresService.deleteCompetenciasId(this.params.id).subscribe(
        succeso => succeso
      );
    }

    if (this.competenciasPost) {
      for (let i = 0; i < this.competenciasPost.length; i++) {
        this.competenciasPost[i].colaborador = res;
        const competencialLocal = {
          nome: this.competenciasPost[i].nome,
          colaborador: this.competenciasPost[i].colaborador
        };
        this.colaboradoresService.postCompetencias(competencialLocal).subscribe(
          succeso => succeso
        );
      }
    }
  }


  // Função para cadastrar todas os telefones
  postTelefone(res) {
    if (!this.params.id) {
      this.telefoneIncremet(res);
    } else if (this.params.id && this.contatosPost) {
      this.colaboradoresService.deleteTelefonesId(this.params.id).subscribe(
        succeso => this.telefoneIncremet(res)
      );
    } else {
      this.telefoneIncremet(res);
    }
  }

  telefoneIncremet(res) {
    for (let i = 0; i < this.contatosPost.length; i++) {
      this.contatosPost[i].colaborador = res;
      const telefoneLocal = {
        contato: this.contatosPost[i].telefone,
        tipoContato: this.contatosPost[i].tipo.id,
        colaborador: this.contatosPost[i].colaborador
      };
      this.colaboradoresService.postTelefones(telefoneLocal).subscribe(
        succeso => succeso
      );
    }
  }

  location(cordenadas) {
    this.endereco = cordenadas;
    this.latMarker = cordenadas.coords.lat;
    this.lngMarker = cordenadas.coords.lng;
    this.colaboradoresService.getGeocoding(this.endereco.coords.lat, this.endereco.coords.lng).subscribe(
      res => {
        this.enderecoGoogle = res;
        this.form.latitude = this.endereco.coords.lat;
        this.form.longitude = this.endereco.coords.lng;
        if (this.enderecoGoogle.error_message) {
          this.geoCoding = this.enderecoGoogle.status;
        } else {
          this.geoCoding = this.enderecoGoogle.results[0].formatted_address;
        }
      }
    );
  }

  getColaborador() {
    this.colaboradoresService.getColaborador(this.params.id).subscribe(
      res => {
        this.colaborador = res;
        this.form.cargo = this.colaborador.cargo;
        this.form.bibliografia = this.colaborador.bibliografia;
        this.form.nome = this.colaborador.nome;
        this.form.departamento = this.colaborador.departamento;

        this.lat = parseFloat(this.colaborador.latitude);
        this.lng = parseFloat(this.colaborador.longitude);
        this.latMarker = parseFloat(this.colaborador.latitude);
        this.lngMarker = parseFloat(this.colaborador.longitude);
      }
    );
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
        this.cargos = res;
      }
    );
  }

  getCompetenciasAll() {
    this.colaboradoresService.getCompetenciasAll().subscribe(
      res => {
        this.competencias = res;
      }
    );
  }

  getCompetencias() {
    this.colaboradoresService.getCompetencias(this.params.id).subscribe(
      res => {
        this.competenciasColaborador = res;
      }
    );
  }

  getTipoContato() {
    this.colaboradoresService.getTipoContato().subscribe(
      res => {
        this.tipoContato = res;
      }
    );
  }

  getContatos() {
    this.colaboradoresService.getContatos(this.params.id).subscribe(
      res => {
        this.contatos = res;
        for (let i = 0; i < this.contatos.length; i++) {
          this.contatosPost[i] = {
            telefone: this.contatos[i].contato,
            tipo: {
              telefone: this.contatos[i].contato,
              id: this.contatos[i].id
            }
          };
        }
      },
      error => {
        console.log(error);
      }
    );
  }

  ngOnDestroy(): void {

  }


}
