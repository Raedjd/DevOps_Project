FROM openjdk:8
ADD target/achat-1.0.jar achatraed.jar
EXPOSE 8001
ENTRYPOINT ["java", "-jar", "achatraed.jar"]