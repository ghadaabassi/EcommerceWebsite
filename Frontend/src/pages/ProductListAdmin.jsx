import { useEffect, useState } from "react";
import { fetchProducts, deleteInventoryByProduct } from "../api/Api";
import "../styles/ProductListAdmin.css";

const ProductListAdmin = () => {
  const [products, setProducts] = useState([]);
  const [searchTerm, setSearchTerm] = useState("");
  const [searchCategory, setSearchCategory] = useState("");

  useEffect(() => {
    const getProducts = async () => {
      const response = await fetchProducts();
      setProducts(response.data);
    };
    getProducts();
  }, []);

  const handleSearch = (e) => {
    setSearchTerm(e.target.value);
  };

  const handleCategoryChange = (e) => {
    setSearchCategory(e.target.value);
  };

  const handleDelete = async (id) => {
    const isConfirmed = window.confirm(
      "Are you sure you want to delete this product?"
    );
    if (isConfirmed) {
      try {
        await deleteInventoryByProduct(id);
        setProducts(products.filter((product) => product.id !== id));
        alert("Product deleted successfully!");
      } catch (error) {
        console.error(`Error deleting product with ID ${id}:`, error);
        alert("Failed to delete product.");
      }
    }
  };

  const handleUpdate = (id) => {
    alert(`Update product with ID ${id}`);
  };

  const filteredProducts = products.filter((product) => {
    const matchesName = product.name
      .toLowerCase()
      .includes(searchTerm.toLowerCase());
    const matchesCategory = searchCategory
      ? product.category === searchCategory
      : true;
    return matchesName && matchesCategory;
  });

  return (
    <div>
      <h1>Product List Admin</h1>
      <div className="search-bar">
        <input
          type="text"
          placeholder="Search by name..."
          value={searchTerm}
          onChange={handleSearch}
        />
        <select value={searchCategory} onChange={handleCategoryChange}>
          <option value="">All Categories</option>
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

      <div className="product-list-admin">
        {filteredProducts.map((product) => (
          <div className="product-card" key={product.id}>
            {product.fileData && (
              <img
                src={`data:image/jpeg;base64,${product.fileData}`}
                alt={product.fileName}
                className="product-image"
              />
            )}
            <div className="product-details">
              <b>{product.name}</b>
              <div>Description: {product.description}</div>
              <div>Price: {product.price} dt</div>
              <div className="buttons-container">
                <button onClick={() => handleUpdate(product.id)}>Update</button>
                <button onClick={() => handleDelete(product.id)}>Delete</button>
              </div>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
};

export default ProductListAdmin;
