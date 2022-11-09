import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { HttpService } from '../http.service';

@Component({
  selector: 'app-create-loan',
  templateUrl: './create-loan.component.html',
  styleUrls: ['./create-loan.component.css']
})
export class CreateLoanComponent implements OnInit {

  loanStartingDate:any[]=[
   0,1,2,3,4,5,6,7,8,9,10
  ];
  MaturityMonths:any[]=[
    12,24,36,48,60
  ];
  paymentFrequency:any[]=[
    1,3,6,12
  ];
  PaymentTerm:any[]=[
    "Interest Only", "Even Principal"
  ]

  EMAIL_PATTERN =
    '^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@' +
    '[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$';

  constructor(private service:HttpService,
              private router:Router) { }

  ngOnInit(): void {
  }
  
  onSubmit(f:NgForm){
   
    let obj={
      loanAmount:f.value.loanAmount,
      loanStartDate:f.value.loanStartDate,
      maturityMonths:f.value.maturityMonths,
      paymentTerm:f.value.paymentTerm,
      paymentFrequency:f.value.paymentFreq,
      interestRate:f.value.interestRate,
      email:f.value.email,
      customerName:f.value.customerName
    }
    this.service.CreateLoan(obj)
    .subscribe((response)=>{
      console.log(response);
    })
    if (confirm("Loan is created successfully!") == true) {
      location.reload();
    }  
  }

  onExit(){
  this.router.navigate(["/"])
  }

}
