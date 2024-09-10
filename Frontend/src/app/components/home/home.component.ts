import { Component } from '@angular/core';
import { ProductsService } from '../../services/product/products.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

export type Product = {
  id: number;
  name: string;
  description: string;
  price: number;
  category: string;
  fileName: string;
  fileData: string;
};

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss',
})
export class HomeComponent {
  products: Product[] = [];
  filteredProducts: any[] = [];
  searchTerm: string = '';

  constructor(private poductsService: ProductsService) {}

  ngOnInit() {
    this.poductsService.getProducts().subscribe(
      (data) => {
        this.products = data;
        this.filteredProducts = data;
      },
      (error) => {
        console.error('Error fetching products', error);
      }
    );
  }

  getImageUrl(fileData: string): string {
    return `data:image/jpeg;base64,${fileData}`;
  }

  onSearchChange(): void {
    const lowerCaseTerm = this.searchTerm.toLowerCase();
    this.filteredProducts = this.products.filter(
      (product) =>
        product.name.toLowerCase().includes(lowerCaseTerm) ||
        product.category.toLowerCase().includes(lowerCaseTerm)
    );
  }
}
