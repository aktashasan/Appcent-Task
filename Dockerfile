FROM openjdk:11-jre-slim
ADD target/case-0.0.1-SNAPSHOT.jar case.jar
ENTRYPOINT ["java", "-jar","case.jar"]
ENV ACTIVE_PROFILES=prod