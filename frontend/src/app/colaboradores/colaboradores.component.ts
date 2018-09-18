import { Component, OnInit } from '@angular/core';
import { ColaboradoresService } from './colaboradores.service';

@Component({
  selector: 'app-colaboradores',
  templateUrl: './colaboradores.component.html',
  styleUrls: ['./colaboradores.component.scss']
})
export class ColaboradoresComponent implements OnInit {
  colaboradores: any;
  paginas = [];
  paginaAtual: number;
  pesquisa: String;

  constructor(
    private colaboradoresService: ColaboradoresService
  ) { }

  ngOnInit() {
    this.getColaboradores(0);
  }


  getPage(page) {
    this.getColaboradores(page);
  }

  getPesquisa(pesquisa: String) {
    this.pesquisa = pesquisa;
    this.servicePage(0);
  }

  getColaboradores(page) {
    this.servicePage(page);
  }


  servicePage(page) {
    this.colaboradoresService.getColaboradores(page, this.pesquisa)
    .subscribe(
      res => {
        console.log(res);
        this.colaboradores = res;
        this.paginas.length = this.colaboradores.totalPages;
        this.paginaAtual = this.colaboradores.number;
      },
      error => {
        console.log(error);
      }
    );
  }

}
