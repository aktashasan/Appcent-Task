FROM openjdk:11
ADD target/case-0.0.1-SNAPSHOT.jar case.jar
ENTRYPOINT ["java", "-jar","case.jar"]
EXPOSE 8080