# Use Eclipse Temurin OpenJDK 21 as base
FROM eclipse-temurin:21-jdk AS restimagetesting

# Install Maven
ARG MAVEN_VERSION=3.9.4
ARG BASE_URL=https://archive.apache.org/dist/maven/maven-3/${MAVEN_VERSION}/binaries

RUN curl -fsSL ${BASE_URL}/apache-maven-${MAVEN_VERSION}-bin.tar.gz \
    | tar -xz -C /opt \
    && ln -s /opt/apache-maven-${MAVEN_VERSION} /opt/maven

ENV MAVEN_HOME=/opt/maven
ENV PATH=$MAVEN_HOME/bin:$PATH

WORKDIR /app

COPY . .

# Build only the rest module 
RUN mvn clean package -pl rest -am -DskipTests

# Run the built jar
CMD ["sh", "-c", "java -jar rest/target/*.jar"]


#Build the calculator module 
FROM maven:3.9.11-amazoncorretto-21-debian AS buildcalculator 
WORKDIR /usr/src/Demo


COPY . .

# Build the project 
RUN mvn clean package -pl calculator -am -DskipTests 

    
#Run the calculator application 
FROM openjdk:21-ea-21-jdk-slim-buster AS calculatorimage
WORKDIR /Demo
# Copy the built JAR from the build stage to runtime image
COPY --from=buildcalculator /usr/src/Demo/calculator/target/*.jar calculator.jar
# Command to run the application
CMD ["java", "-jar", "calculator.jar"]



#Build the rest module 
FROM maven:3.9.11-amazoncorretto-21-debian AS buildrestslim 
WORKDIR /usr/src/Demo


COPY . .

# Build the project 
RUN mvn clean package -pl rest -am -DskipTests 

# Run the rest application 
FROM openjdk:21-ea-21-jdk-slim-buster AS restimageslim 
WORKDIR /Demo
# Copy the built JAR from the build stage to runtime image
COPY --from=buildrestslim /usr/src/Demo/rest/target/*.jar rest.jar

# Command to run the application
CMD ["java", "-jar", "rest.jar"]