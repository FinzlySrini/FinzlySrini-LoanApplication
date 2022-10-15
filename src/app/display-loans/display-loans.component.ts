import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpService } from '../http.service';

@Component({
  selector: 'app-display-loans',
  templateUrl: './display-loans.component.html',
  styleUrls: ['./display-loans.component.css']
})
export class DisplayLoansComponent implements OnInit {

  displayLoan:any={};
  p:number=1;
  constructor(private service:HttpService,
              private router:Router) { }

  ngOnInit(): void {
    this.displayLoans();
  }

  displayLoans(){
    
    this.service.getPaymentLoans()
    .subscribe((response=>{
      this.displayLoan = response;
    }))
  }

  onBack(){
    this.router.navigate(['/'])
    }

}









