FROM openjdk:8-jre-alpine
VOLUME /tmp
EXPOSE 9010 9011
ADD ./target/importer-0.0.1-SNAPSHOT.jar app.jar
RUN sh -c 'touch /app.jar'
ENV JAVA_OPTS=""
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar", "/app.jar"]

