#Build the rest module 
FROM maven:3.9.11-amazoncorretto-21-debian AS buildrest 
WORKDIR /usr/src/Demo

# Copy the entire project folder into the container
COPY . .

# Build the project 
# RUN mvn clean package
RUN mvn clean package -pl rest -am -DskipTests && \
    echo "=== Contents of target directory after build ==="

# Run the rest application 
FROM openjdk:21-ea-21-jdk-slim-buster AS restimage 
WORKDIR /Demo
# Copy the built JAR from the build stage to runtime image
COPY --from=buildrest /usr/src/Demo/rest/target/*.jar rest.jar

# Command to run the application
CMD ["java", "-jar", "rest.jar"]

#Build the calculator module 
FROM maven:3.9.11-amazoncorretto-21-debian AS buildcalculator 
WORKDIR /usr/src/Demo

# Copy the entire project folder into the container
COPY . .

# Build the project 
# RUN mvn clean package
RUN mvn clean package -pl calculator -am -DskipTests && \
    echo "=== Contents of target directory after build ==="

    
#Run the calculator application 
FROM openjdk:21-ea-21-jdk-slim-buster AS calculatorimage
WORKDIR /Demo
# Copy the built JAR from the build stage to runtime image
COPY --from=buildcalculator /usr/src/Demo/calculator/target/*.jar calculator.jar
# Command to run the application
CMD ["java", "-jar", "calculator.jar"]
