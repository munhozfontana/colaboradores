import { Component, OnInit } from '@angular/core';
import { LoginService } from './login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  reposta: any;
  rotaAtual: string;

  constructor(
    private loginService: LoginService,
    private router: Router
  ) { }

  ngOnInit() {
     this.rotaAtual = this.router.url;
    console.log(this.rotaAtual);
  }

  // Função de fazer login
  salvarEmpresa(formularioLogin) {
    if (formularioLogin.status !== 'INVALID') {
      this.loginService.postLogin(formularioLogin.value).subscribe(
        res => {
          this.reposta = res;
          localStorage.setItem('usuario', this.reposta.id);
          this.router.navigate(['colaborador']);
        },
        error => {
          console.log(error);
        }
      );
    }
  }

}
