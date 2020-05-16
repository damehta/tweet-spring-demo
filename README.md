# tweet-spring-demo

This tweet-spring-demo project requires following:
- OpenJDK 8

- Mongo DB 
    - Option 1: Download MongoDB and follow set-up instructions here: 
    - Option 2: Run in docker container
        - docker pull mongo
        - Follow instructions here https://hub.docker.com/_/mongo
        - You can use src/test/resources/mongodb/* 
    - Create database and users as defined in application.properties file.

- Run Tweet springboot demo application
    $./gradlew bootRun

- Test GET and PUT APIs
    - Curl command can be found in src/test/resources/PostmanCollection

