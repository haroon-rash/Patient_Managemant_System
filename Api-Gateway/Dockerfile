FROM maven:3.9.9-eclipse-temurin-21 AS builder

WORKDIR /app

# 1️⃣ Copy only pom.xml first to cache dependencies
COPY pom.xml .

# 2️⃣ Download dependencies and cache them
RUN mvn dependency:go-offline -B

# 3️⃣ Now copy the actual source code
COPY src ./src

# 4️⃣ Build the JAR file
RUN mvn clean package -DskipTests

# 5️⃣ Run stage with JDK 17
FROM openjdk:17-jdk AS runner

WORKDIR /app

COPY --from=builder /app/target/Api-Gateway-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 4004

ENTRYPOINT ["java", "-jar", "app.jar"]
