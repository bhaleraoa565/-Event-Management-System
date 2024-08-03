Event Management System
Overview
The Event Management System is a Java Spring Boot application designed to manage events, venues, and organizers. It supports CRUD operations for these entities and connects to a MySQL database using Spring Data JPA.

Table of Contents
Overview
Technologies Used
Project Structure
Setup and Installation
API Endpoints
Exception Handling
Testing
Contributing
License
Technologies Used
Java
Spring Boot
Spring Data JPA
MySQL
Lombok
Postman (for testing API endpoints)
Project Structure
css
Copy code
src
 └── main
     └── java
         └── com
             └── example
                 └── eventmanagement
                     ├── controller
                     │    ├── EventController.java
                     │    ├── VenueController.java
                     │    └── OrganizerController.java
                     ├── entity
                     │    ├── Event.java
                     │    ├── Venue.java
                     │    └── Organizer.java
                     ├── repository
                     │    ├── EventRepository.java
                     │    ├── VenueRepository.java
                     │    └── OrganizerRepository.java
                     ├── service
                     │    ├── EventService.java
                     │    ├── VenueService.java
                     │    └── OrganizerService.java
                     └── exception
                          ├── ResourceNotFoundException.java
                          └── GlobalExceptionHandler.java
 └── resources
     ├── application.properties
 └── test
Setup and Installation
Clone the Repository

bash
Copy code
git clone https://github.com/yourusername/event-management-system.git
cd event-management-system
Configure the Database

Create a MySQL database named event_management.
Update the src/main/resources/application.properties file with your database credentials:
properties
Copy code
spring.datasource.url=jdbc:mysql://localhost:3306/event_management
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
Build and Run the Application

Build the project using Maven:
bash
Copy code
mvn clean install
Run the Spring Boot application:
bash
Copy code
mvn spring-boot:run
API Endpoints
Event
Create a New Event

POST /api/events
Request Body:
json
Copy code
{
  "eventName": "Event Name",
  "eventDate": "2024-12-25",
  "description": "Event Description",
  "organizer": { "id": 1 },
  "venue": { "id": 1 }
}
Get All Events

GET /api/events
Get Event by ID

GET /api/events/{id}
Update Event

PUT /api/events/{id}
Request Body:
json
Copy code
{
  "eventName": "Updated Event Name",
  "eventDate": "2024-12-25",
  "description": "Updated Description",
  "organizer": { "id": 1 },
  "venue": { "id": 1 }
}
Delete Event

DELETE /api/events/{id}
Get Events by Venue

GET /api/events/venue/{venueId}
Get Events by Organizer

GET /api/events/organizer/{organizerId}
Venue
Create a New Venue

POST /api/venues
Request Body:
json
Copy code
{
  "name": "Venue Name",
  "location": "Venue Location",
  "capacity": 100
}
Get Venue by ID

GET /api/venues/{id}
Update Venue

PUT /api/venues/{id}
Request Body:
json
Copy code
{
  "name": "Updated Venue Name",
  "location": "Updated Venue Location",
  "capacity": 150
}
Delete Venue

DELETE /api/venues/{id}
Organizer
Create a New Organizer

POST /api/organizers
Request Body:
json
Copy code
{
  "name": "Organizer Name",
  "contactInfo": "Organizer Contact Info"
}
Get Organizer by ID

GET /api/organizers/{id}
Update Organizer

PUT /api/organizers/{id}
Request Body:
json
Copy code
{
  "name": "Updated Organizer Name",
  "contactInfo": "Updated Organizer Contact Info"
}
Delete Organizer

DELETE /api/organizers/{id}
Exception Handling
The application handles exceptions globally using the GlobalExceptionHandler class.
Custom exceptions like ResourceNotFoundException are thrown when entities are not found.
