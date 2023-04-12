## 📝 Brief description

This project it is a POC to study Spring. 
API save customer with Mongodb (Project had H2 future features) and JWT authentication and using the Swagger for more documentation.

Reading information from Kafka, implement a circuit break with FeignClient to consume Viacep API
to get Address. Schedule to update customer when circuit break was open.

With a pipeline on Jenkis, jenkis is monitoring the GitHub repository so when push to master he build image from application
and send new image to dockerhub.

## 🚀 How to run the application locally?
Inside src/main/resources we had the docker-compose.yml from aplication.
```bash
docker compose up
```

⚠️ Attention! To changes and tests locally change **container_name** from customerapi to **customerapi** and build image again.
```bash
docker build -t customerapi .
```

### 🔹 To run Jenkis
```bash
java -jar jenkins.war
```

_📌 We have the JenkisFile to configurate, on root project_

## 🎉 Links

Jenkis - http://localhost:8080/

Swagger - http://localhost:9090/swagger-ui/index.html#/

Actuator-Health - http://localhost:9090/actuator/health

H2 - http://localhost:9090/h2/login.jsp

Kafka - http://localhost:9021/clusters/

MongoExpress - http://localhost:8081/

## 📦  Json data and Urls

```json
http://localhost:9090/login/register
{
    "login": "johnny@hotmail.com",
    "password": "123456"
}
```

```json
http://localhost:9090/login
{
    "login": "johnny@hotmail.com",
    "password": "123456"
}
```

```json
http://localhost:9090/customer - Put JWT token
{
    "name": "Postman tres",
    "cpf": "123.456.123-42",
    "specialty": "BACKEND",
    "address": {
    "street": "",
    "neighborhood": "",
    "zipcode": "04814530",
    "city": "",
    "state": "",
    "number": ""
}
```

```json
/Get with paginate
http://localhost:9090/customer?size=2&page=0
http://localhost:9090/customer?sort=name,desc
http://localhost:9090/customer/id_customer
```

## 👷 Util Links to build this application

📌 https://www.youtube.com/watch?v=ZXq_s4M5UHs&ab_channel=EnggAdda

📌 https://www.youtube.com/watch?v=dHWDN1TSTi8&ab_channel=MadsonSilva%5BBORAPRATICAR%5D

📌 https://www.youtube.com/watch?v=RKaxATb2kz8&ab_channel=EnggAdda

📌 https://medium.com/devops-with-valentine/jenkins-how-to-use-a-different-java-jdk-version-in-jenkinsfile-d1f0f2d04bcf

📌 https://www.youtube.com/watch?v=ka9x2_y9XfE&ab_channel=MadsonSilva%5BBORAPRATICAR%5D

## 📦 Images from project
