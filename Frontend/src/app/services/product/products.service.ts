import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { KeycloakService } from '../keycloak/keycloak.service';
import { Product } from '../../components/home/home.component';

@Injectable({
  providedIn: 'root',
})
export class ProductsService {
  constructor(
    private http: HttpClient,
    private keycloakService: KeycloakService
  ) {}

  private url = 'http://localhost:8088/api/v1/';

  getProducts() {
    const token = this.keycloakService.profile?.token;
    const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);

    return this.http.get<Product[]>(this.url + 'products/getAllProducts', { headers });
  }
}
