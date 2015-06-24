# Run Configurations

#####Configuration file :
* tripoin-core-integration\src\main\webapp\WEB-INF\properties-files\resources-mysql.properties
* tripoin-core-integration\src\main\webapp\WEB-INF\properties-files\resources-integration.properties

#####Command line :
* mvn clean install -DskipTests | in tripoin-root-core module
* Run As -> Run Jetty | in tripoin-core-integration module

#####Run test for development :
* http://localhost:8080/tripoin/wscontext/connection
	* Content-Type: application/json
	* Accept: application/json
* Test For JUnit Class in tripoin-web-service module :
  *com.tripoin.web.test.WebServiceGETTest*