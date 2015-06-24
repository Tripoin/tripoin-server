# Run Configurations

Configuration file :

Command line :
- mvn clean install -DskipTests | in tripoin-root-core module
- Run As -> Run Jetty | in tripoin-core-integration module

Run test for development : 
1. http://localhost:8080/tripoin/wscontext/connection<br>
  - Content-Type: application/json
  - Accept: application/json
2. Test For JUnit Class in tripoin-web-service module :<br>
  com.tripoin.web.test.WebServiceGETTest