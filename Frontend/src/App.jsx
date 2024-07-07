import React from "react";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";

import ProductList from "./pages/ProductList";
import Order from "./pages/Order";

import "./App.css";

const App = () => {
  return (
    <>
      
      <Router>
        <Routes>
          <Route path="/products" element={<ProductList />} />
        </Routes>
      </Router>
    </>
  );
};

export default App;
