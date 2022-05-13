import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DictionaryCreateComponentComponent } from './dictionary-create-component.component';

describe('DictionaryCreateComponentComponent', () => {
  let component: DictionaryCreateComponentComponent;
  let fixture: ComponentFixture<DictionaryCreateComponentComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DictionaryCreateComponentComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DictionaryCreateComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
