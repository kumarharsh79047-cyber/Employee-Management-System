# Employee-Management-System


# 👥 Employee Management SystemA **Java-based desktop application** for managing employee records efficiently. This system provides a user-friendly interface to handle all essential employee management operations.![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)![Desktop App](https://img.shields.io/badge/Desktop-Application-blue?style=for-the-badge)---## 📋 Features- ✅ **Add New Employees** - Register new employee records with complete details- ✅ **View Employee List** - Browse all employees in an organized table format- ✅ **Update Employee Information** - Modify existing employee records- ✅ **Delete Employee Records** - Remove employees from the system- ✅ **Search Functionality** - Find employees by ID, name, or department- ✅ **User-Friendly GUI** - Clean and intuitive desktop interface---## 🛠️ Technologies Used| Technology | Purpose ||------------|---------|| Java | Core programming language || Swing/JavaFX | GUI Framework || JDBC | Database connectivity || MySQL/SQLite | Database (configured locally) |---## ⚠️ Important: Database Configuration> **Note:** The database is **NOT included** in this repository.Each user must configure their own database locally. This is intentional because:- Database credentials should remain private- Each system may have different database configurations- Security best practices recommend not uploading database files to public repositories### 🗄️ Database Setup Instructions1. **Install MySQL/SQLite** on your local machine2. **Create a new database:**   ```sql   CREATE DATABASE employee_management;

Create the required tables:
sqlUSE employee_management;CREATE TABLE employees (    emp_id INT PRIMARY KEY AUTO_INCREMENT,    name VARCHAR(100) NOT NULL,    email VARCHAR(100),    phone VARCHAR(15),    department VARCHAR(50),    designation VARCHAR(50),    salary DECIMAL(10, 2),    join_date DATE,    address TEXT);


Update database credentials in the configuration file:
java// Update these values in your DBConnection.java or config fileprivate static final String URL = "jdbc:mysql://localhost:3306/employee_management";private static final String USERNAME = "your_username";private static final String PASSWORD = "your_password";

