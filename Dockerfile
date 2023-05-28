FROM openjdk:15-buster
ADD build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]