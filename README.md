[![Dependency Status](https://beta.gemnasium.com/badges/github.com/mbarre/ticketresto-nc-rest.svg)](https://beta.gemnasium.com/projects/github.com/mbarre/ticketresto-nc-rest)

# ticketresto-nc-rest

Rest API to get Ticket Restaurant Nouvelle Calédonie account detail.

This API is deployed on Heroku.

## Get your balance

```
curl https://ticketresto-nc-rest.herokuapp.com/accounts/{identifier}/{password}/balance
```

## Get your account detail

```
curl https://ticketresto-nc-rest.herokuapp.com/accounts/{identifier}/{password}/detail
```

