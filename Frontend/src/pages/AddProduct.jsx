import React, { useState } from "react";
import {
  addInventory,
  addProductImage,
  addProductInventory,
} from "../api/Api";
import "../styles/AddProduct.css";

const AddProduct = () => {
  const [product, setProduct] = useState({
    name: "",
    description: "",
    price: 0,
    category: "Kids",
  });

  const [inventory, setInventory] = useState({
    quantity: 0,
  });

  const [file, setFile] = useState(null);
  const [isLoading, setIsLoading] = useState(false);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setProduct((prevProduct) => ({
      ...prevProduct,
      [name]: value,
    }));
  };

  const handleChangeInv = (e) => {
    const { name, value } = e.target;
    setInventory((prevInv) => ({
      ...prevInv,
      [name]: value,
    }));
  };

  const handleFileChange = (e) => {
    setFile(e.target.files[0]);
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    setIsLoading(true);
    try {
      const inventoryResponse = await addInventory(inventory);

      const inventoryId = inventoryResponse.data.id;

      if (file) {
        const formData = new FormData();
        formData.append("file", file);
        const productResponse = await addProductInventory(inventoryId, product);
        const productId = productResponse.data.product.id;
        await addProductImage(productId, formData);
      }

      setProduct({ name: "", description: "", price: 0, category: "Kids" });

      alert("Product added successfully!");
    } catch (error) {
      console.error("Error adding product:", error);
      alert("Failed to add product.");
    } finally {
      setIsLoading(false);
    }
  };

  return (
    <div className="add-product-container">
      <h2>Add New Product</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <label htmlFor="name">Name:</label>
          <input
            type="text"
            id="name"
            name="name"
            value={product.name}
            onChange={handleChange}
            required
          />
        </div>
        <div>
          <label htmlFor="description">Description:</label>
          <input
            type="text"
            id="description"
            name="description"
            value={product.description}
            onChange={handleChange}
            required
          />
        </div>
        <div>
          <label htmlFor="price">Price:</label>
          <input
            type="number"
            id="price"
            name="price"
            value={product.price}
            onChange={handleChange}
            required
          />
        </div>
        <div>
          <label htmlFor="category">Category:</label>
          <select
            id="category"
            name="category"
            value={product.category}
            onChange={handleChange}
            required
          >
            <option value="Kids">Kids</option>
            <option value="Home">Home</option>
            <option value="Women">Women</option>
            <option value="Clothes">Clothes</option>
            <option value="Men">Men</option>
            <option value="Sport">Sport</option>
            <option value="Electric">Electric</option>
            <option value="Jewelery">Jewelery</option>
          </select>
        </div>
        <div>
          <label htmlFor="file">Image:</label>
          <input type="file" id="file" onChange={handleFileChange} />
        </div>

        <div>
          <label htmlFor="quatity">Quantity:</label>
          <input
            type="number"
            id="quantity"
            name="quantity"
            value={inventory.quantity}
            onChange={handleChangeInv}
            required
          />
        </div>

        <button type="submit" disabled={isLoading}>
          {isLoading ? "Adding..." : "Add Product"}
        </button>
      </form>
    </div>
  );
};

export default AddProduct;
