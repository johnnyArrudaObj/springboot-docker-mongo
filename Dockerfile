# Imagem ubuntu
FROM ubuntu:latest

RUN apt-get update && \
    apt-get install -y openjdk-17-jdk

ENV JAVA_HOME /usr/lib/jvm/java-17-openjdk-amd64
ENV PATH $JAVA_HOME/bin:$PATH

# Definir o diretório de trabalho para o aplicativo
WORKDIR /app

# Copiar o jar do aplicativo para dentro da imagem
COPY target/*.jar customerapi.jar

# Expor a porta 8080 para o aplicativo
EXPOSE 8080

# Iniciar o aplicativo
CMD java -jar customerapi.jar