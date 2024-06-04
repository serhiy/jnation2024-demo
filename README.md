# Product Service
./gradlew bootJar
docker build . -t jnation-product-service:0.0.1
docker run -d -p 8081:8081 jnation-product-service:0.0.1

# MySQL
docker compose up

# Orders Service
./gradlew bootJar
docker build . -t jnation-order-service:0.0.1
docker run -d -p 8082:8080 jnation-order-service:0.0.1

# Users Service
./gradlew bootJar
docker build . -t jnation-user-service:0.0.1
docker run -d -p 8083:8080 jnation-user-service:0.0.1

# Frontend
docker build . -t jnation-frontend:0.0.1
docker run -d -p 8080:8080 jnation-frontend:0.0.1

# Cloud Prober
docker run -v /Users/sboychen/demo-jnation/cloudprober/cloudprober.cfg:/etc/cloudprober.cfg ghcr.io/cloudprober/cloudprober

# Collector
docker build . -t jnation-collector:0.0.1
docker run -d -p 4317:4317 -p 4318:4318 jnation-collector:0.0.1

# Jaeger
docker compose -f docker-compose/monitor/docker-compose.yml up
http://localhost:16686

# Signoz
docker compose -f deploy/docker/clickhouse-setup/docker-compose.yaml up
http://localhost:3301

# Openobserve
docker run -p 5080:5080 -p 5081:5081 -e ZO_ROOT_USER_EMAIL="root@example.com" -e ZO_ROOT_USER_PASSWORD="root" public.ecr.aws/zinclabs/openobserve:latest
http://localhost:5080


