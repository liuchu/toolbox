FROM openjdk:8-jdk-alpine

#创建spring组/用户
RUN addgroup -S spring && adduser -S spring -G spring

#以spring用户进行操作
USER spring:spring

#定义参数
ARG SOURCE_JAR_FILE=target/todolist.jar
ARG TARGET_JAR_FILE=/todolist.jar

#复制文件
COPY ${SOURCE_JAR_FILE} ${TARGET_JAR_FILE}

#执行
ENTRYPOINT ["java","-Xmx1024m","-jar","/todolist.jar"]