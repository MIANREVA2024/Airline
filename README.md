# Airline
## Project Description
The project aims to develop a management system for an airline using Spring with Spring Boot and
Spring Security. This system will allow comprehensive management of users, flights, reservations and
destinations, with advanced functionalities such as secure authentication using Basic Auth or JWT.
The system cannot allow the selection of flights without available seats or that have exceeded the deadline.
The project will be implemented using Java 21, Maven and MySQL or PostgreSQL.

## 🎯 Project objectives:

* Reinforce API creation concepts.
* Apply DB relationships.
* Establish login knowledge with Spring Security and Basic Auth or JWT.

⚙️ Project functional requirements:

1. Customer Management.
2. Registration, authentication and role management (ROLE_ADMIN and ROLE_USER).
3. Generation and validation of JWT tokens or session COOKIES if using Basic Auth for secure sessions.

⚙️ Flight management:

1. Flights should be automatically generated in the database at compile time (via .sql file).
2. Change the status of an available flight to “false” when the flight becomes unavailable or expires.

⚙️ Search engine:

1. Both the departure and destination airport must be indicated. The date and the number of seats to be booked. It is not necessary to indicate the type of seats.

⚙️ Reservation Management:

1. Allow flight reservations only if the selected route exists and if there is seat availability.
2. Check availability before confirming a reservation.
3. Once the flight reservation management has been started, the system must block the seats for a period of 15 minutes to guarantee seat availability.

⚙️ Authorized operations for the ADMIN user (ROLE_ADMIN):

1. CRUD of airports
2. CRUD of flight paths.
3. Summary list of reservations made by customers.
4. We must be able to obtain the list of reservation history for each user (ROLE_USER).

⚙️ Authorized operations for the CLIENT user (ROLE_USER):

1. Must be able to register
2. You must be able to upload your profile image and in case you do not have it configured then a default one will be shown.
3. You must be able to login
4. Customers must be able to obtain the list of their reservations with flight information.
5. Customers will not be able to make a reservation without prior login.

⚙️ Exception Management:

1. To be able to handle exceptions in a customized way.

⚙️ Non-functional Requirements

1. Security: Use of Spring Security and a choice between Basic Auth or JWT to protect the API.
2. Performance: Optimizations such as automatic flight status change and booking validation to maintain system efficiency.
3. Availability: Test implementation to ensure system stability in production.

## 🎯 EndPoints Overview:
    ⚙️ Airports

    1.POST /api/airports: Add a new airport.
    2. GET /api/airports: Get all airports.
    3. GET /api/airports/{id}: Get airport details by ID.
    4. GET /api/airports/{name}: Get airport details by NAME.
    5. PUT /api/airports/{id}: Update airport information.
    6. DELETE /api/airports/{id}: Delete an airport.

    ⚙️ Flights

    1. POST /api/flights: Create a new flight.
    2. GET /api/flights: Get all available flights.
    3. GET /api/flights/{id}: Get flight details by ID.
    4. PUT /api/flights/{id}: Update flight information.
    5. DELETE /api/flights/{id}: Delete a flight.

    ⚙️ Reservations

    1. POST /api/reservations: Create a new reservation.
    2. GET /api/reservations: Get all reservations.
    3. GET /api/reservations/{id}: Get reservation details by ID.
    4. PUT /api/reservations/{id}: Update a reservation.
    5. DELETE /api/reservations/{id}: Delete a reservation.

    ⚙️ Registers

    POST /api/v1/register: Create a new register.

    ⚙️ Users

    POST /api/v1/users: Create a new user.
    GET /api/v1/users/: Get all user details.
    GET /api/v1/users/{id}: Get user details by ID.
    PUT /api/v1/users/{id}: Update user details.
    DELETE /api/v1/users/{id}: Delete a user.

    ⚙️ Profiles

    GET /api/v1/profiles: Get all profile details.
    GET /api/v1/profiles/{id}: Get profile details by ID.
    GET /api/v1/profiles/{email}: Get profile details[]() by email.
    PUT /api/v1/profiles/{id}: Update profile details.

## Diagrams
![erDiagram.png](Utils/erDiagram.png)
![UMLDiagram.png](Utils/UMLDiagram.png)
![user.png](Utils/user.png)
![erDiagram.png](Utils/erDiagram.mmd)

## Project Structure

![estructura_proyecto.txt](Utils/estructura_proyecto.txt)



## 💻 Technology Stack:

1. **Java**
2. **Spring Boot**
3. **Spring Security**
4. **IntelliJ**
5. **Maven**
6. **Postman**
7. **Docker**


## Author

|                                                                                  **Miguel Reyes**                                                                                    |
  | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| <a href="https://github.com/MIANREVA2024"> <img src="https://img.shields.io/badge/github-%23121011.svg?&style=for-the-badge&logo=github&logoColor=white"/></a>             |
| <a href="https://www.linkedin.com/in/miguelreyesvasquez/"> <img src="https://img.shields.io/badge/linkedin%20-%230077B5.svg?&style=for-the-badge&logo=linkedin&logoColor=white"/></a> |