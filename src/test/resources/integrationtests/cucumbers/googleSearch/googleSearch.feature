@GoogleSearch
Feature: Search Google

  Scenario: (0) Открываем Google Chrome и проверяем title вкладки

    When Открываем браузер Google Chrome

    When Вводим адрес поисковой страницы Google
    Then Отображается название вкладки "Google"

    When Выполняем запрос "госуслуги" в поисковой строке браузера
    Then Отображается название вкладки "госуслуги - Поиск в Google"

    When Очищаем поле запроса

    When Закрываем браузер