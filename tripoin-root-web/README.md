# Run Configurations

#####Configuration file :
* *tripoin-web-ui\src\main\webapp\WEB-INF\properties-files\resources-web-application.properties*

#####Command line :
######Mode Debug

1. *tripoin-web-service* module

> ``mvn clean install -DskipTests``

2. *tripoin-web-ui* module | run test for development [http://localhost:8080/](http://localhost:8080/ "localhost")

> ``mvn jetty:run``

######Build War 

1. *tripoin-root-web* module

> ``mvn clean install -DskipTests``

2. *tripoin-root-web* module

> ``mvn -Pproduction package``