import { TestBed } from '@angular/core/testing';
import { HTTP_INTERCEPTORS, HttpClient } from '@angular/common/http';
import {
  HttpClientTestingModule,
  HttpTestingController,
} from '@angular/common/http/testing';
import { httpTokenInterceptor } from './http-token.interceptor';
import { KeycloakService } from '../services/keycloak/keycloak.service';

describe('httpTokenInterceptor', () => {
  let httpMock: HttpTestingController;
  let httpClient: HttpClient;
  let mockKeycloakService: jasmine.SpyObj<KeycloakService>;

  beforeEach(() => {
    mockKeycloakService = jasmine.createSpyObj('KeycloakService', [], {
      keycloak: { token: 'test-token' },
    });

    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [
        {
          provide: HTTP_INTERCEPTORS,
          useClass: httpTokenInterceptor,
          multi: true,
        },
        { provide: KeycloakService, useValue: mockKeycloakService },
      ],
    });

    httpMock = TestBed.inject(HttpTestingController);
    httpClient = TestBed.inject(HttpClient);
  });

  afterEach(() => {
    httpMock.verify();
  });

  it('should add an Authorization header', () => {


    const req = httpMock.expectOne('/test');
    expect(req.request.headers.has('Authorization')).toBeTruthy();
    expect(req.request.headers.get('Authorization')).toBe('Bearer test-token');
  });

  it('should not add an Authorization header if token is missing', () => {
    const req = httpMock.expectOne('/test');
    expect(req.request.headers.has('Authorization')).toBeFalsy();
  });
});
