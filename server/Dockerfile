FROM openjdk:9-jre-slim
LABEL maintainer="hiper2d"
VOLUME /tmp
ADD build/libs/server-0.1.0-SNAPSHOT.jar server.jar
ENV JAVA_OPTS=""
EXPOSE 8082
ENTRYPOINT exec java $JAVA_OPTS -jar /server.jar