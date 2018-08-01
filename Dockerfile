
FROM hub.c.163.com/wuxukun/maven-aliyun:3-jdk-8

ADD pom.xml /tmp/build/

ADD bgx-common /tmp/build/bgx-common

ADD bgx-admin /tmp/build/bgx-admin

        #构建应用
RUN cd /tmp/build && mvn clean package \
        #拷贝编译结果到指定目录
        && mv target/*.jar /app.jar \
        #清理编译痕迹
        && cd / && rm -rf /tmp/build
VOLUME /tmp
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]