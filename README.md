[![CircleCI](https://circleci.com/gh/mbarre/ticketresto-nc-rest/tree/master.svg?style=svg)](https://circleci.com/gh/mbarre/ticketresto-nc-rest/tree/master)
[![Join the chat at https://gitter.im/ticketresto-nc-rest/Lobby](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/ticketresto-nc-rest/Lobby)
[![Run in Postman](https://run.pstmn.io/button.svg)](https://app.getpostman.com/run-collection/7c95e64c1e730040ea4b)

# ticketresto-nc-rest

Rest API to get Ticket Restaurant Nouvelle Calédonie account detail. It uses [Tickets Restaurant Java SDK](https://github.com/adriens/tickets-resto-nc-sdk) developed by [@adriens](https://www.linkedin.com/in/adrien-sales/).

The service is deployed on Heroku.

## How to use the service on Heroku

### Get your balance

```
curl https://ticketresto-nc-rest.herokuapp.com/accounts/{identifier}/{password}/balance
```

### Get your account detail

```
curl https://ticketresto-nc-rest.herokuapp.com/accounts/{identifier}/{password}/detail
```

### Get your transactions from a date

```
curl https://ticketresto-nc-rest.herokuapp.com/accounts/{identifier}/{password}/transactions/{ddMMyyyy}
```

### Get all your transactions

```
curl https://ticketresto-nc-rest.herokuapp.com/accounts/{identifier}/{password}/transactions
```

### Get all partners

```
curl https://ticketresto-nc-rest.herokuapp.com/partners
```

... to get them as a ```pdf``` stream :

```
curl https://ticketresto-nc-rest.herokuapp.com/partners/pdf
```


## Postman api documentation

A [public postman documentation](https://documenter.getpostman.com/view/3489712/ticket-resto/7LuYy9B) is maintained : you'll find code samples so you'll be able to use the api from you favourite language (cURL, jQuery, Ruby, Python, Node, PHP, Go).

## How to make it run on premise

### Set the port

Default port number is *8090*, you can change it by editing the file *application.properties*
```
server.port = 8090
```

### Build the project

```
mvn clean package
java -jar target/ticketresto-nc-rest-{version}.jar
```

or even more straightforward start/stop :

Run it live :

```
mvn spring-boot:run
```



As a background process :

```
mvn spring-boot:start
```

and hence to stop it :

```
mvn spring-boot:stop
```



More details on maven ```spring-boot``` goals [here](https://docs.spring.io/spring-boot/docs/current/maven-plugin/plugin-info.html)

### Get your balance

```
curl http://localhost:8090/accounts/{identifier}/{password}/balance
```

### Get your account detail

```
curl http://localhost:8090/accounts/{identifier}/{password}/detail
```

### Get your transactions from a date

```
curl https://localhost:8090/accounts/{identifier}/{password}/transactions/{ddMMyyyy}
```

### Get all your transactions

```
curl https://localhost:8090/accounts/{identifier}/{password}/transactions
```

### Get all partners

```
curl https://localhost:8090/partners
```

# End point output formats

By default, you get json. To get ```xml``` output, just add ```?mediaType=xml``` to the url and you're done. 

## How to use it with Docker

### Build the Docker image with Maven

```
mvn install dockerfile:build    
```

### Run the Spring Boot App container 

```
docker container run -p 8090:8090 mbarre/ticketresto-nc-rest:latest
```

```
docker ps
CONTAINER ID        IMAGE                               COMMAND                  CREATED             STATUS              PORTS                    NAMES
c5f0eef3e3b7        mbarre/ticketresto-nc-rest:latest   "java -Djava.secur..."   15 seconds ago      Up 14 seconds       0.0.0.0:8090->8090/tcp   gallant_mayer

```
