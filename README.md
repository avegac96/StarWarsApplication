# StarWars Application

## Docker
    $ ./gradlew build
    $ docker build -f Dockerfile -t docker-starwars-app .
    $ docker run -p 6969:6969 docker-starwars-app

## Endpoints

    http://localhost:6969/characters?planetName={planetName}
    http://localhost:6969/starships?characterName={characterName}


