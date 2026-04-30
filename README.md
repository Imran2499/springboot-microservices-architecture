# 🚀 Spring Boot Microservices Architecture
  Production-ready microservices architecture using Spring Boot, Spring Cloud, Eureka, API Gateway, and Resilience4j Support
  
## 📌 Overview

This project demonstrates a **production-ready microservices architecture** built using Spring Boot and Spring Cloud.

It showcases key patterns used in modern distributed systems such as **service discovery, API gateway routing, centralized configuration, and fault tolerance**.


---

## 🧩 Architecture Components

* 🔍 **Eureka Server** – Service Discovery
* 🚪 **API Gateway** – Routing & filtering
* ⚙️ **Config Server** – Centralized configuration
* 🛡️ **Circuit Breaker** – Resilience4j for fault tolerance
* 📦 **Microservices**:

  * User Service
  * Order Service
  * Payment Service

---

## 🏗️ Architecture Flow

Client → API Gateway → Microservices → Eureka Server

---

## ⚙️ Tech Stack

* Java 17
* Spring Boot
* Spring Cloud
* Eureka Server
* Spring Cloud Gateway
* Resilience4j
* MySQL
* Docker

---

## 🚀 Getting Started

### 🔧 Prerequisites

* Java 17
* Maven
* Docker

---

### ▶️ Run Locally (Without Docker)

1. Start **Config Server**
2. Start **Eureka Server**
3. Start **API Gateway**
4. Start all Microservices

---

## 📡 Sample Endpoints

| Service         | Endpoint    | Description    |
| --------------- | ----------- | -------------- |
| User Service    | `/users`    | Fetch users    |
| Order Service   | `/orders`   | Fetch orders   |
| Payment Service | `/payments` | Fetch payments |

Access via API Gateway:

```
http://localhost:8080/users
http://localhost:8080/orders
http://localhost:8080/payments
```

---

## 📷 Screenshots

(Add your screenshots here)

* Eureka Dashboard
* API Gateway Routing
* Service Responses (Postman)

---

## 🎯 Key Features

* Service Discovery using Eureka
* Centralized Configuration
* API Gateway Routing
* Fault Tolerance (Circuit Breaker)
* Scalable Microservices Architecture

---

## 📁 Project Structure

```
springboot-microservices-architecture/
│
├── config-server/
├── eureka-server/
├── api-gateway/
├── user-service/
├── order-service/
├── payment-service/
│
└── README.md
```

---

## 👤 Author

**Imran Pasha**

---

## 📌 Notes

This project is designed to demonstrate **real-world backend architecture concepts** and is suitable for showcasing microservices expertise to recruiters.
