FROM openjdk:21-oracle

LABEL mainteiner="darlanpj@gmail.com"

WORKDIR /app
COPY target/password-validation-0.0.1.jar /app/password-validation-0.0.1.jar

EXPOSE 9090

ENTRYPOINT ["java","-jar","password-validation-0.0.1.jar"]