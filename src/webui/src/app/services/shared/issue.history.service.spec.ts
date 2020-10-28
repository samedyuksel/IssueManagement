import { TestBed } from '@angular/core/testing';

import { Issue.HistoryService } from './issue.history.service';

describe('Issue.HistoryService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: Issue.HistoryService = TestBed.get(Issue.HistoryService);
    expect(service).toBeTruthy();
  });
});
