Spring Boot REST application with session storing in Redis and permission-based authorization.

Users, roles and permissions stored in MySQL database.

To testing on Windows I'm using Redis from Microsoft Archive: https://github.com/MicrosoftArchive/redis/releases

# Quick start

## 1. Database
Firstly we need to setup DB (MySQL in this case). Run SQL scripts from "DB-init" folder in the next following order:
1. ```create-schema.sql```
2. ```user-table.sql```
3. ```role-table.sql```
4. ```permission-table.sql```
5. ```users_roles-table.sql```
6. ```roles_permissions-table.sql```

After DB init we'll have the next following:
1. 3 permissions ```READ```, ```WRITE``` and ```DELETE```
2. 3 roles:
    - ```GUEST``` with permission ```READ```
    - ```USER``` with permissions ```READ``` and ```WRITE```
    - ```ADMIN``` with **all permissions** -  ```READ```, ```WRITE``` and ```DELETE```
3. 3 users:
    - **admin@mail.com** with role ```ADMIN```
    - **nkor@mail.com** with role ```USER```
    - **anon@mail.com** with role ```GUEST```


#### All users have passwords ```123```


## 2. ProtectedResourceController
We have only 1 REST controller ```ProtectedResourceController``` with the next following endpoints:
1. ```/protected/read``` - requires ```READ``` permission
2. ```/protected/write``` - requires ```WRITE``` permission
3. ```/protected/delete``` - requires ```DELETE``` permission

## 3. Authentication and authorization
The application using HTTP Basic Authentication. Therefore, for being authenticated send request to localhost:8080/ (or to any other endpoint) with authorization header (e.g. ```Authorization: Basic YW5vbkBtYWlsLmNvbToxMjM=``` for user ```anon@mail.com```). Take a look to response headers, if we have ```x-auth-token``` then session successfully created and stored in Redis. 

OK, let's try to get protected resources. Sending requests to ProtectedResourceController with header X-Auth-Token (in my case it is ```X-Auth-Token: 5eb44938-1a83-4a0d-9169-5b8be4de34e5```):
- If we authenticated as ```admin@mail.com``` - all resources allowed
- If we authenticated as ```nkor@mail.com``` - ```Access Denied``` for ```/protected/delete```
- If we authenticated as ```anon@mail.com``` - ```Access Denied``` for ```/protected/write``` and ```/protected/delete```
