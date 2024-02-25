import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BilanciaComponent } from './bilancia.component';

describe('BilanciaComponent', () => {
  let component: BilanciaComponent;
  let fixture: ComponentFixture<BilanciaComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [BilanciaComponent]
    });
    fixture = TestBed.createComponent(BilanciaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
