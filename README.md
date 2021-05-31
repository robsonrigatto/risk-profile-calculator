# Tecnologies

- Java 8
- Maven
- Spring Boot
- jUnit4 (for test)

# How to start application

- Install jdk8: https://www.oracle.com/br/java/technologies/javase/javase-jdk8-downloads.html
- Install maven: https://maven.apache.org/install.html
- Check whether `java`, `javac` and `maven` are both in `$PATH` system variable
- Start application: `mvn spring-boot:run`

# How to test application

- To test risk calculator, use a tool like Postman or use command below:

```json
curl --location --request POST 'localhost:8080/risk/calculate' \
--header 'Content-Type: application/json' \
--data-raw '{
  "age": 35,
  "dependents": 2,
  "house": {"ownership_status": "owned"},
  "income": 0,
  "marital_status": "married",
  "risk_questions": [0, 1, 0],
  "vehicle": {"year": 2018}
}'

```

# How to run unit test

- Run tests: `mvn test`
