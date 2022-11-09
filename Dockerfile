FROM bellsoft/liberica-openjdk-alpine-musl
COPY ./target/SchedulerWeather-0.0.1-SNAPSHOT.jar .
CMD ["java","-jar","SchedulerWeather-0.0.1-SNAPSHOT.jar"]