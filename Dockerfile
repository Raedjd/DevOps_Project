FROM openjdk:8
ADD target/achat-1.0.jar monAchat.jar
EXPOSE 8001
ENTRYPOINT ["java", "-jar", "monAchat.jar"]