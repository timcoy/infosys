# ANZ Wholesale Engineering Sample Project (Backend Development)
#### Author
Tim Coy

## About
The application contains the backend REST APIs needed to support a web application to that allows a user to view accounts and subsequently view transactions on any of the accounts they hold.

## Requiremnets
To build and run this application requires
* [Java 1.8 or above]
* [Maven 3.6 or above]


## Building
The application can be built from the cmd line using
  <code>mvn clean install</code>

## Running
The application can be run from the cmd line using 
  <code>java -jar target/restapp.jar</code>

## Testing
The application can be tested using these endpoints
* [View account list](http://localhost:8082/user/11) <code>http://localhost:8082/user/11</code>
* [View account transactions](http://localhost:8082/account/101) <code>http://localhost:8082/account/101</code> 

## Database
The application comes bundled with HSQLDB and some dummy data to facilitate testing the endpoints.

The database is configured in src/main/resources/application.properties.

The dummy data is loaded from src/main/resources/data.sql