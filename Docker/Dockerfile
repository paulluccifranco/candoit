FROM eclipse-temurin:17-jre-alpine
ADD Candoit-0.0.1-SNAPSHOT.jar Candoit-0.0.1-SNAPSHOT.jar
ENV JAVA_OPTS=""
ENV OPTS=""
ENV SPRING_PROFILES_ACTIVE=prod
ENTRYPOINT java $JAVA_OPTS -jar Candoit-0.0.1-SNAPSHOT.jar $OPTS
