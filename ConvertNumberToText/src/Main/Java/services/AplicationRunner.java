package services;

import api.services.IOService;
import api.services.NumberClassConverter;

public class AplicationRunner {
    IOService ioService;
    NumbersToTextConverter numbersToTextConverter;

    public AplicationRunner(IOService ioService,NumbersToTextConverter numbersToTextConverter) {

        this.ioService=ioService;
        this.numbersToTextConverter=numbersToTextConverter;
    }

    public void Run(){
        ioService.outputStr("Введите число или команду exit");
        while (true)
        {
            String str=ioService.readString();
            if(str.equals("exit")){
                ioService.outputStr("Работа завершена");
                break;
            }
            ioService.outputStr(numbersToTextConverter.getTextNumberView(str));
        }

    }
}

