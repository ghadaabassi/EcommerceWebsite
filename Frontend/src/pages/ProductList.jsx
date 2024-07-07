import React, { useEffect, useState } from "react";
import { fetchProducts } from "../api/Api";
import Order from "./Order";

const ProductList = () => {
  const [products, setProducts] = useState([]);

  useEffect(() => {
    const getProducts = async () => {
      const response = await fetchProducts();
      setProducts(response.data);
    };
    getProducts();
  }, []);

  return (
    <div>
      <h1>Products</h1>
      <ul>
        {products.map((product) => (
          <li key={product.id}>
            {product.name}

            <Order productId={product.id} />
          </li>
        ))}
      </ul>
    </div>
  );
};

export default ProductList;
