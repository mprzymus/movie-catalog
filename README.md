# movie-catalog

To deploy app in docker, firstly build image with:
```
    mvn spring-boot:build-image
```

then you need to build and run container. The simplest way to do it, allowing the connection w local database (ip specified in properties, default is localhost) is to run commend:
```
 docker run -d --net=host --name movie_app docker.io/library/movie-cat:0.0.1-SNAPSHOT
```
