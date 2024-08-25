# Multiple Data Sources with Spring Boot

[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.3.0-blue)](https://spring.io/projects/spring-boot)
[![Java](https://img.shields.io/badge/Java-17-blue)](https://www.oracle.com/java/)

This project demonstrates how to configure and use multiple data sources in a Spring Boot application. It provides a practical example of integrating multiple MySQL databases and managing them effectively using Spring Data JPA.

## Table of Contents

- [Features](#features)
- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
  - [Clone the Repository](#clone-the-repository)
  - [Database Setup](#database-setup)
  - [Configuration](#configuration)
  - [Build and Run](#build-and-run)
- [Project Structure](#project-structure)
- [Usage](#usage)
  - [API Endpoints](#api-endpoints)
  - [Sample Requests](#sample-requests)
- [Testing](#testing)
- [Technologies Used](#technologies-used)
- [Contributing](#contributing)
- [Contact](#contact)

## Features

- **Multiple Data Source Configuration**: Easily configure and manage multiple MySQL databases within a single Spring Boot application.
- **Spring Data JPA Integration**: Utilize Spring Data JPA for seamless interaction with databases.
- **RESTful APIs**: Expose CRUD operations through RESTful endpoints for each data source.
- **Transaction Management**: Handle transactions effectively across different data sources.
- **Exception Handling**: Robust error and exception handling mechanisms.
- **Unit and Integration Testing**: Comprehensive testing setup using JUnit and Mockito.

## Prerequisites

- **Java 17** or higher installed on your system.
- **Maven 3.3.2** (maven wrapper available inside the project).
- **MySQL** instances set up and running.
- An IDE of your choice (e.g., IntelliJ IDEA, Eclipse).

## Getting Started

Follow these instructions to set up and run the project on your local machine.

### Clone the Repository

```bash
git clone https://github.com/Sachith97/multiple-datasources.git
cd multiple-datasources
```

### Database Setup

1. Set up two MySQL databases (e.g., `database1` and `database2`).
2. Create necessary tables and seed data as per your application requirements.
3. Ensure both databases are accessible and running.

### Configuration

Configure your database connection details in the `application.yml` file located in `src/main/resources/`.

```yaml
spring:
  datasource:
    primary:
      url: jdbc:mysql://localhost:3306/database1
      username: your_username_db1
      password: your_password_db1
      driver-class-name: com.mysql.cj.jdbc.Driver
    secondary:
      url: jdbc:mysql://localhost:3306/database2
      username: your_username_db2
      password: your_password_db2
      driver-class-name: com.mysql.cj.jdbc.Driver
  jpa:
    show-sql: true
```

**Note**: Replace `database1`, `database2`, `your_username_db1`, `your_password_db1`, `your_username_db2`, and `your_password_db2` with your actual database credentials.

### Build and Run

You can build and run the application using Maven.

**Using Maven Wrapper**

```bash
./mvnw clean install
./mvnw spring-boot:run
```

**Using Maven**

```bash
mvn clean install
mvn spring-boot:run
```

The application will start running at `http://localhost:8080`.

## Project Structure

```bash
multiple-datasources/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── sac/
│   │   │           └── multiple_datasource/
│   │   │               ├── config/
│   │   │               │   ├── PrimaryDatasourceConfig.java
│   │   │               │   └── SecondaryDatasourceConfig.java
│   │   │               ├── controller/
│   │   │               │   ├── UserController.java
│   │   │               │   └── BillingProfileController.java
│   │   │               ├── dto/
│   │   │               │   ├── BillingProfileDTO.java
│   │   │               │   └── UserBillingProfileDTO.java
│   │   │               ├── exception/
│   │   │               │   └── Response.java
│   │   │               ├── model/
│   │   │               │   ├── primary/
│   │   │               │   │   └── User.java
│   │   │               │   └── secondary/
│   │   │               │       └── BillingProfile.java
│   │   │               ├── repo/
│   │   │               │   ├── primary/
│   │   │               │   │   └── UserRepository.java
│   │   │               │   └── secondary/
│   │   │               │       └── BillingProfileRepository.java
│   │   │               ├── service/
│   │   │               │   ├── UserService.java
│   │   │               │   ├── BillingProfileService.java
│   │   │               │   └── impl/
│   │   │               │       ├── UserServiceImpl.java
│   │   │               │       └── BillingProfileServiceImpl.java
│   │   │               └── MultipleDataSourcesApplication.java
│   │   └── resources/
│   │       └── application.yml
│   └── test/
│       └── java/
│           └── com/
│               └── sac/
│                   └── multiple_datasource/
│                       ├── controller/
│                       │   ├── UserControllerTest.java
│                       │   └── BillingProfileControllerTest.java
│                       ├── service/
│                       │   ├── UserServiceTest.java
│                       │   └── BillingProfileServiceTest.java
│                       └── MultipleDataSourcesApplicationTests.java
├── pom.xml
└── README.md
```

## Usage

### API Endpoints

The application exposes RESTful APIs for performing CRUD operations on both databases.

#### User APIs

- **Get All Users**
  - **Endpoint**: `GET /api/users`
  - **Description**: Retrieves a list of all users.

- **Get User Billing Profiles**
  - **Endpoint**: `GET /api/users/get-billing-profiles`
  - **Description**: Retrieves users and each user's billing profile list.

- **Create User**
  - **Endpoint**: `POST /api/users`
  - **Description**: Creates a new user.
  - **Body**:
    ```json
    {
      "firstName": "John",
      "lastName": "Doe",
      "empId": "10000",
      "status": "Active",
      "createdBy": "SYSTEM"
    }
    ```

- **Update User**
  - **Endpoint**: `PUT /api/users/{id}`
  - **Description**: Updates an existing user.
  - **Body**:
    ```json
    {
      "firstName": "John",
      "lastName": "Doe",
      "empId": "10000",
      "status": "Active",
      "updatedBy": "SYSTEM"
    }
    ```

- **Delete User**
  - **Endpoint**: `DELETE /api/users/{id}`
  - **Description**: Deletes a user by their ID.

#### Billing Profile APIs

- **Create Billing Profile**
  - **Endpoint**: `POST /api/billing-profile`
  - **Description**: Creates a new billing profile.
  - **Body**:
    ```json
    {
      "userEmpId": "10000",
      "addressLineOne": "Add A-1",
      "addressLineTwo": "Add A-2",
      "addressLineThree": "Add A-3",
      "createdBy": "SYSTEM"
    }
    ```

- **Delete Billing Profile**
  - **Endpoint**: `DELETE /api/billing-profile/{id}`
  - **Description**: Deletes a billing profile by its ID.

### Sample Requests

**Creating a New User**

```bash
POST /api/users
Content-Type: application/json

{
  "firstName": "John",
  "lastName": "Doe",
  "empId": "10000",
  "status": "Active",
  "createdBy": "SYSTEM"
}
```

**Response**

```json
{
  "id": 1,
  "firstName": "John",
  "lastName": "Doe",
  "empId": "10000",
  "status": "Active",
  "createdBy": "SYSTEM",
  "createdOn": "2024-08-25T12:34:56Z",
  "updatedBy": "SYSTEM",
  "updatedOn": "2024-08-25T12:34:56Z"
}
```

**Fetching User Billing Profiles**

```bash
GET /api/users/get-billing-profiles
```

**Response**

```json
[
  {
    "userName": "John Doe",
    "empId": "10000",
    "billingProfileList": [
      {
      	"id": 1,
        "addressLineOne": "Add A-1",
        "addressLineTwo": "Add A-2",
        "addressLineThree": "Add A-3",
        "createdBy": "SYSTEM",
        "createdOn": "2024-08-25T12:34:56Z"
      }
    ]
  }
]
```

## Testing

The project includes unit and integration tests to ensure the reliability and correctness of the application.

**Running Tests**

```bash
mvn test
```

The tests cover service layers and controller endpoints using JUnit and Mockito frameworks.

## Technologies Used

- **Java 17**
- **Spring Boot 3.3.0**
- **Spring Data JPA**
- **MySQL5**
- **Maven**
- **JUnit 5**
- **Mockito**
- **Lombok**
- **ModelMapper**

## Contributing

Contributions are welcome! Please follow these steps:

1. **Fork** the repository.
2. **Create** a new branch for your feature or bugfix.
   ```bash
   git checkout -b feature/your-feature-name
   ```
3. **Commit** your changes.
   ```bash
   git commit -m "Add your message here"
   ```
4. **Push** to your branch.
   ```bash
   git push origin feature/your-feature-name
   ```
5. **Open** a pull request describing your changes.

Please ensure your code follows the project's coding standards and includes appropriate tests.

## Contact

**Sachith97**

- **Email**: [sachith.harsha97@gmail.com](mailto:sachith.harsha97@gmail.com)
- **GitHub**: [Sachith97](https://github.com/Sachith97)

Feel free to reach out for any inquiries or support regarding this project.

---
