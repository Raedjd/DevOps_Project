FROM openjdk:8
ADD target/achat-1.0.jar achatproject.jar
EXPOSE 8089
ENTRYPOINT ["java", "-jar", "achatproject.jar"]