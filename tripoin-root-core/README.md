# Run Configurations

Configuration file :

Command line :
- mvn clean install -DskipTests | in tripoin-root-core module
- Run As -> Run Jetty | in tripoin-core-integration module
<br>
Run test for development : <br>
* http://localhost:8080/tripoin/wscontext/connection<br>
	* Content-Type: application/json<br>
	* Accept: application/json<br>
* Test For JUnit Class in tripoin-web-service module :<br>
  com.tripoin.web.test.WebServiceGETTest