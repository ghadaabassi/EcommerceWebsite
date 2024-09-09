import { Component } from '@angular/core';
import { ProductsService } from '../../services/product/products.service';
@Component({
  selector: 'app-home',
  standalone: true,
  imports: [],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss',
})
export class HomeComponent {
  constructor(private poductsService: ProductsService) {}

  ngOnInit() {
    this.poductsService.getProducts().subscribe((products) => {
      console.log('proddddddddddddd:  ' + JSON.stringify(products));
    });
  }
}
