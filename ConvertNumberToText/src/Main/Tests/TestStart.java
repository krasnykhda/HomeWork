public class TestStart {
    public static void main(String[] args) {
        TestExecutor.doTest("Тест вывода текстового представления числа",
                () -> new NumbersToTextConverterTest().testConverter());

    }
}
