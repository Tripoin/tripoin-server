# Run Configurations

#####Configuration file :

#####Command line :
- tripoin-root-web module

> ``mvn clean install -DskipTests``
 
- tripoin-web-ui module | run test for development [http://localhost:8080/](http://localhost:8080/ "localhost")

> ``mvn jetty:run``
 
- tripoin-root-web/tripoin-web-app module | packaging war bundle

> ``mvn -Pproduction package``