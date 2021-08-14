FROM openjdk:8-jdk-alpine
RUN mkdir -p /app && apk add --no-cache tzdata
ENV TZ Asia/Shanghai
WORKDIR /app
ARG JAR_FILE=target/todolist-latest.jar
COPY target/todolist-latest.jar /todolist-latest.jar
ENTRYPOINT ["java","-Xmx1024m","-Djava.security.egd=file:/dev/./urandom","-XX:HeapDumpPath=/log/dmp/heapdump.hprof", "-jar","/app.jar"]


ENTRYPOINT ["java","-jar","/app.jar"]