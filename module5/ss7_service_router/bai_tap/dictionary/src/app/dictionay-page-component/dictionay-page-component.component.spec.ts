import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DictionayPageComponentComponent } from './dictionay-page-component.component';

describe('DictionayPageComponentComponent', () => {
  let component: DictionayPageComponentComponent;
  let fixture: ComponentFixture<DictionayPageComponentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DictionayPageComponentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DictionayPageComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
