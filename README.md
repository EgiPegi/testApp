# Grails 4 With Mysql 
Clone this repo <br>
go to 
```bash
grails-app/conf/application.yml 
```
# Edit the dataSource dan environment configuration
```yml
dataSource:
    pooled: true
    jmxExport: true
    driverClassName: com.mysql.jdbc.Driver   
    dialect: org.hibernate.dialect.MySQL5InnoDBDialect
    username: sammy #use your username
    password: password #use your password
environments:
    development:
        dataSource:
            dbCreate: update
            url: jdbc:mysql://127.0.0.1:3306/testapp #the database url
 ```
 # Compile
 run
 ```bash
 grails compile
 ```
 The next steps is to made a database on your mysql database. In this project I named my database as testapp.
 
# Now You can run your grails web app with
```bash
grails run-app
```
