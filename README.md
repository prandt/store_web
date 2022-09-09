# Store web API

This project's gonna be created 

## Installation 

To run this project you need install Docker in your computer

```
git clone https://github.com/prandt/store_web.git
cd store_web
docker-compose up --build
```

## Stack

Spring Boot

MongoDB


## Auth 

Create account

Endpoint: `/oauth/user/create`

Header: Content-Type | application/json

Example payload
```json
{
	"name": "Jose",
	"email": "marcos@gmail.com",
	"password": "1234",
	"address": {
		"street": "Rua dos bobos",
		"number": "123",
		"city": "Cidade", 
		"state": "Parana",
		"zipcode": "8888-888"
	}
}
```

Login

Endpoint: `/oauth/token`


Curl example
```
curl -d "username=username@example.com&password=iampassword&grant_type=password" 
	-u "myclientid:myclientsecret" 
	-H "Content-Type: application/x-www-form-urlencoded" 
	-X POST http://localhost:8080/oauth/token
```

