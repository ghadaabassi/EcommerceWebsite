import React, { useEffect, useState } from "react";
import "../styles/NavBar.css";
import { Link } from "react-router-dom";

const NavBar = ({}) => {
  const [isLoggedIn, setIsLoggedIn] = useState(false);
  const [username, setUsername] = useState("");
  const [roles, setRoles] = useState([]);

  useEffect(() => {
    const token = localStorage.getItem("token");
    if (token) {
      try {
        const decodedToken = jwtDecode(token);
        setUsername(decodedToken.username);
        setRoles(decodedToken.roles);
        setIsLoggedIn(true);
      } catch (error) {
        console.error("Invalid token:", error);
        localStorage.removeItem("token");
        localStorage.removeItem("user");
      }
    }
  }, []);

  const handleLogout = () => {
    localStorage.removeItem("token");
    localStorage.removeItem("user");
    setIsLoggedIn(false);
    setUsername("");
    setRoles([]);
  };

  const isAdmin = roles.includes("ADMIN");

  return (
    <nav className="container navbar navbar-light ">
      <div className=" webTitle">
        <img
          src="\src\assets\images\logo.png"
          alt="Logo"
          width="150"
          height="150"
        />
        <h2 className="siteTitle">Shoppify</h2>
      </div>

      <div className="url navbar-links">
        <Link to="/">Home</Link>
        <Link to="/products">Products</Link>
        <Link to="/about">About Us</Link>

        {isAdmin && <Link to="/addProduct">Add-Product</Link>}
        {isAdmin && <Link to="/adminProduct">Admin-Product</Link>}
        {isLoggedIn ? (
          <>
            <span>Welcome, {username}</span>
            <Link to="/cart">Cart</Link>
            <Link to="/account">Account</Link>
            <button onClick={handleLogout}>Logout</button>
          </>
        ) : (
          <>
            <Link to="/login">Login</Link>
            <Link to="/signup">Sign Up</Link>
          </>
        )}
      </div>
    </nav>
  );
};

export default NavBar;
