import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, FormControl } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';


import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { AngularFontAwesomeModule } from 'angular-font-awesome';

import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { AppRoutingModule } from './app.routing.module';
import { LoginService } from './login/login.service';
import { MaterialModule } from './material';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent
  ],
  imports: [
    AngularFontAwesomeModule,
    FormsModule,
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MaterialModule
  ],
  providers: [LoginService],
  bootstrap: [AppComponent]
})
export class AppModule { }
