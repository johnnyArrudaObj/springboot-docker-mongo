# Imagem base com o Java 11
FROM openjdk:11-jdk-slim

# Definir o diretório de trabalho para o aplicativo
WORKDIR /app

# Copiar o jar do aplicativo para dentro da imagem
COPY target/*.jar customerapi.jar

# Expor a porta 8080 para o aplicativo
EXPOSE 8080

# Iniciar o aplicativo
CMD java -jar customerapi.jar