import React from "react";
import { Container, Row, Col, Card, Button } from "react-bootstrap";
import "bootstrap/dist/css/bootstrap.min.css";

import "../styles/AboutUs.css";

const AboutUs = () => {
  return (
    <Container className="mt-4">
      <h1 className="text-center mb-4">About Us</h1>
      <Row className="mb-4">
        <Col lg={6} className="text-center">
          <h3>Our Mission</h3>
          <img
            src="\src\assets\images\miss.jpg"
            alt="team"
            width="350"
            height="350"
          />
          <p className="about-text">
            Our mission is to revolutionize the way people interact with
            technology by crafting innovative solutions that simplify everyday
            tasks and enhance user experiences.
          </p>
        </Col>
        <Col lg={6} className="text-center">
          <h3>Our Team</h3>
          <ul className="about-team list-unstyled">
            <img
              src="\src\assets\images\team.jpg"
              alt="team"
              width="350"
              height="350"
            />
            <li>John Doe - CEO</li>
            <li>Jane Smith - CTO</li>
            <li>Michael Johnson - Marketing Director</li>
          </ul>
        </Col>
      </Row>
      <Row className="mb-4">
        <Col className="text-center">
          <h3>Our Vision</h3>
          <img
            src="\src\assets\images\vision.jpg"
            alt="team"
            width="350"
            height="350"
          />
          <p className="about-text">
            Our vision is to create a world where technology seamlessly
            integrates into every aspect of life, enriching human connections
            and enabling limitless possibilities. We aspire to be pioneers in
            driving technological advancements that foster sustainable growth,
            foster inclusivity, and elevate the quality of life for people
            around the globe.
          </p>
        </Col>
      </Row>
      <Row className="text-center">
        <Col>
          <Button style={{ backgroundColor: "#b287d7" }} variant="primary">
            Join Our Team
          </Button>
          <br />
          <br />
        </Col>
      </Row>
    </Container>
  );
};

export default AboutUs;
