import React, { useState, useEffect } from "react";
import { allOrders, fetchProductById, deleteOrder } from "../api/Api";
import "../styles/Cart.css";
import "../styles/ProductList.css";

const Cart = () => {
  const [orders, setOrders] = useState([]);
  const [isLoading, setIsLoading] = useState(true);

  useEffect(() => {
    const fetchOrders = async () => {
      try {
        const response = await allOrders();
        setOrders(response.data);
      } catch (error) {
        console.error("Error fetching orders:", error);
      } finally {
        setIsLoading(false);
      }
    };
    fetchOrders();
  }, []);

  useEffect(() => {
    const fetchProductDetails = async () => {
      const orderWithProductDetails = await Promise.all(
        orders.map(async (order) => {
          try {
            const productResponse = await fetchProductById(order.productId);
            const product = productResponse.data;
            return { ...order, product };
          } catch (error) {
            console.error(`Error fetching product ${order.productId}:`, error);
            return order;
          }
        })
      );
      setOrders(orderWithProductDetails);
    };

    if (orders.length > 0) {
      fetchProductDetails();
    }
  }, [orders]);

  const totalPrice = orders.reduce((acc, order) => {
    return acc + (order.product ? order.product.price * order.quantity : 0);
  }, 0);

  const totalItems = orders.reduce((acc, order) => acc + order.quantity, 0);

  const handleRemoveOrder = async (orderId) => {
    const isConfirmed = window.confirm(
      "Are you sure you want to remove this item from your cart?"
    );
    if (isConfirmed) {
      try {
        await deleteOrder(orderId);

        const updatedOrders = orders.filter((order) => order.id !== orderId);
        setOrders(updatedOrders);

        console.log(`Order with ID ${orderId} removed successfully.`);
        window.location.reload();
      } catch (error) {
        console.error(`Error removing order with ID ${orderId}:`, error);
      }
    }
  };

  if (isLoading) {
    return <div>Loading...</div>;
  }

  return (
    <div className="cart-container">
      {orders.length === 0 ? (
        <div className="empty">
          Your Cart is Still Empty
          <br />
          <img
            src="/src/assets/images/cart.png"
            alt="Empty Cart"
            width="150"
            height="150"
          />
        </div>
      ) : (
        <div className="cart-container">
          <div className="title">
            <h2>Your Cart</h2>
            <h3>{totalItems} Items</h3>
          </div>
          <ul className="all">
            {orders.map((order) => (
              <li className="oneOrder" key={order.id}>
                <br />
                {order.product && (
                  <>
                    <div>
                      <strong>{order.product.name}</strong>
                    </div>
                    <br />

                    <div>Quantity: {order.quantity}</div>
                    <br />
                    <div>Price: ${order.product.price}</div>
                    <br />
                    <div>Total: ${order.product.price * order.quantity}</div>
                  </>
                )}
                <br />
                <button
                  className="remove-btn"
                  onClick={() => handleRemoveOrder(order.id)}
                >
                  Remove from cart
                </button>
              </li>
            ))}
          </ul>
          <div className="total-price">
            <h3>Total: ${totalPrice}</h3>
          </div>
          <button className="order-btn">Order</button>
        </div>
      )}
    </div>
  );
};

export default Cart;
