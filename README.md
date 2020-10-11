# Hedge-tech home test

This is a home test for hedge tech

## Installation


```bash
mvn clean install
java -jar target/hedge-tech-0.0.1-SNAPSHOT.jar --cloud.aws.credentials.access-key="<ACCESS_KEY>" --cloud.aws.credentials.secret-key="<SECRET_KEY>"

cd src/main/my-app
npm start
```

## Usage

The app will be available in http://localhost:3000/
The Server will write logs every `nsec` seconds