import React from "react";

import "../styles/Home.css";
import Footer from "../components/Footer";

const Home = () => {
  return (
    <>
      <div>
        <div>
          <div>
            <h2 className="hometitle">
              Get It Delivered to Your Doorstep with Just One Click!{" "}
            </h2>
          </div>
          <div className="descrip">
            Welcome to our online store, where shopping is made simple,
            convenient, and secure.
            <br /> Explore a wide range of products from the comfort of your
            home and have them delivered right to your front door.
            <br />
            Whether you're looking for the latest fashion trends, electronics,
            home essentials, or gifts for loved ones, we've got you covered.{" "}
            <br />
            Start browsing now and experience hassle-free shopping at its best!
          </div>
          <button className="startButton">start</button>
          <div className="gif-container">
            <img
              src="src\assets\images\Shopping.gif"
              alt="Sample GIF"
              width="300"
            />
          </div>
        </div>
      </div>
      
    </>
  );
};

export default Home;
