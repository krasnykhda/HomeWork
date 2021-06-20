import api.services.IOService;
import api.services.NumberClassConverter;
import services.AplicationRunner;
import services.ConsoleIOService;
import services.NumberClassConverterRus;
import services.NumbersToTextConverter;


public class HomeWork {

    public static void main(String[] args) {
        IOService ioService=new ConsoleIOService();
        NumberClassConverter numberClassConverter=new NumberClassConverterRus();
        NumbersToTextConverter numbersToTextConverter=new NumbersToTextConverter(numberClassConverter);
        AplicationRunner aplicationRunner=new AplicationRunner(ioService,numbersToTextConverter);
        aplicationRunner.Run();

    }
}
