# StarWars Application

## Run the application as a Docker container
1. Move into project directory.
2. Compile project. 
   ```
   $ ./gradlew build
   ```
3. Build Docker image.
   ```
   $ docker build -f Dockerfile -t docker-starwars-app .
   ```
4. Run Docker image.
   ```
   $ docker run -p 6969:8080 docker-starwars-app
   ```

## Endpoints

* http://localhost:6969/characters?planetName={planetName}
* http://localhost:6969/starships?characterName={characterName}

## Deploy the application in a Kubernetes cluster
1. Move into project directory.
2. Apply deployment.
   ```
   $ kubectl apply -f deployment-script.yaml
   ```
    
## Swagger
* http://localhost:6969/swagger/views/swagger-ui/index.html    


