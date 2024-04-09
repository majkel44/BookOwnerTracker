import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OwnerEditComponent } from './owner-edit.component';

describe('OwnerEditComponent', () => {
  let component: OwnerEditComponent;
  let fixture: ComponentFixture<OwnerEditComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [OwnerEditComponent]
    });
    fixture = TestBed.createComponent(OwnerEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
