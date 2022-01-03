[![Build status](https://ci.appveyor.com/api/projects/status/tail5rylc3l8euvl/branch/master?svg=true)](https://ci.appveyor.com/project/andrew-pahomov/homework-aqa-2-4-2/branch/master)

# Тестирование сервиса перевода денежных средств с карты на карту
В рамках проекта проведено автоматизированное тестирование функции перевода денежных средств с карты на карту в системе интернет банкинга с помощью библиотеки Акита.

## Начало работы
Проект расположен на GitHub по адресу: [https://github.com/andrew-pahomov/homework-aqa-2.4.2](https://github.com/andrew-pahomov/homework-aqa-2.4.2)

### Prerequisites
На компьютере необходимо иметь установленный Git, Java Jre, браузер Google Chrome.

### Установка и запуск
1. Клонируем проект в локальный репозиторий.
2. Запускаем сервис командой java -jar app-ibank-build-for-testers.jar из папки artifacts
3. Запускаем тесты командой gradlew.bat test под Windows или ./gradlew test под Linux.