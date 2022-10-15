import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DisplayPaymentScheduleComponent } from './display-payment-schedule.component';

describe('DisplayPaymentScheduleComponent', () => {
  let component: DisplayPaymentScheduleComponent;
  let fixture: ComponentFixture<DisplayPaymentScheduleComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DisplayPaymentScheduleComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DisplayPaymentScheduleComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
