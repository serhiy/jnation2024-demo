FROM openjdk:17-alpine

ADD build/libs/order-service-0.0.1-SNAPSHOT.jar /app.jar
ADD build/agent/opentelemetry-javaagent.jar /opentelemetry-javaagent.jar

ENV OTEL_EXPORTER_OTLP_ENDPOINT http://host.docker.internal:4317
ENV OTEL_EXPORTER_OTLP_PROTOCOL grpc

ENTRYPOINT java -jar -javaagent:/opentelemetry-javaagent.jar /app.jar
