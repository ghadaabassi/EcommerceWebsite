import { Component } from '@angular/core';
import {
  FormBuilder,
  FormGroup,
  Validators,
  ReactiveFormsModule,
} from '@angular/forms';
import { ProductsService } from '../../services/product/products.service';
import { Product, Category } from '../../models/product.model';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-add-product',
  standalone: true,
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.scss'],
  imports: [CommonModule, ReactiveFormsModule],
})
export class AddProductComponent {
  productForm: FormGroup;
  categories = Object.values(Category);

  constructor(
    private fb: FormBuilder,
    private productsService: ProductsService
  ) {
    this.productForm = this.fb.group({
      name: ['', Validators.required],
      description: ['', Validators.required],
      qt: [0, [Validators.required, Validators.min(0)]],
      price: [0, [Validators.required, Validators.min(0)]],
      category: ['', Validators.required],
    });
  }

  onSubmit() {
    if (this.productForm.valid) {
      const newProduct: Product = this.productForm.value;
      this.productsService.addProduct(newProduct).subscribe(
        (response) => {
          console.log('Product added successfully', response);
          this.productForm.reset();
        },
        (error) => {
          console.error('Error adding product', error);
        }
      );
    }
  }
}
