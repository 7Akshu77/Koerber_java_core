FROM openjdk:21
EXPOSE 8081
ADD target/orderapp-*.jar orderapp.jar
ENTRYPOINT ["java", "-jar", "orderapp.jar"]
