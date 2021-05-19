FROM openjdk:8-jre

COPY . .
RUN gradle bootjar
CMD ["java", "build/"]
