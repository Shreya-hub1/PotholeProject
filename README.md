# 🛣️ Pothole Detection & Reporting System

## 📌 Project Overview

The **Pothole Detection & Reporting System** is a web-based application that allows users to report, view, update, and manage potholes efficiently. It uses Java Servlets, MySQL, and Apache Tomcat to provide a complete CRUD-based solution with user authentication.

---

## 🚀 Features

* 🔐 User Registration & Login
* ➕ Add Pothole (location, area, severity)
* 📋 View All Potholes
* ✏️ Update Pothole Status (e.g., Fixed)
* ❌ Delete Pothole
* 👤 Session Management (login/logout)
* 🔗 Each pothole linked to a user (`reported_by`)

---

## 🛠️ Technologies Used

* **Frontend:** HTML, CSS, JavaScript
* **Backend:** Java (Servlets)
* **Database:** MySQL
* **Server:** Apache Tomcat
* **Tools:** VS Code

---

## 🗄️ Database Structure

### 🔹 Users Table

| Column   | Type     |
| -------- | -------- |
| user_id  | INT (PK) |
| username | VARCHAR  |
| password | VARCHAR  |

### 🔹 Potholes Table

| Column      | Type     |
| ----------- | -------- |
| pothole_id  | INT (PK) |
| location    | VARCHAR  |
| area        | VARCHAR  |
| severity    | VARCHAR  |
| status      | VARCHAR  |
| reported_by | INT (FK) |

---

## ⚙️ Setup Instructions

### 1️⃣ Clone the Repository

```bash
git clone https://github.com/your-username/pothole-project.git
```

---

### 2️⃣ Setup Database

```sql
CREATE DATABASE pothole_db;

USE pothole_db;

CREATE TABLE users (
    user_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(100),
    password VARCHAR(100)
);

CREATE TABLE potholes (
    pothole_id INT AUTO_INCREMENT PRIMARY KEY,
    location VARCHAR(255),
    area VARCHAR(100),
    severity VARCHAR(50),
    status VARCHAR(50) DEFAULT 'Reported',
    reported_by INT,
    FOREIGN KEY (reported_by) REFERENCES users(user_id)
);
```

---

### 3️⃣ Configure MySQL in Java

Update your password in all `.java` files:

```java
DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/pothole_db",
    "root",
    "your_password"
);
```

---

### 4️⃣ Deploy on Tomcat

* Copy project folder to:

```
apache-tomcat/webapps/PotholeProject/
```

* Place `.class` files in:

```
WEB-INF/classes/
```

---

### 5️⃣ Run Project

* Start Tomcat:

```
startup.bat
```

* Open in browser:

```
http://localhost:8080/PotholeProject/login.html
```

---

## 🔄 Application Flow

1. User registers or logs in
2. User reports pothole
3. Data stored in database
4. User can view/update/delete potholes
5. Admin or user marks pothole as fixed

---

## 🎯 Future Enhancements

* 📍 GPS-based location tracking
* 📷 Image upload for potholes
* 📊 Admin dashboard
* 📱 Mobile app integration

---

## 👩‍💻 Author

* **Shreya Pachore**

---

## ⭐ Conclusion

This project demonstrates full-stack development using Java Servlets and MySQL with proper database relationships and CRUD operations.

---
