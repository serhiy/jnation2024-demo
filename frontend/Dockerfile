FROM node:lts-alpine
# install simple http server for serving static content
RUN npm install -g http-server
# make the 'app' folder the current working directory
WORKDIR /app
# copy 'package.json' to install dependencies
COPY package*.json ./
# install dependencies
RUN npm install
# copy files and folders to the current working directory (i.e. 'app' folder)
COPY . .
# ENV NODE_OPTIONS "--require @opentelemetry/auto-instrumentations-node/register"
# ENV OTEL_NODE_RESOURCE_DETECTORS env,host,os
ENV OTEL_TRACES_EXPORTER otlp
ENV OTEL_EXPORTER_OTLP_TRACES_ENDPOINT http://host.docker.internal:4317/
ENV OTEL_EXPORTER_OTLP_PROTOCOL grpc
ENV OTEL_EXPORTER_OTLP_INSECURE true
ENV OTEL_EXPORTER_OTLP_ENDPOINT http://host.docker.internal:4317/
ENV OTEL_SERVICE_NAME brewery
ENV NODE_OPTIONS "--require @opentelemetry/auto-instrumentations-node/register"
# build app for production with minification
RUN npm run build
EXPOSE 8080
CMD [ "http-server", "dist" ]
