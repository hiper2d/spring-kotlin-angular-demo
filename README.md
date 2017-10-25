Spring 5 Kotlin Angular demo
=============

[![TravisCI Build](https://travis-ci.org/hiper2d/spring-kotlin-angular-demo.svg)](https://travis-ci.org/hiper2d/spring-kotlin-angular-demo)

This project is designed to demonstrate new `Spring 5 WebFlux Framework` with Kotlin and Angular 4.

### Technology stack
* Spring Framework 5
* Spring Boot 2.0.0
* Spring WebFlux
* Kotlin 1.1.51
* Gradle 4
* Angular 4
* Webpack 3

### Prerequisites
1. Gradle 4
2. Docker
3. Node + npm

### Build
> use `./gradlew` instead of `gradle` if you didn't installed `gradle`
##### Dev mode
```bash
# build Spring Boot server application
gradle server:build
# install Angular client dependencies
gradle client:npm_install
```
##### Production mode
Includes Angular AoT compilation
```bash
# build Spring Boot server application
gradle server:build
# install Angular client dependencies and run AoT compilation
gradle client:npmProdBuild
```

### Run
##### Manual
Start [server](./server/):
```bash
# as Java appliasion
gradle server:bootRun
# as Docker image
gradle server:docker
```
Start [client](./client/) in development mode using webpack-dev-server
```bash
gradle client:npmStart
```
Start [client](./client/) in production mode using Nginx inside Docker container
```bash
gradle client:docker
```
