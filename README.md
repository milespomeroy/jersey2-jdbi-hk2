# Implementation of JDBI using dependency injection in Jersey 2

## @OnDemand annotation

Created an `@OnDemand` annotation that will inject an on-demand JDBI DAO into Jersey resource methods. See `DaoResource` example.

## Requirements for running

### Postgres Database

- Host: 127.0.0.1
- Port: 5432
- Database: postgres
- Username: postgres
- Password: postgres

Specified in `context.xml`.

## Running

`mvn tomcat7:run`

OR

`mvn install` then copy `war` from target directory to application server.

OR

Run on server embedded in IDE.

## Endpoints

 - Test jersey is working - <http://localhost:8080/jersey2-jdbi-hk2/rest/helloworld>
 - Test connection to database - <http://localhost:8080/jersey2-jdbi-hk2/rest/db>
 - Test `@OnDemand` - <http://localhost:8080/jersey2-jdbi-hk2/rest/dao>
