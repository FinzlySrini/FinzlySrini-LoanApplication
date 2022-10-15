import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateLoanComponent } from './create-loan/create-loan.component';
import { DisplayLoansComponent } from './display-loans/display-loans.component';
import { DisplayPaymentScheduleComponent } from './display-payment-schedule/display-payment-schedule.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from './shared/material.module';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { NgxPaginationModule } from 'ngx-pagination';
import { ToastrModule } from 'ngx-toastr';
import { CardComponent } from './card/card.component';

@NgModule({
  declarations: [
    AppComponent,
    CreateLoanComponent,
    DisplayLoansComponent,
    DisplayPaymentScheduleComponent,
    PageNotFoundComponent,
    CardComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MaterialModule,
    FormsModule,
    HttpClientModule,
    NgxPaginationModule,
    ToastrModule.forRoot()
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
