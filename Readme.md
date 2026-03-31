# 🏨Grand Hotel Reservation System (Java + JDBC)

## 📌 Overview

This is a console-based Hotel Reservation System built using **Java and JDBC**.
The main goal of this project was to understand how backend systems work internally by applying concepts like **layered architecture, database interaction, and clean code structure**.

Instead of using frameworks, I focused on building everything using **core Java + JDBC** to strengthen my fundamentals.

---

## ⚙️ Features

* Reserve a room
* Check reservation by ID
* Check reservation by guest name (case-insensitive)
* Check reservation by room number

---

## 🛠️ Tech Stack

* Java
* JDBC
* MySQL
* VS Code

---

## 🧠 Architecture

The project follows a **layered architecture** approach:

Controller → Service → DAO → Database

* **Controller** → Handles user input/output
* **Service** → Contains business logic
* **DAO (Repository)** → Handles all database operations
* **Util** → Manages database connection

This helped me clearly separate responsibilities and understand how real backend systems are structured.

---

## 📂 Project Structure

```
src/
│
├── controller/
├── service/
├── repository/
├── model/
├── util/
└── exception/
```

---

## 🔄 How It Works

Example: *Reserve Room*

1. User enters details (name, room number, contact)
2. Controller receives input
3. Service processes request
4. DAO executes SQL query
5. Data is stored in MySQL database
6. Response is returned back to user

---

## 🔐 Configuration

Database credentials are stored in a `config.properties` file (not included in repo for security reasons).

Create your own file:

```
config.properties
```

Example:

```
db.url=jdbc:mysql://localhost:3306/your_database
db.username=root
db.password=your_password
```

---

## 🚀 How to Run

1. Clone the repository
2. Create your `config.properties` file
3. Make sure MySQL is running
4. Compile and run from `src` folder:

```
cd src
javac controller/HotelReservationSystem.java
java controller.HotelReservationSystem
```

---

## 📈 What I Learned

* How to structure a backend project using layers
* JDBC concepts (Connection, PreparedStatement, ResultSet)
* Handling database operations cleanly
* Importance of separation of concerns
* Basics of transaction handling

---

## 🔮 Future Improvements

* Add transaction management for booking flow
* Convert project to **Spring Boot REST API**
* Connect with frontend UI
* Add validation and exception handling improvements

---

## 💬 Final Note

This project helped me move from just learning concepts to actually applying them in a real scenario.
I’ll continue improving this by adding more features and integrating it with modern backend frameworks.

---
