import api.services.NumberClassConverter;
import services.NumberClassConverterRus;
import services.NumbersToTextConverter;

public class NumbersToTextConverterTest {
    private final NumberClassConverter numberClassConverter=new NumberClassConverterRus();
    private final NumbersToTextConverter numbersToTextConverter=new NumbersToTextConverter(numberClassConverter);
    public void testConverter(){
        try {
            Assertions.assertEquals(" сто двадцать три рубля",numbersToTextConverter.getTextNumberView("123"));
            //Assertions.assertEquals("сто двадцать три рубля","hhh");
            System.out.printf("\"%s\" passed %n", "Тест1");
        } catch (Throwable e){
            System.err.printf("\"%s\" fails with message \"%s\" %n", "Тест1", e.getMessage());
        }
        try {
            Assertions.assertEquals(" одна тысяча двести тридцать пять рублей",numbersToTextConverter.getTextNumberView("1235"));
            //Assertions.assertEquals("сто двадцать три рубля","hhh");
            System.out.printf("\"%s\" passed %n", "Тест2");
        } catch (Throwable e){
            System.err.printf("\"%s\" fails with message \"%s\" %n", "Тест2", e.getMessage());
        }
        try {
            Assertions.assertEquals(" один рубль",numbersToTextConverter.getTextNumberView("1"));
            //Assertions.assertEquals("сто двадцать три рубля","hhh");
            System.out.printf("\"%s\" passed %n", "Тест3");
        } catch (Throwable e){
            System.err.printf("\"%s\" fails with message \"%s\" %n", "Тест3", e.getMessage());
        }
        try {
            Assertions.assertThrows(IllegalArgumentException.class,() ->numbersToTextConverter.getTextNumberView("f"));
            System.out.printf("\"%s\" passed %n", "Тест4");
        } catch (Throwable e){
            System.err.printf("\"%s\" fails with message \"%s\" %n", "Тест4", e.getMessage());
        }
        try {
            Assertions.assertEquals(" девять рублей",numbersToTextConverter.getTextNumberView("10"));
            //Assertions.assertEquals("сто двадцать три рубля","hhh");
            System.out.printf("\"%s\" passed %n", "Тест5");
        } catch (Throwable e){
            System.err.printf("\"%s\" fails with message \"%s\" %n", "Тест5", e.getMessage());
        }

    }
}
