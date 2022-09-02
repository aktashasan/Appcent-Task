FROM openjdk:11
ADD target/case.jar case.jar
ENTRYPOINT ["java", "-jar","case.jar"]
EXPOSE 8080