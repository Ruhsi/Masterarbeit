import { TestBed, async, inject } from '@angular/core/testing';

import { GoogleUserAuthenticationGuard } from './user-authentication.guard';

describe('GoogleUserAuthenticationGuard', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [GoogleUserAuthenticationGuard]
    });
  });

  it('should ...', inject([GoogleUserAuthenticationGuard], (guard: GoogleUserAuthenticationGuard) => {
    expect(guard).toBeTruthy();
  }));
});
