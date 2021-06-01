package ru.otus;

import ru.otus.Assertions.TestExecutor;
public class HomeWork {


    /*
        С помощью юнит-тестов, проверить работу метода mergeTwoCloseEvents класса EventsService при различных сценариях использования.
        Должно быть не менее 4 падающих теста (один сценарий - один тест)
        При тестировании, зависимости класса заменить на заглушки (выбрать подходящий тип).
        В том же классе EventsService создайте метод mergeTwoCloseEventsCorrected, в котором исправьте найденные ошибки.
        Для этого метода все тесты должны проходить

        Информацию о пройденном тесте предлагается выводить в System.out, а об упавшем в System.err
     */

     public static void main(String[] args) {
        TestExecutor.doTest("Тест объединения 2 событий",
                () -> new EventsServiceTest().testMergeTwoCloseEvents());
        TestExecutor.doTest("Тест объединения 2 событий",
                 () -> new EventsServiceTest().testMergeTwoCloseEventsCorrected());
    }
    
}