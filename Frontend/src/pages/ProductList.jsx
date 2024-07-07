import { useEffect, useState } from "react";
import { fetchProducts } from "../api/Api";
import Order from "./Order";
import "../styles/ProductList.css";

const ProductList = () => {
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
      <h1>Products</h1>
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

      <ul className="product-list">
        {filteredProducts.map((product) => (
          <div className="card" key={product.id}>
            <ul>
              <b>{product.name}</b>
              <br />
              {product.fileData && (
                <img
                  src={`data:image/jpeg;base64,${product.fileData}`}
                  alt={product.fileName}
                  className="product-image"
                />
              )}
              <br />
              Description: {product.description}
              <br />
              Price: {product.price} dt
              <br />
              <Order productId={product.id} />
            </ul>
          </div>
        ))}
      </ul>
    </div>
  );
};

export default ProductList;
