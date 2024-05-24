import React from "react";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";

import ProductList from "./pages/ProductList";

import Hero from "./components/Hero";

import "./App.css";

const App = () => {
  return (
    <>
      <Hero />
      <Router>
        <Routes>
          <Route path="/products" element={<ProductList />} />
        </Routes>
      </Router>
    </>
  );
};

export default App;
