# CRUD JWT Spring Boot API

This is a secure Spring Boot API implementing CRUD operations and JWT authentication.
---
## Technologies Used

### 1. Spring Boot

Spring Boot is a popular Java-based framework used for building stand-alone, production-grade Spring-based applications. It provides a convention-over-configuration approach, making it easy to create and configure Spring applications with minimal setup and boilerplate code.

- **Description**:
  Spring Boot simplifies the process of creating and deploying Spring applications by providing a set of pre-configured starters and auto-configuration options. It promotes rapid development and microservices architecture.

- **Key Features**:
  - Embedded HTTP servers (Tomcat, Jetty, or Undertow).
  - Auto-configuration of Spring and third-party libraries.
  - Production-ready features such as metrics, health checks, and externalized configuration.
  - Built-in support for Spring Security, data access, messaging, and more.
  - Easily deployable as standalone JAR files or traditional WAR files.

- **Usage**:
  Spring Boot is widely used in enterprise web development, microservices architecture, and cloud-native application development. It's the backbone of many modern Java-based web applications and APIs.

### 2. MySQL

MySQL is a popular open-source relational database management system (RDBMS) known for its reliability, scalability, and performance. It's widely used in web development for storing and managing structured data.

- **Description**:
  MySQL provides a powerful SQL-based database solution suitable for various applications ranging from small websites to large-scale enterprise systems. It supports features like transactions, indexes, foreign keys, and stored procedures.

- **Key Features**:
  - ACID compliance (Atomicity, Consistency, Isolation, Durability).
  - Scalability options such as replication and sharding.
  - Support for various storage engines including InnoDB, MyISAM, and MEMORY.
  - Security features such as user authentication, access control, and SSL encryption.
  - Compatibility with various operating systems and programming languages.

- **Usage**:
  MySQL is widely used in web development, content management systems, e-commerce platforms, and various other applications that require efficient data storage and retrieval.

---
## Features

- **User Authentication**: Secure login mechanism using JWT tokens.
- **Blogs Management**: Create, read, update, and delete blogs.
- **Validation**: Payload validation to ensure data integrity.
- **Error Handling**: Custom error messages for better user experience.

---
## Importing Database

- **Database Setup**:
  - Ensure you have MySQL installed on your system.
  - Create a database named `db_crud_jwt`.
  - You can use any MySQL management tool like phpMyAdmin or MySQL Workbench to create the database.

## Configuring `application.yml`

Ensure to configure the `application.yml` file correctly to connect your Spring Boot application with the MySQL database and configure JWT security.

```yaml
server:
  port: 8081
  include-message: always

spring:
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
  datasource:
    url: jdbc:mysql://${MYSQL_HOST:localhost}:3306/db_crud_jwt
    username: root #adjust username in your config mysql
    password:      #adjust password in your config mysql
    driver-class-name: com.mysql.cj.jdbc.Driver
```

## Navigating to Application Directory

### Spring Boot Project

If you're working with a Spring Boot project, follow these steps to navigate to the application directory:

1. **Open Terminal/Command Prompt**:
  - Launch your terminal or command prompt application.

2. **Navigate to Project Directory**:
  - Use the `cd` command to change directory to the root directory of your Spring Boot project.
    ```bash
    cd path/to/your/spring-boot-project
    ```
    Replace `path/to/your/spring-boot-project` with the actual path to your Spring Boot project directory.

3. **Confirm Directory**:
  - Once you've navigated to the correct directory, you can verify it by listing the contents of the directory using the `ls` command (for Unix-based systems) or the `dir` command (for Windows):
    ```bash
    ls    # For Unix-based systems
    dir   # For Windows
    ```

4. **Ready to Run Commands**:
  - Now you're in the application directory of your Spring Boot project and ready to run Maven commands or perform other tasks related to your project.



## Maven Commands

### Clean

The `clean` command removes the build directory and all generated files from the previous build. It ensures a clean slate for the next build.

To clean your project using Maven, run the following command:

```bash
mvn clean
mvn package

java -jar target/filename.jar
```

## Endpoints

### Authentication


#### sign-up

- **Endpoint**: `POST {{base_url}}api/v1/auth/sign-up`
- **Description**: Endpoint for create new user.
- **Role**: `Admin(0),User(1)`
  - **Payload**:
    ```json
    {
      "email":"admin@gmail.com",
      "username":"admin",
      "password":"admin",
      "firstname":"Zayn",
      "lastname":"Malik",
      "adress":"Jln Ahmad Yani",
      "role":0
     }
    ```
  - **Success**:
    ```json
    {
        "message": "Success",
        "success": true,
        "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTYyMzUyMTM3MywiZXhwIjoxNjIzNTI0OTczfQ.QM20r0z7jpO91-70FZfqTj3JdQtbmbxOKoioCJt67bg",
        "refreshToken": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTYyMzUyMTM3MywiZXhwIjoxNjI4MDUzNzczfQ.bKGob7F2qrbfKwdQpBj-tNrFZMDYlZ0j3XZTggdQLVk"
    }
    ```


#### Sign-In

- **Endpoint**: `POST {{base_url}}api/v1/auth/sign-in`
- **Description**: Endpoint for user authentication.
- **Payload**:
  ```json
  {
      "username": "string",
      "password": "string"
  }
  ```
- **Success**:
```json
{
    "message": "Login Successful",
    "success": true,
    "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTYyMzUyMTM3MywiZXhwIjoxNjIzNTI0OTczfQ.QM20r0z7jpO91-70FZfqTj3JdQtbmbxOKoioCJt67bg",
    "refreshToken": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTYyMzUyMTM3MywiZXhwIjoxNjI4MDUzNzczfQ.bKGob7F2qrbfKwdQpBj-tNrFZMDYlZ0j3XZTggdQLVk"
}
```

- **Failed**:
```json
{
    "message": "Login Gagal",
    "success": false,
    "token": null,
    "refreshToken": null
}
```
## Blogs Management
#### Create Blog

- **Endpoint**: `POST {{base_url}}api/v1/blogs`
- **Description**: Endpoint to create a new blog.
- **Request Header**:
- `Authorization`: Bearer token JWT for authentication.
- **Request Body**: Form-data
    - `title`: Title of the blog.
    - `content`: Content of the blog.
    - `author`: Author of the blog.
    - `category`: Category of the blog.
    - `tags`: Tags associated with the blog.
    - `views`: Number of views for the blog.
    - `likes`: Number of likes for the blog.
    - `favorites`: Number of favorites for the blog.
    - `image`: Image associated with the blog.
    - `user`: User details associated with the blog.
  - **Success Response**:
    - If the blog is successfully created, it will return the created blog object with HTTP status code 201.
    ```json
       {
          "message": "success",
          "success": true
       }
    ```
  - **Error Duplicate Response**:
    - If the data already exists, it will return the following response with HTTP status code 409:
      ```json
      {
          "success": false,
          "time": "Sat May 11 18:15:52 WITA 2024",
          "message": "Data yang Anda masukkan sudah ada."
      }
      ```
  - **Error Validation data Response**:
    - Validation data , it will return the following response with HTTP status code 409:
      ```json
      {
      "success": false,
      "time": "Fri May 10 01:32:14 WITA 2024",
      "message": "Column 'author' cannot be null"
      }
      ```
  
#### Get Blogs

- **Endpoint**: `GET {{base_url}}api/v1/blogs/{page}/{size}`
- **Description**: Endpoint to fetch blogs by page.
- **Path Parameters**:
    - `page`: Page number.
    - `size`: Number of blogs per page.
- **Success Response**:
  ```json
  {
      "message": "success",
      "success": true,
      "data": [
          {
              "id": 1,
              "title": "Spring Boot update",
              "content": "Spring Boot Content Update",
              "author": "Zayn M",
              "category": "Spring Boot",
              "views": 1,
              "commentars": 1,
              "likes": 1,
              "favorites": 1,
              "user": {
                  "id": 2,
                  "username": "admin",
                  "email": "admin@gmail.com",
                  "firstname": "Zayn",
                  "lastname": "Malik"
              },
              "created": "2024-05-10T01:48:09.460198",
              "updated": "2024-05-10T01:52:46.164815"
          }
      ]
  }

#### Update Blog
- **Endpoint**: `POST {{base_url}}api/v1/blogs/{id}`
- **Request Header**:
- `Authorization`: Bearer token JWT for authentication.
- **Path Parameters**:
  - `id`: `ID Blog`.
- **Description**: Endpoint to update a blog.
  - **Request Body**: Form-data
    - `title`: Title of the blog.
    - `content`: Content of the blog.
    - `author`: Author of the blog.
    - `category`: Category of the blog.
    - `tags`: Tags associated with the blog.
    - `views`: Number of views for the blog.
    - `likes`: Number of likes for the blog.
    - `favorites`: Number of favorites for the blog.
    - `image`: Image associated with the blog.
    - `user`: User details associated with the blog.
    - **Success Response**:
      - If the blog is successfully update, it will return the created blog object with HTTP status code 201.
      ```json
         {
            "message": "success",
            "success": true
         }
      ```
- **Error Response**:
  - If the data invalid, it will return the following response with HTTP status code 404:
    ```json
          {
          "message": "ID Invalid",
          "success": false
          }
    ``` 

#### Delete Blog
- **Endpoint**: `DELETE {{base_url}}api/v1/blogs/{id}`
- **Path Parameters**:
  - `ID`: `ID Blog`.
- **Request Header**:
- `Authorization`: Bearer token JWT for authentication.
- **Description**: Endpoint to delete a blog.
 - **Success Response**:
      - If the blog is successfully delete, it will return the created blog object with HTTP status code 201.
      ```json
         {
            "message": "success",
            "success": true
         }
      ```
- **Error Response**:
  - If the data invalid, it will return the following response with HTTP status code 404:
    ```json
          {
          "message": "ID Invalid",
          "success": false
          }
    ``` 
