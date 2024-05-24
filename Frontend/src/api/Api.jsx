import axios from "axios";

const API_BASE_URL = "http://localhost:8081";

const api = axios.create({
  baseURL: API_BASE_URL,
});

export const fetchProducts = () => api.get("/products/getAll");
export const fetchProductById = (id) => api.get(`/products/${id}`);

const API_BASE_URL1 = "http://localhost:8082";

const api1 = axios.create({
  baseURL: API_BASE_URL1,
});

export const createOrder = (order) => api1.post("/orders/addOrder", order);
export const login = (credentials) => api.post("/auth/login", credentials);
export const register = (user) => api.post("/auth/register", user);

export default api;
