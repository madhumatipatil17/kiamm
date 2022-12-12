import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProductstockdetailsComponent } from './productstockdetails.component';

describe('ProductstockdetailsComponent', () => {
  let component: ProductstockdetailsComponent;
  let fixture: ComponentFixture<ProductstockdetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProductstockdetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProductstockdetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
