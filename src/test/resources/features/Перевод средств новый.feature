#language:ru

Функциональность: Перевод средств
#  Структура сценария: Перевод средств с карты на карту
#    Пусть совершен переход на страницу "Страница входа" по ссылке "loginUrl"
#    Когда в поле "Логин" введено значение "login"
#    И в поле "Пароль" введено значение "password"
#    И выполнено нажатие на кнопку "Продолжить"
#    Тогда страница "Подтверждение входа" загрузилась
#    Когда в поле "Код" введено значение "code"
#    И выполнено нажатие на кнопку "Продолжить"
#    Тогда страница "Дашбоард" загрузилась
#
#    Примеры:
#      | login | password  | code  |
#      | vasya | qwerty123 | 99999 |

  Структура сценария: Перевод средств с карты на карту
    Пусть пользователь залогинен с именем <login> и паролем <password> и страница дашбоарда загрузилась
    Когда он переводит <amount> рублей с карты с номером <debitCardNumber> на карту с номером <creditCardNumber>
    Тогда баланс его карты с номером <creditCardNumber> должен стать <expectedCreditBalance> рублей
    И баланс его карты с номером <debitCardNumber> должен стать <expectedDebitBalance> рублей
    Примеры:
      | login   | password    | amount | debitCardNumber    | creditCardNumber   | expectedCreditBalance | expectedDebitBalance |
      | "vasya" | "qwerty123" | "5000" | "5559000000000002" | "5559000000000001" | "15000"               | "5000"               |
      | "vasya" | "qwerty123" | "6000" | "5559000000000001" | "5559000000000002" | "16000"               | "4000"               |
