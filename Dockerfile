FROM openjdk:11
RUN mkdir /app
COPY imagedocker/src/imagedocker/ /app
WORKDIR /app
CMD java Main