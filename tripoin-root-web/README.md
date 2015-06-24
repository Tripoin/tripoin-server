# Run Configurations

Command line :
- mvn clean install -DskipTests | in tripoin-root-web module
- mvn jetty:run | in tripoin-web-ui module, run test for development http://localhost:8080/
- mvn -Pproduction package | in tripoin-root-web/tripoin-web-app module, packaging war bundle