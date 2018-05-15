1/ gradlew run

2/ install mysql 5.7

3/ Then if see the following issues, then need to fix it by root account. 

mysql> CREATE USER 'username'@'localhost' IDENTIFIED WITH mysql_native_password BY 'pa$$word';
Query OK, 0 rows affected (0.06 sec)

Login with root in mysql and do the following,

mysql> grant ALL privileges on Challenge.* to 'username'@'localhost';
Query OK, 0 rows affected (0.04 sec)

4/ don't need to specify yml file and db config as it is in the gradle file

