FROM maven:3.6.1-jdk-14

RUN mkdir /app
WORKDIR /app

# Download dependencies once, not every build
COPY pom.xml pom.xml
RUN mvn dependency:resolve compile package

COPY src src
RUN mvn compile package

CMD ["java", "-jar", "target/Result-1.0.SNAPSHOT.jar"]
