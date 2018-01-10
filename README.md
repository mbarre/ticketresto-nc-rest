[![Dependency Status](https://beta.gemnasium.com/badges/github.com/mbarre/ticketresto-nc-rest.svg)](https://beta.gemnasium.com/projects/github.com/mbarre/ticketresto-nc-rest) [![CircleCI](https://circleci.com/gh/mbarre/ticketresto-nc-rest/tree/master.svg?style=svg)](https://circleci.com/gh/mbarre/ticketresto-nc-rest/tree/master)

# ticketresto-nc-rest

Rest API to get Ticket Restaurant Nouvelle Calédonie account detail. It use https://github.com/adriens/tickets-resto-nc java api developed by @adriens.

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

### Get your balance

```
curl http://localhost:8090/accounts/{identifier}/{password}/balance
```

### Get your account detail

```
curl http://localhost:8090/accounts/{identifier}/{password}/detail
```