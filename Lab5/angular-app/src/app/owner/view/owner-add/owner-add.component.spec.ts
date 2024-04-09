import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OwnerAddComponent } from './owner-add.component';

describe('OwnerAddComponent', () => {
  let component: OwnerAddComponent;
  let fixture: ComponentFixture<OwnerAddComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [OwnerAddComponent]
    });
    fixture = TestBed.createComponent(OwnerAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
