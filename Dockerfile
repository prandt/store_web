FROM maven:latest AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package


FROM openjdk:17.0.2-oraclelinux8
COPY --from=build /home/app/target/store-0.0.1-SNAPSHOT.jar /usr/local/lib/store-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/usr/local/lib/store-0.0.1-SNAPSHOT.jar"]