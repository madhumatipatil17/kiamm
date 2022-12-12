import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DamageDeductionComponent } from './damage-deduction.component';

describe('DamageDeductionComponent', () => {
  let component: DamageDeductionComponent;
  let fixture: ComponentFixture<DamageDeductionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DamageDeductionComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DamageDeductionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
