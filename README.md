# Arraybot: Mantis

Carbon provides a gateway listener for [Arraybot](https://github.com/Arraying/Arraybot).

### Technologies

Server-side:
* OpenJDK
* Spring Boot
* Discord4J

Data:
* PostgreSQL

### Environment variables

These are the environment variables required to run the application properly:
* `BOT_TOKEN`: The application's bot's token
* `PGDATABASE`: The database to use
* `PGHOST`: The host of the PostgreSQL server
* `PGPASSWORD`: The password for the user
* `PGPORT`: The port of the PostgreSQL server
* `PGUSER`: A user
