# E-Commerce Microservices Project

## Overview
This project is a full-stack E-Commerce system built using Spring Boot and MySQL with a microservices architecture.

The project contains:

- E-Commerce Service
- Payment Service (Microservice)
- JWT Authentication
- Docker & Docker Compose Support
- REST APIs
- Frontend Integration

---

# Technologies Used

## Backend
- Java 17
- Spring Boot
- Spring Security
- Spring Data JPA
- Hibernate
- JWT Authentication
- Maven

## Database
- MySQL 8

## DevOps
- Docker
- Docker Compose

---

# Project Structure

project-root/

├── ecommerce/
│   ├── src/
│   ├── Dockerfile
│   ├── docker-compose.yml
│   └── pom.xml

├── payment-service/
│   ├── src/
│   ├── Dockerfile
│   └── pom.xml

└── frontend/

---

# Features

## Authentication
- User Registration
- User Login
- JWT Token Authentication

## Products
- Add Products
- Update Products
- Delete Products
- Get All Products

## Orders
- Create Orders
- View Orders
- Update Order Status

## Payments
- Separate Payment Microservice
- Cash Payment
- Visa/Card Payment
- Payment Status Tracking

---

# Microservices Architecture

The project uses a microservice architecture where:

- ecommerce-service handles:
  - Users
  - Products
  - Orders

- payment-service handles:
  - Payments
  - Payment status
  - Payment methods

The services communicate using REST APIs.

---

# Running the Project Locally

## 1. Clone the Repository

git clone <your-repository-url>

cd ecommerce

---

## 2. Configure MySQL

Create databases:

CREATE DATABASE ecommerce;

CREATE DATABASE payment_db;

---

## 3. Configure application.properties

### Ecommerce Service

spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce

spring.datasource.username=root

spring.datasource.password=your_password

### Payment Service

spring.datasource.url=jdbc:mysql://localhost:3306/payment_db

spring.datasource.username=root

spring.datasource.password=your_password

---

## 4. Run the Services

### Ecommerce Service

mvn spring-boot:run

Runs on:

http://localhost:8080

### Payment Service

mvn spring-boot:run

Runs on:

http://localhost:8081

---

# Docker Setup

## Build Docker Image

docker build -t ecommerce-app .

---

## Run with Docker Compose

docker compose up --build

---

# API Endpoints

## User APIs

POST /api/users/register

POST /api/users/login

---

## Product APIs

GET /api/products

POST /api/products

PUT /api/products/{id}

DELETE /api/products/{id}

---

## Order APIs

GET /api/orders

POST /api/orders

---

## Payment APIs

GET /api/payments

POST /api/payments/pay

---

# Security

The project uses:

- JWT Authentication
- Spring Security
- Protected APIs
- Role-based access control

---

# Future Improvements

- API Gateway
- Service Discovery
- Email Notifications
- Stripe Payment Integration
- Deployment on Cloud
- CI/CD Pipeline

---

# Author

Mohammed Adel