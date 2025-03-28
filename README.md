# Java API for studies

This is a simple API in Java, still under development, where I'm putting my studies into practice.

The API is a RESTful API, using Spring Boot as the framework. It's a simple CRUD (Create, Read, Update, Delete) API for clients.

The API is still in development and doesn't have authentication or authorization yet.

The API is documented using Swagger, and you can access the documentation at `/swagger-ui.html`.

The API is also deployed on Heroku, and you can access it at <https://java-api-for-studies.herokuapp.com/>.

Soon, I'll add a front-end in Angular, and I'll update this README with more information.

## Endpoints

### Clients

* `GET /clients`: Returns a list of all clients.
* `GET /clients/{name}`: Returns a client by its ID.
* `POST /clients`: Creates a new client.
* `PUT /clients/{id}`: Updates a client by its ID.
* `DELETE /clients/{id}`: Deletes a client by its ID.

## Technologies used

* Java 24
* Spring Boot 2.4.3
* Swagger 2.9.2
* Maven 3.6.0

## Development

If you want to run the API locally, you can use the following commands:

* `mvn spring-boot:run`: Starts the API.
* `mvn test`: Runs the unit tests.
* `mvn package`: Packages the API into a JAR file.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
