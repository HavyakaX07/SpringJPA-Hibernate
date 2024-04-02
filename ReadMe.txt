In this section we will be going through Data-persistance topic in java. Data can saved in two ways, in file system
and inside data base. Data base is more convinient than the file system for more reason. 

So this section deals with how we can establish the connection to data base and make some connection and query.

For that we will use H2 in memory data base 

Inoder to create schema we will use one schema.sql file and there we will keep the DDL script. 
So we will create small table Course with id, name, author as columns with id as primary key.

Now lets come to progress of persistancy context

1. JDBC -> we need to establish the connection, prepare statement, execute and close the connection.

2. Spring JDBC -> Lot of boiler plate code was there hence JdbcTemplate came and connection maintaining wont be user head ache only executing query is users responsibility.

3. JPA -> No need to write query and map the result set and pojo and all. Create entity that represents the table in the schema and maintain that using EntiryManager Persistance Context.

4. Spring Data JPA -> Now no need to maintain the EntityManage also just create interface that extends JPARepository by giving which entity to manage and which field type is the primary key

So JPA is the specification and hibernate is the implementation of specification.

With this we learnt about JPA 