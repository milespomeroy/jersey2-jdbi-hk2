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

## Branches

### master

`@OnDemand` JDBI DAO jersey resource method implementation.

### hk2-service

Uses HK2 to inject a simple service class. Works when bind manually configured. Failed to get automatic service population to work.

### guice-bridge

Uses Guice HK2 bridge to inject a Guice configured service into a Jersey resource. Bind must be configured manually.

Just in time Guice bindings don't work. I tried changing the bridge code to make JIT Guice bindings work, but I think this might be a bad idea. It required exceptions to be thrown and caught. It also might cause Guice to instantiate objects that HK2 should be in charge of.

### lingotek-jdbi-guice-bridge

Same as the `guice-bridge` branch but with the Lingotek JDBI dependency added in. This dependency adds a Guice configured `@OnDemand` JDBI DAO provider. The `GuicedDaoResource` uses it to access the database.
