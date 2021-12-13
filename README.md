# Shipping App b

on new branch https://github.com/com619-2021/ShippingAppB/edit/CraigsUsers/README.md

Craig has  spent some time fixing this for you 

This branch fixes some problems in users branch

works with HSQLDB avoiding need for postgres
but can be reverted see application.properties

the code has been made to work and he @Id on each entity has been simplified

build mvn clean install
run mvn spring-boot:run

you will see error logs but the application builds and works. 
There seems to be problem deleting old tables with in memory database


## working services

(set headers application/json)
```
GET http://localhost:8080/api/v1/user

GET http://localhost:8080/api/v1/order

POST http://localhost:8080/api/v1/user

{
   "name" : "fred",
   "role" : "buyer",
   "pswd" : "xxxxxxxx"
}
```
