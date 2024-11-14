# Build stage
FROM maven:3.8.1-openjdk-17 as build
WORKDIR /apps
COPY ecommerce-api ecommerce-api
COPY ecommerce-application ecommerce-application
COPY ecommerce-domain ecommerce-domain
COPY ecommerce-infrastructure ecommerce-infrastructure
COPY ecommerce-test ecommerce-test
COPY pom.xml .

RUN mvn -f pom.xml clean install -DskipTests

# Package stage
FROM openjdk:17-jdk-slim
COPY --from=build /apps/ecommerce-api/target/ecommerce-api-1.0.jar /apps/ecommerce-api-1.0.jar
COPY --from=build /apps/ecommerce-application/target/ecommerce-application-1.0.jar /apps/ecommerce-application-1.0.jar
COPY --from=build /apps/ecommerce-domain/target/ecommerce-domain-1.0.jar /apps/ecommerce-domain-1.0.jar
COPY --from=build /apps/ecommerce-infrastructure/target/ecommerce-infrastructure-1.0.jar /apps/ecommerce-infrastructure-1.0.jar

RUN apt-get update && apt-get install -y iputils-ping netcat curl

# ตั้งค่า entrypoint ให้ใช้ไฟล์ jar ที่ต้องการ
 ENTRYPOINT ["java","-jar", "/apps/ecommerce-api-1.0.jar"]
