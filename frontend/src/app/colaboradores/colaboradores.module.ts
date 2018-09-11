import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AgmCoreModule } from '@agm/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';

import { AngularFontAwesomeModule } from 'angular-font-awesome';

import { ColaboradoresComponent } from './colaboradores.component';
import { ColaboradoresRoutingModule } from './colaboradores.routing.module';
import { ColaboradoresService } from './colaboradores.service';
import { VisualisarComponent } from './visualisar/visualisar.component';
import { EditarAdicionarComponent } from './editar-adicionar/editar-adicionar.component';
import { MaterialModule } from './../material';


@NgModule({
  imports: [
    CommonModule,
    ColaboradoresRoutingModule,
    AngularFontAwesomeModule,
    MaterialModule,
    FormsModule,
    ReactiveFormsModule,
    AgmCoreModule.forRoot({
      apiKey: 'AIzaSyDhuOka4HYKv-TW8vk6ggeM_kEz640rVi8'
    })
  ],
  declarations: [
    ColaboradoresComponent,
    VisualisarComponent,
    EditarAdicionarComponent
  ],
  exports: [
    ColaboradoresComponent
  ],
  providers: [
    ColaboradoresService
  ]
})
export class ColaboradoresModule { }
