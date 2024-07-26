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

![Screenshot from 2024-07-24 23-19-06](https://github.com/user-attachments/assets/2a65b1ba-1cdb-488a-b586-3fe33000bc91)
