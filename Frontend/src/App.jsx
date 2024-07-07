import React from "react";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import NavBar from "./components/NavBar";

import Footer from "./components/Footer";

import ProductList from "./pages/ProductList";
import Cart from "./pages/Cart";

import Home from "./pages/Home";

import "./App.css";
import AddProduct from "./pages/AddProduct";
import ProductListAdmin from "./pages/ProductListAdmin";
import Dashboard from "./pages/Dashbord";
import AboutUs from "./pages/AboutUs";

const App = () => {
  return (
    <div className="App">
      <Router>
        <NavBar />
        <Routes>
          <Route path="/products" element={<ProductList />} />
          <Route path="/cart" element={<Cart />} />
          <Route path="/addProduct" element={<AddProduct />} />
          <Route path="/adminProduct" element={<ProductListAdmin />} />
          <Route path="/adminBord" element={<Dashboard />} />

          <Route path="/about" element={<AboutUs />} />

          <Route path="" element={<Home />} />
        </Routes>
      </Router>

      <Footer />
    </div>
  );
};

export default App;
