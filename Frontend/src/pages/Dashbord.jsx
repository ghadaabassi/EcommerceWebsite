import React from "react";
import { Link } from "react-router-dom";
import Button from "react-bootstrap/Button";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import {
  faUsers,
  faShoppingCart,
  faBoxOpen,
} from "@fortawesome/free-solid-svg-icons";
import "bootstrap/dist/css/bootstrap.min.css";

const Dashboard = () => {
  return (
    <div className="container mt-4">
      <h2 className="mb-4">Admin Dashboard</h2>

      <div className="row">
        <div className="col-md-4 mb-4">
          <Link to="/users" className="text-decoration-none">
            <div className="dashboard-section text-center p-4 bg-light rounded">
              <FontAwesomeIcon icon={faUsers} size="3x" className="mb-3" />
              <h3 className="mb-3">User Management</h3>
              <Button variant="primary" className="w-75">
                Manage Users
              </Button>
            </div>
          </Link>
        </div>

        <div className="col-md-4 mb-4">
          <Link to="/orders" className="text-decoration-none">
            <div className="dashboard-section text-center p-4 bg-light rounded">
              <FontAwesomeIcon
                icon={faShoppingCart}
                size="3x"
                className="mb-3"
              />
              <h3 className="mb-3">Orders Management</h3>
              <Button variant="info" className="w-75">
                Manage Orders
              </Button>
            </div>
          </Link>
        </div>

        <div className="col-md-4 mb-4">
          <Link to="/adminProduct" className="text-decoration-none">
            <div className="dashboard-section text-center p-4 bg-light rounded">
              <FontAwesomeIcon icon={faBoxOpen} size="3x" className="mb-3" />
              <h3 className="mb-3">Products Management</h3>
              <Button variant="success" className="w-75">
                Manage Products
              </Button>
            </div>
          </Link>
        </div>
      </div>
      <br />
      <br />
    </div>
  );
};

export default Dashboard;
