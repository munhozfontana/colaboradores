import { Component, OnInit, OnDestroy, DoCheck, OnChanges, AfterContentInit, AfterContentChecked } from '@angular/core';
import { ColaboradoresService } from '../colaboradores.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-visualisar',
  templateUrl: './visualisar.component.html',
  styleUrls: ['./visualisar.component.scss']
})
export class VisualisarComponent implements OnInit, OnDestroy {
  params: any;
  colaborador: any;
  competencias: any;
  contatos: any;

  lat: number;
  lng: number;
  map = false;


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
    setTimeout(() => {
      this.getCompetencias();
    }, 500);
  }

  alterURL() {
    this.router.navigate(['colaborador/editar', this.params.id]);
    this.ngOnDestroy();
  }

  getColaborador() {
    this.colaboradoresService.getColaborador(this.params.id).subscribe(
      res => {
        this.colaborador = res;
        console.log(this.colaborador);
        this.lat = this.colaborador.latitude;
        this.lng = this.colaborador.longitude;
        this.map = true;
      }
    );
  }

  getCompetencias() {
    this.colaboradoresService.getCompetencias(this.params.id).subscribe(
      res => {
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
        this.router.navigate(['/colaborador']);
        this.ngOnDestroy();
      }
    );
  }

  ngOnDestroy(): void {

  }

}
