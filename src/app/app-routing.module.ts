import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CardComponent } from './card/card.component';
import { CreateLoanComponent } from './create-loan/create-loan.component';
import { DisplayLoansComponent } from './display-loans/display-loans.component';
import { DisplayPaymentScheduleComponent } from './display-payment-schedule/display-payment-schedule.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';

const routes: Routes = [
  {
    path:"",component:CardComponent 
  },
  {
    path:"createLoan",component:CreateLoanComponent
  },
  {
    path:"displayLoans",component:DisplayLoansComponent
  },
  {
    path:"displayPaymentSchedule/:id",component:DisplayPaymentScheduleComponent
  },
  
  {
    path:"**",component:PageNotFoundComponent
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
