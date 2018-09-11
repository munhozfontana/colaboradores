import { Component, OnInit } from '@angular/core';
import { ColaboradoresService } from '../colaboradores.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-visualisar',
  templateUrl: './visualisar.component.html',
  styleUrls: ['./visualisar.component.scss']
})
export class VisualisarComponent implements OnInit {
  params: any;
  colaborador: any;
  competencias: any;
  contatos: any;

  lat: number;
  lng: number;


  constructor(
    private colaboradoresService: ColaboradoresService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit() {
    this.route.params.subscribe(res => this.params = res);
    this.getColaborador();
    this.getCompetencias();
    this.getContatos();
  }

  alterURL() {
    this.router.navigate(['colaborador/editar', this.params.id]);
  }

  getColaborador() {
    this.colaboradoresService.getColaborador(this.params.id).subscribe(
      res => {
        this.colaborador = res;
        this.lat = parseFloat(this.colaborador.latitude);
        this.lng = parseFloat(this.colaborador.longitude);
      }
    );
  }

  getCompetencias() {
    this.colaboradoresService.getCompetencias(this.params.id).subscribe(
      res => {
        console.log(res);
        this.competencias = res;
      }
    );
  }

  getContatos() {
    this.colaboradoresService.getContatos(this.params.id).subscribe(
      res => {
        console.log(res);
        this.contatos = res;
      }
    );
  }

  removerColaborador() {
    this.colaboradoresService.removerColaborador(this.params.id).subscribe(
      res => {
        console.log(res);
        this.contatos = res;
      }
    );
  }
}
