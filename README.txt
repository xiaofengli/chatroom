##Project instruction

### `gradle getDeps` task
download jars and copy them, found them in runtime/

### add jars to the build path.

### `gradlew run`
Check project and start jetty server

### install mysql 5.7
Use version 5.7 instead of v8 due to some unsolved issue. Too much time consuming set up..

### Create a db account with root login 

mysql> CREATE USER 'username'@'localhost' IDENTIFIED WITH mysql_native_password BY 'pa$$word';
Query OK, 0 rows affected (0.06 sec)

### Grant db table permission
Login with root in mysql and do the following,

mysql> grant ALL privileges on Challenge.* to 'username'@'localhost';
Query OK, 0 rows affected (0.04 sec)

### YAML file, db configuration, db username and password
don't need to specify yml file and db config as it is in the gradle file

### Run jetty server (not needed)
 java -jar target\DropWizardExample-0.0.1-SNAPSHOT.jar server
 
### Tables 
Demo table copied from somewhere
/*
create table employees(
    -- auto-generated primary key
    id bigint primary key not null auto_increment,
    first_name varchar(255) not null,
    last_name varchar(255) not null,
    -- employee position
    e_position  varchar(255) not null,
    phone  varchar(255) not null,
    e_mail varchar(255) not null
);
*/

Demo restful access for GET, localhost:8000/employees
create table users (
    -- auto-generated primary key
    id bigint primary key not null auto_increment,
    username varchar(255) not null,
    password varchar(255) not null,
    securityQuestion  varchar(255) null,
    securityAnswer varchar(255) null,
    UNIQUE(username)
);

Our tables,
`
create table user (
    -- auto-generated primary key
    id bigint primary key not null auto_increment,
    username varchar(255) not null,
    password varchar(255) not null,
    password_salt varchar(255) null,
    password_hash_algorithm varchar(255) not null,
    security_question  varchar(255) null,
    security_answer varchar(255) null
);`

`
create table messages (
    -- auto-generated primary key
    id bigint primary key not null auto_increment,
    sender varchar(255) not null,
    receiver varchar(255) not null,
    message_type  varchar(255) null,
    body varchar(255) null,
    logg_time DATETIME not null
);
`
