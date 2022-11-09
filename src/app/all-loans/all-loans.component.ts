import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpService } from '../http.service';

@Component({
  selector: 'app-all-loans',
  templateUrl: './all-loans.component.html',
  styleUrls: ['./all-loans.component.css']
})
export class AllLoansComponent implements OnInit {

  displayLoan:any;
  p:number=1;
  constructor(private service:HttpService,
              private router:Router) { }

  ngOnInit(): void {
    this.displayLoans();
  }

  displayLoans(){
    
    this.service.getPaymentLoans()
    .subscribe((response:any)=>{
      console.log(response);
      this.displayLoan = response;
    })
  }

  onExit(){
    this.router.navigate(['/'])
    }

}