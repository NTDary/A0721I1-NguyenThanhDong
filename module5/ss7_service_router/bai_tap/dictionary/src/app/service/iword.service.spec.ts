import { TestBed } from '@angular/core/testing';

import { IWordService } from './iword.service';

describe('IWordService', () => {
  let service: IWordService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(IWordService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
