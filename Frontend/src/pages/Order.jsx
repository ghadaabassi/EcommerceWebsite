import React, { useState } from "react";
import { createOrder } from "../api/Api";

const Order = ({ productId }) => {
  const [quantity, setQuantity] = useState(1);

  const handleSubmit = async (e) => {
    e.preventDefault();
    const order = { productId, quantity };
    await createOrder(order);
    alert("Order placed successfully");
  };

  return (
    <form onSubmit={handleSubmit}>
      <label>
        Quantity:
        <input
          type="number"
          value={quantity}
          onChange={(e) => setQuantity(e.target.value)}
          min="1"
        />
      </label>
      <button type="submit">Place Order</button>
    </form>
  );
};

export default Order;
