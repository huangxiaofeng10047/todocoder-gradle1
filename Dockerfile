# jre 17 的镜像
FROM todocoder/jre:17
MAINTAINER todocoder
WORKDIR /todocoder
# jvm启动参数
ENV APP_ARGS="-XX:+UseG1GC -Xms1024m -Xmx1024m -Xss256k -XX:MetaspaceSize=128m"
ADD app/todocoder-gradle1.jar /todocoder/app.jar
# 镜像启动后运行的脚本
ENTRYPOINT ["java","-jar","/todocoder/app.jar","${APP_ARGS}","--spring.profiles.active=dev","-c"]