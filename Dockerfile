FROM openjdk:11
RUN mkdir /app
COPY dockertest/src/dockertest/ /app
WORKDIR /app
CMD java Main