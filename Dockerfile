FROM openjdk:11.0.15
ADD ./target/*.jar /usr/src/app.jar
WORKDIR /usr/src
ENTRYPOINT ["java","-jar", "app.jar"]