FROM ubuntu:latest AS build

RUN apt-get update && apt-get install -y openjdk-17-jdk maven

WORKDIR /app

#vai copiar os arquivos de dentro da aplicação para dentro do container
COPY . .
#compilando e empacotando os arquivos
RUN mvn clean install -DskipTests

#instalando um jdk mais leve
FROM openjdk:17-jdk-slim

WORKDIR /app

#Expondo a porta da aplicação
EXPOSE 8080

COPY --from=build /app/target/latinoware-*.jar app.jar

#Comando para rodar a aplicação, roda cada uma das extensões.
ENTRYPOINT ["java", "-jar", "app.jar"]
