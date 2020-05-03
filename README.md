# Java EE stack 

Stack Java EE per il corso di Sotfware Architecture and Methodologies

## Esecuzione

Eseguire da terminale nella root del progetto

`./deploy.sh`


## Istanza Mysql

`docker run -it --name mysql-server -p 3306:3306 -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=swam_test mysql:8 mysqld --default-authentication-plugin=mysql_native_password`