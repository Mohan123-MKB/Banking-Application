# 🏦 Banking Application (CRUD REST API)

A simple **Banking Management Application** built with **Spring Boot**, demonstrating **CRUD operations** and **RESTful API design**.  
The application supports creating accounts, viewing account details, depositing money, withdrawing money, and retrieving all accounts.  
Data is stored in **MySQL**, and APIs are tested with **Postman**.

---

## 🚀 Project Description

This project is a backend-only application for managing bank accounts.  
It follows **layered architecture** (Controller → Service → Repository → Database) and uses **DTOs** to transfer data safely between layers.  

### Core Features:
- Create a new account
- Get account by ID
- Get all accounts
- Deposit money
- Withdraw money (with balance check)
- Delete account

---

## 🛠️ Tech Stack

- **Backend Framework**: Spring Boot (Java 17+)
- **Database**: MySQL
- **ORM**: Spring Data JPA (Hibernate)
- **API Testing**: Postman
- **Build Tool**: Maven/Gradle
- **Java Libraries**: 
  - `spring-boot-starter-web`
  - `spring-boot-starter-data-jpa`
  - `mysql-connector-j`
  - DTO + Mapper classes for clean architecture

---

## 📂 Project Structure

src/main/java/com/example/banking_app/
│
├── controller # REST Controllers (AccountController)
├── dto # Data Transfer Objects (AccountDto)
├── entity # JPA Entities (Account)
├── mapper # Entity ↔ DTO Mappers
├── repository # Spring Data JPA Repositories (AccountRepo)
├── service # Service Interfaces
├── service/implement # Service Implementations
└── DemoApplication.java


---

## ⚡ API Endpoints

### 1. Create Account
`POST /api/accounts`  
Request Body:
```json
{
  "accountHolderName": "John Doe",
  "balance": 1000
}

2. Get Account By ID

GET /api/accounts/{id}

3. Get All Accounts

GET /api/accounts

4. Deposit Money

PUT /api/accounts/{id}/deposit?amount=500

5. Withdraw Money

PUT /api/accounts/{id}/withdraw?amount=300

6. Delete Account

DELETE /api/accounts/{id}

🧪 Testing

All APIs tested using Postman.

Database persistence verified in MySQL Workbench.

🎯 Skills Gained

Building RESTful APIs with Spring Boot.

Applying CRUD operations using Spring Data JPA.

Using DTOs and Mappers for clean architecture.

Exception handling (orElseThrow, custom messages).

Dependency Injection (@Service, @Repository, @Autowired).

Integration with MySQL database.

Testing APIs with Postman.

Following layered architecture (Controller → Service → Repository).

