import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { HttpService } from '../http.service';

@Component({
  selector: 'app-display-payment-schedule',
  templateUrl: './display-payment-schedule.component.html',
  styleUrls: ['./display-payment-schedule.component.css']
})
export class DisplayPaymentScheduleComponent implements OnInit {
  PaymentSchedule:any=[];
  p:number=1;
  
  constructor(private service:HttpService,
              private route:ActivatedRoute,
              private router:Router,
              private toaster:ToastrService) { }

  ngOnInit(): void {
   this.getPaymentSchedules();
  }

getPaymentSchedules(){
  this.route.paramMap.subscribe((param:any)=>{
    this.service.getPaymentSchedule(param.get("id"))
    .subscribe((response:any)=>{
      console.log(response.paymentScheduleEntity)
     this.PaymentSchedule=response.paymentScheduleEntity;
    })
  })
  
}

onBack(){
  this.router.navigate(['/displayLoans'])
  }

onPay(paymentId:any){
this.service.paymentStatus(paymentId)
.subscribe((res)=>{
if(confirm("Do you want to pay?")){
  this.toaster.success(res,"Success!");
 location.reload();
}
else{
  this.toaster.warning("Payment has Cancelled")
}
})
}

}
