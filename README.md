# Tutorial Management System with Hibernate

This is a simple tutorial management system implemented using Java and Hibernate. It allows you to perform basic operations like adding, retrieving, updating, and deleting tutorials in a MySQL database.

## Project Structure

The project is organized as follows:

- `src/main/java/org/example`: Contains the Java source code.
  - `model`: Defines the data model for tutorials.
  - `dao`: Provides data access to interact with the database.
  - `service`: Contains the service layer to manage tutorials.
  - `service/impl`: Implements the service layer.
- `resources`: Contains the Hibernate configuration file (`hibernate.cfg.xml`).
- `pom.xml`: The Maven project configuration file.

## Dependencies

- Java
- Hibernate
- MySQL
- Maven


## How to Use

1. Ensure you have Java, MySQL, and Maven installed on your system.

2. Configure the MySQL database connection in `hibernate.cfg.xml`. Modify the following properties according to your MySQL setup:

    ```xml
    <property name="connection.url">jdbc:mysql://localhost:3306/db_practice</property>
    <property name="connection.username">root</property>
    <property name="connection.password">root</property>
    ```


3. Run the `App` class, which serves as the main application, to perform various operations on tutorials.

## Functionality

- Adding new tutorials to the database.
- Retrieving tutorials by ID.
- Retrieving all tutorials.
- Retrieving all published tutorials.
- Updating existing tutorials.
- Deleting tutorials by ID.

## Clone the Repository

You can clone this repository to your local machine using Git. Open your terminal and run the following command:

```bash
git clone https://github.com/sh4on/tutorial-management-with-hibernate.git