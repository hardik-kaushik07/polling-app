# 🗳️ Polling Application (Spring Boot + JWT)

## 📌 Overview
This is a secure Polling/Voting System built using Spring Boot. It implements JWT-based authentication and role-based authorization.

- 👤 USER → Can view polls and vote (only once per poll)
- 👑 ADMIN → Full control (Create, Update, Delete polls)

---

## 🚀 Features

- 🔐 JWT Authentication & Authorization
- 👥 Role-Based Access Control (USER / ADMIN)
- 🗳️ Create and manage polls
- ✅ One user can vote only once
- 📊 Fetch poll results
- 🌐 REST API architecture

---

## 🛠️ Tech Stack

- Java
- Spring Boot
- Spring Security
- JWT (JSON Web Token)
- Spring Data JPA
- MySQL
- Lombok

---

## 📂 Project Structure
com.hardik.pollingapp
│── Configuration
│── Controller
│── Model
│── Repository
│── Service

## ⚙️ Setup Instructions

### 1. Clone Repository
git clone https://github.com/hardik-kaushik07/polling-app.git
cd polling-app


### 2. Configure Database

Update application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/your_db
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update

### 3. Run Application
mvn spring-boot:run


🔑 API Endpoints
🔐 Auth
POST /login
POST /register
🗳️ Polls
GET /poll → Get all polls (USER, ADMIN)
GET /poll/{id} → Get poll by ID
POST /polls → Create poll (ADMIN)
DELETE /delete/{id} → Delete poll (ADMIN)
🗳️ Voting
POST /vote/{pollId}/{optionIndex} → Vote (only once)


🔒 Security
Password encrypted using BCrypt
JWT token-based authentication
Role-based authorization using @PreAuthorize


📌 Future Improvements
Refresh Token support
Poll expiration time
UI (React frontend)
Analytics dashboard


👨‍💻 Author
Hardik Kaushik

⭐ If you like this project
Give it a star ⭐ on GitHub!
