
FROM adoptopenjdk/openjdk11
COPY target/vitoriaoliveira-0.0.1-SNAPSHOT.jar vitoriaoliveira-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/vitoriaoliveira-0.0.1-SNAPSHOT.jar"]
