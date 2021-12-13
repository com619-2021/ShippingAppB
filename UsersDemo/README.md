# this is a fixed vesion of the origian Users project

instead of postgress it uses hybernate sql local in memry db but you can revert to postgres 

I commented out 
```
	<!--	<dependency>
			<groupId>org.postgresql</groupId>
			<artifactId>postgresql</artifactId>
			<scope>runtime</scope>
		</dependency>
-->
```

and added into pom.xml

```

        <!-- IN MEMORY Database and JDBC Driver -->
        <dependency>
            <groupId>org.hsqldb</groupId>
            <artifactId>hsqldb</artifactId>
            <scope>compile</scope>
        </dependency>

```

and changed application.properties
```
#spring.datasource.url=jdbc:postgresql://localhost:5432/users
#spring.datasource.username=uchitelq
#spring.datasource.password=admin
#spring.jpa.hibernate.ddl-auto=create-drop
#spring.jpa.show-sql=true
#spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
#spring.jpa.properties.hibernate.format_sql=true

#in memory only
spring.datasource.url=jdbc:hsqldb:mem:testdb;DB_CLOSE_DELAY=-1
spring.datasource.username=uchitelq
spring.datasource.password=admin
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.HSQLDialect
spring.jpa.properties.hibernate.format_sql=true

```

the @Id has been simplified in each entity and the rest of the code now works s a simple ReST app.

get http://localhost:8080/api/v1/user  returns list of users

post http://localhost:8080/api/v1/user adds a user

{
   "name" : "fred",
   "role" : "buyer",
   "pswd" : "xxxxxxxx"
}

content type application/json

get gttp://localhost:8080/api/v1/order  returns an order