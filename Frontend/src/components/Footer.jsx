import React from "react";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import {
  faFacebookF,
  faTwitter,
  faInstagram,
} from "@fortawesome/free-brands-svg-icons";
import {
  faGem,
  faHome,
  faEnvelope,
  faPhone,
  faPrint,
} from "@fortawesome/free-solid-svg-icons";
import "bootstrap/dist/css/bootstrap.min.css";

const Footer = () => {
  return (
    <footer className="bg-light text-center text-lg-start text-muted">
      <section className="d-flex justify-content-center justify-content-lg-between p-4 border-bottom">
        <div className="me-5 d-none d-lg-block">
          <span>Get connected with us on social networks:</span>
        </div>
        <div>
          <a href="#" className="me-4 text-reset">
            <FontAwesomeIcon icon={faFacebookF} />
          </a>
          <a href="#" className="me-4 text-reset">
            <FontAwesomeIcon icon={faTwitter} />
          </a>
          <a href="#" className="me-4 text-reset">
            <FontAwesomeIcon icon={faInstagram} />
          </a>
        </div>
      </section>

      <section className="">
        <div className="container text-center text-md-start mt-5">
          <div className="row mt-3">
            <div className="col-md-3 col-lg-4 col-xl-3 mx-auto mb-4">
              <h6 className="text-uppercase fw-bold mb-4">
                <FontAwesomeIcon icon={faGem} className="me-3" />
                Shoppify
              </h6>
              <p>Best In the World</p>
            </div>

            <div className="col-md-2 col-lg-2 col-xl-2 mx-auto mb-4">
              <h6 className="text-uppercase fw-bold mb-4">Products</h6>
              <p>
                <a href="#!" className="text-reset">
                  Clothes
                </a>
              </p>
              <p>
                <a href="#!" className="text-reset">
                  Home
                </a>
              </p>
              <p>
                <a href="#!" className="text-reset">
                  Jewelery
                </a>
              </p>
              <p>
                <a href="#!" className="text-reset">
                  Sports
                </a>
              </p>
            </div>

            <div className="col-md-3 col-lg-2 col-xl-2 mx-auto mb-4">
              <h6 className="text-uppercase fw-bold mb-4">Useful links</h6>
              <p>
                <a href="#!" className="text-reset">
                  Pricing
                </a>
              </p>
              <p>
                <a href="#!" className="text-reset">
                  Settings
                </a>
              </p>
              <p>
                <a href="#!" className="text-reset">
                  Orders
                </a>
              </p>
              <p>
                <a href="#!" className="text-reset">
                  Help
                </a>
              </p>
            </div>

            <div className="col-md-4 col-lg-3 col-xl-3 mx-auto mb-md-0 mb-4">
              <h6 className="text-uppercase fw-bold mb-4">Contact</h6>
              <p>
                <FontAwesomeIcon icon={faHome} className="me-2" /> New York, NY
                10012, US
              </p>
              <p>
                <FontAwesomeIcon icon={faEnvelope} className="me-3" />{" "}
                Shopp@gmail.com
              </p>
              <p>
                <FontAwesomeIcon icon={faPhone} className="me-3" /> + 01 234 567
                88
              </p>
              <p>
                <FontAwesomeIcon icon={faPrint} className="me-3" /> + 01 234 567
                89
              </p>
            </div>
          </div>
        </div>
      </section>

      <div
        className="text-center p-4"
        style={{ backgroundColor: "rgba(0, 0, 0, 0.05)" }}
      >
        © 2024 Copyright:
        <a className="text-reset fw-bold" href="https://mdbootstrap.com/">
          Shoppify.com
        </a>
      </div>
    </footer>
  );
};

export default Footer;
