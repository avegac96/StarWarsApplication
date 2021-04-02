FROM openjdk:11
ADD build/libs/StarWarsApplication-0.1-all.jar StarWarsApplication-0.1-all.jar
EXPOSE 6969
ENTRYPOINT ["java", "-jar", "StarWarsApplication-0.1-all.jar"]