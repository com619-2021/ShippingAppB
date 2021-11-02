## How to run
- Run the command ./mvnw spring-boot:run in the terminal at the root level of this project.
- If an error appears stating it can't find a file, ensure you have the maven wrappers. If not run:
```shell mvn -N io.takari:maven:wrapper```
- Hopefully that won't brick the solution, it did for me a few times, no clue why.
- If the application is running you should be able to navigate to http://localhost:8080/hello
- You could even add your name to http://localhost:8080/hello?name=*name here*

-I used this tutorial: https://spring.io/quickstart