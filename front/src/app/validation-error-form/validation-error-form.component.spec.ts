import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {ValidationErrorFormComponent} from './validation-error-form.component';

describe('ValidationErrorFormComponent', () => {
  let component: ValidationErrorFormComponent;
  let fixture: ComponentFixture<ValidationErrorFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ValidationErrorFormComponent]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ValidationErrorFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
