FROM openjdk:8-jdk-alpine

ENV TZ Asia/Shanghai

RUN mkdir /app

#创建spring组/用户
RUN addgroup -S spring && adduser -S spring -G spring

RUN chown spring:spring /app

#以spring用户进行操作
USER spring:spring

WORKDIR /app

RUN mkdir /app/log

#定义参数
ARG SOURCE_JAR_FILE=target/toolbox-web.jar
ARG TARGET_JAR_FILE=/toolbox-web.jar

#复制文件
COPY ${SOURCE_JAR_FILE} ${TARGET_JAR_FILE}

#执行
ENTRYPOINT ["java","-Xmx1024m","-jar","/toolbox-web.jar"]