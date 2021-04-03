# StarWars Application

## Docker
    $ ./gradlew build
    $ docker build -f Dockerfile -t docker-starwars-app .
    $ docker run -p 6969:8080 docker-starwars-app

## Endpoints

    http://localhost:6969/characters?planetName={planetName}
    http://localhost:6969/starships?characterName={characterName}
    
## Swagger
    http://localhost:6969/swagger/views/swagger-ui/index.html    


