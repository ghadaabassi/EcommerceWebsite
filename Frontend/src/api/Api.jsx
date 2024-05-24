import axios from "axios";

const API_BASE_URL = "http://localhost:8081";

const api = axios.create({
  baseURL: API_BASE_URL,
});

export const fetchProducts = () => api.get("/products/getAll");
export const fetchProductById = (id) => api.get(`/products/${id}`);
export const createOrder = (order) => api.post("/orders", order);
export const login = (credentials) => api.post("/auth/login", credentials);
export const register = (user) => api.post("/auth/register", user);

export default api;
