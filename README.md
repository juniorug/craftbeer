# Cadastro de cervejas artesanais

Java application to register craft beers.

Based on [Building an Application with Spring Boot](https://spring.io/guides/gs/spring-boot/).

## Funcionalities

-  Craft Beer CRUD by API.<br/>

## Pre-requisites
* JDK 1.8 or later

* Gradle 4+ or Maven 3.2+

* Docker

* Docker-compose

## Set up environment

To start the project it is necessary to clone this repository:

```bash
    $ git clone https://github.com/juniorug/craftbeer.git
```

## Build application
The application can be built by the following command:

```bash
    mvn clean install
```

## Run tests
Type the following command to run the unit tests:

```bash
    mvn test
```

## Run locally

To execute the project locally, run:

```bash
    $ ./mvnw spring-boot:run
```

##Build and run the docker containerized application 

Build the container image by doing the follow:


```bash
    $ docker build -t springio/craft-beer .
```

Then, to run the application from container:

```bash
    $ docker run -p 8080:8080 springio/craft-beer
```

## Swagger Doc
The API's documentation is in Swagger format and can be accessed at:

```bash
    http://localhost:8080/v2/api-docs
```

The Json for the Swagger generation can be found at:

```bash
    http://localhost:8080/v2/api-docs
```
This file can also be found in the project's `/doc` folder.

## Postman Collection
To import the Postman collection, use the file `/docs/Craft Beers Spring Boot REST API.postman_collection.json`

