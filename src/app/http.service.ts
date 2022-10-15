import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class HttpService {
  

  constructor(private http:HttpClient) { }

   CreateLoan(obj:any){
    return (this.http.post(`${environment.baseUrl}CreateNewLoan`,obj,{
      responseType:"text"
    }));
   }
  
   getPaymentLoans(){
    return (this.http.get(`${environment.baseUrl}DisplayLoans`));
   }

   getPaymentSchedule(id:number){
    return (this.http.get(`${environment.baseUrl}LoansById/${id}`));
   }
   paymentStatus(paymentId:number){
    return (this.http.put(`${environment.baseUrl}PaidStatus/${paymentId}`,null,{
     responseType:"text"
    }));
  }

   }

   
