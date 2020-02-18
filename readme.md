# Задание
Реализовать REST- сервис, с поддержкой create, update, delete, get операций. Использовать Spring + Spring Boot. Написать интеграционные тесты. В качестве базы можно использовать h2.

# Инструменты
+ InteliJ IDEA
+ JDK 1.8
+ Maven
+ H2

# Установка и запуск
Открываем командную строку в папке с файлов pom.xml и в командной строке пишем
```
mvn clean spring-boot:run
```

# Запросы на сервер
Чтение всего списка
```
curl -X GET localhost:8081/api/banks
```
Чтение экземпляра по id
```
curl -X GET localhost:8081/api/banks/{id}
```
Создание экземпляра
```
curl -X POST localhost:8081/api/banks -H 'Content-type:application/json' -d '{"name": "{name_instance}"}'
```
Обновление экземпляра по заданному id
```
curl -X PUT localhost:8081/api/banks/{id} -H 'Content-type:application/json' -d '{"name": "{name_instance}"}'
```
Удаление экземпляра по заданному id
```
curl -X DELETE localhost:8081/api/banks/{id}
```
##### Параметры:
{id} - идентификатор экземпляра;
{name_instance} - название экземпляра.

