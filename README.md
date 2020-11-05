# Quarkus simple example
(Based on: https://www.youtube.com/watch?v=djimiHdn0f8&feature=emb_logo)

## Dependencies
* Java: 11
* Maven: 3.63
* (external) MariaDB: 10.4

You can run a MariaDB instance like:
```bash
$ docker run -d --name mariadb -p 3306:3306 -e MYSQL_USER=sparksjoy -e MYSQL_PASSWORD=sparksjoy -e MYSQL_ROOT_PASSWORD=sparksjoy -e MYSQL_DATABASE=sparksjoy mariadb:10.4
```

And start Quarkus, in dev mode:
```bash
$ mvn quarkus:dev
```

Check DB content:
```bash
docker exec -it mariadb bash
```
Once in mariadb container:
```bash
mysql --user=sparksjoy --password=sparksjoy sparksjoy

MariaDB [sparksjoy]> show tables;
```
> It won't show any new table

Access to "developer" endpoint:
```bash
open http://localhost:8080/developer
```
> You will se an empty json, but new tables should be already created


You can try endpoint in embedded swagger:
```bash
open http://localhost:8080/swagger-ui/
```
> And you can insert developers in post developer endpoint

You can also check developers by using command line:
```bash
curl -s -w "\n" http://localhost:8080/developer
```

---

# General instructions
This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `vjug-1.0.0-SNAPSHOT-runner.jar` file in the `/target` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/lib` directory.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application is now runnable using `java -jar target/vjug-1.0.0-SNAPSHOT-runner.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/vjug-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.html.

# RESTEasy JAX-RS

Guide: https://quarkus.io/guides/rest-json


