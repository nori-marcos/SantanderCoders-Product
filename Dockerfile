FROM openjdk:17
VOLUME /tmp
COPY target/product-api.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]