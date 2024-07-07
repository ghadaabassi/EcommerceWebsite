import axios from "axios";

const API_BASE_URL = "http://localhost:8088";

const api = axios.create({
  baseURL: API_BASE_URL,
});

const api1 = axios.create({
  baseURL: "http://localhost:8084/users",
});

export const fetchProducts = () => api.get("/products/getAll");
export const fetchProductById = (id) => api.get(`/products/getProduct/${id}`);

export const createOrder = (order) => api.post("/orders/addOrder", order);
export const allOrders = () => api.get("/orders/getAll");

export const addProduct = (product) =>
  api.post("/products/addProduct", product);
export const addProductImage = (id, formData) =>
  api.put(`/products/addImage/${id}`, formData);

export const deleteOrder = (id) => api.delete(`/orders/deleteOrder/${id}`);

export const deleteProduct = (id) =>
  api.delete(`/products/deleteProduct/${id}`);

export const deleteInventoryByProduct = (id) =>
  api.delete(`/inventory/deleteInventoryByProduct/${id}`);

export const addProductInventory = (productId, product) =>
  api.put(`/inventory/addProductInventory/${productId}`, product);

export const addInventory = (inventory) =>
  api.post("/inventory/createInventory", inventory);

