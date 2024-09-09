import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class ProductsService {
  constructor(private http: HttpClient) {}

  private url = 'http://localhost:8088/api/v1/';

  getProducts() {
    return this.http.get(this.url + 'products/getAllProducts');
  }
}
