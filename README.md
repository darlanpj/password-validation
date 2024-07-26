# Executando local
Para executar a aplicação poderá ser feita por algum  comando abaixo:

## Dependencias
Java 21

Tendo maven instalado via linha de commando
```shell
./mvn spring-boot:run
```
ou
```shell
java -jar path/to/your/jarfile.jar password-validation-0.0.1.jar
```

Docker

```shell
docker build -t djambersi/password-validation:0.0.1 .
```

```shell
docker run -p 9090:9090 djambersi/password-validation:0.0.1
```

Swagger
http://localhost:9090/swagger-ui/index.html

Cobertura de tests:

![Screenshot from 2024-07-24 23-19-06.png](..%2F..%2FPictures%2FScreenshots%2FScreenshot%20from%202024-07-24%2023-19-06.png)