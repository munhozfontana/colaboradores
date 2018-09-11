
import { NgModule } from '@angular/core';
import { AgmCoreModule } from '@agm/core';

import { RouterModule, Routes } from '@angular/router';
import { ColaboradoresComponent } from './colaboradores.component';
import { VisualisarComponent } from './visualisar/visualisar.component';
import { EditarAdicionarComponent } from './editar-adicionar/editar-adicionar.component';

const ColaboradoresRoutes: Routes = [
  { path: '', component: ColaboradoresComponent },
  { path: 'visualizar/:id', component: VisualisarComponent },
  { path: 'novo', component: EditarAdicionarComponent },
  { path: 'editar/:id', component: EditarAdicionarComponent },

];

@NgModule({
  imports: [RouterModule.forChild(ColaboradoresRoutes)],
  exports: [RouterModule]
})
export class ColaboradoresRoutingModule {}
