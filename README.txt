<<<<<<< HEAD
0/ gradle getDeps
jars are found in runtime/

0.5/ add jars to the build path.

1/ gradlew run

2/ install mysql 5.7

3/ Then if see the following issues, then need to fix it by root account. 

mysql> CREATE USER 'username'@'localhost' IDENTIFIED WITH mysql_native_password BY 'pa$$word';
Query OK, 0 rows affected (0.06 sec)

Login with root in mysql and do the following,

mysql> grant ALL privileges on Challenge.* to 'username'@'localhost';
Query OK, 0 rows affected (0.04 sec)

4/ don't need to specify yml file and db config as it is in the gradle file

5/ Run jetty server
 java -jar target\DropWizardExample-0.0.1-SNAPSHOT.jar server
 
6/ For example code, 

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

7/ Demo restful access for GET, localhost:8000/employees
create table user (
    -- auto-generated primary key
    id bigint primary key not null auto_increment,
    username varchar(255) not null,
    password varchar(255) not null,
    securityQuestion  varchar(255) null,
    securityAnswer varchar(255) null
);

0/ gradle getDeps
jars are found in runtime/

0.5/ add jars to the build path.

1/ gradlew run

2/ install mysql 5.7

3/ Then if see the following issues, then need to fix it by root account. 

mysql> CREATE USER 'username'@'localhost' IDENTIFIED WITH mysql_native_password BY 'pa$$word';
Query OK, 0 rows affected (0.06 sec)

Login with root in mysql and do the following,

mysql> grant ALL privileges on Challenge.* to 'username'@'localhost';
Query OK, 0 rows affected (0.04 sec)

4/ don't need to specify yml file and db config as it is in the gradle file

5/ Run jetty server
 java -jar target\DropWizardExample-0.0.1-SNAPSHOT.jar server
 
6/ For example code, 

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

7/ Demo restful access for GET, localhost:8000/employees
create table user (
    -- auto-generated primary key
    id bigint primary key not null auto_increment,
    username varchar(255) not null,
    password varchar(255) not null,
    securityQuestion  varchar(255) null,
    securityAnswer varchar(255) null
);

8/ 
create table message (
    -- auto-generated primary key
    id bigint primary key not null auto_increment,
    from varchar(255) not null,
    to varchar(255) not null,
    messageType  varchar(255) null,
    body varchar(255) null
);


select count(*) from message 
where from = 'user1' and to = 'user2' OR
from = 'user2' and to = 'user1' 

