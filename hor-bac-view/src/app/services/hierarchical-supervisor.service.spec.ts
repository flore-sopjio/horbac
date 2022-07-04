import { TestBed } from '@angular/core/testing';

import { HierarchicalSupervisorService } from './hierarchical-supervisor.service';

describe('HierarchicalSupervisorService', () => {
  let service: HierarchicalSupervisorService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(HierarchicalSupervisorService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
