FROM ubuntu:20.04
RUN apt-get update && apt-get install -y \
        openjdk-17-jdk \
        maven
WORKDIR /app
COPY . .
RUN mvn clean package
CMD ["java", "-jar", "target/store_dayZ-0.0.1-SNAPSHOT.jar"]