# Manage Products

### Description
This service is responsable to manage products.

### Get Started
You must have [JDK11](http://openjdk.java.net) and [Maven](https://maven.apache.org) installed.

1. Clone the repositorie using `git clone`
2. Enter in the cloned repositorie using `cd`
3. Execute the command `mvn package` to build the application
4. Choose the [profile](#profiles) that will execute the application.
5. After build, execute the application with command `java -jar -Dspring.profiles.active={test/dev} target/finance-backend-0.0.1-SNAPSHOT.jar`.

### Profiles
There are two profiles to execute the application:
* test - Run the application with [H2](https://www.h2database.com) embedded database. After sucess to load the appliaciton, you can see the database console in the [link](http://localhost:8090/h2-console)
* dev - Run the application with MySql database installed locally. It is necessary see 'application-dev.properties file to know the configurations.

### Swagger Documentation
When the application is alive, you can access the api documentation in the [address](http://localhost:8090/swagger-ui.html)