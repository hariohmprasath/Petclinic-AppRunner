FROM amazoncorretto:11
ARG JAR_FILE=target/spring-petclinic-2.7.3.jar
COPY ${JAR_FILE} app.jar
RUN chmod 777 app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
