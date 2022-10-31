FROM openjdk:8
ADD target/achat-1.0.jar achat.jar
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "achat.jar"]