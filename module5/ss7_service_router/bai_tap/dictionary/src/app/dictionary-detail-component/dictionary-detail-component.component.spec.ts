import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DictionaryDetailComponentComponent } from './dictionary-detail-component.component';

describe('DictionaryDetailComponentComponent', () => {
  let component: DictionaryDetailComponentComponent;
  let fixture: ComponentFixture<DictionaryDetailComponentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DictionaryDetailComponentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DictionaryDetailComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
