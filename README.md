для запуска требуется maven, docker, jdk 
подключение к базе данных можно настроить в src/main/resources/database.properties

docker-compose      up запускает postgres в docker-контейнере
mvn flyway:migrate  прогоняет миграции, лежащие в папке recources/dbscripts


