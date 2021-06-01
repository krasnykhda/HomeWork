package ru.otus;

import ru.otus.Assertions.Assertions;
import ru.otus.db.Fake.FakeEventsDB;
import ru.otus.domain.Event;
import ru.otus.service.EventsService;
import ru.otus.service.ServiceLogger;

public class EventsServiceTest {
    private final EventsService eventsService =  new EventsService(new FakeEventsDB(), new ServiceLogger() {
        @Override
        public void log(String message) {

        }
    });
    public void testMergeTwoCloseEvents(){

        Event ev1=null;
        try {
            Assertions.assertThrows(IllegalArgumentException.class,() ->eventsService.mergeTwoCloseEvents(1,1));
            System.out.printf("\"%s\" passed %n", "Тест1");
        } catch (Throwable e){
            System.err.printf("\"%s\" fails with message \"%s\" %n", "Тест1", e.getMessage());
        }
        try {
             Assertions.assertThrows(IllegalArgumentException.class,() ->eventsService.mergeTwoCloseEvents(1,8));
            System.out.printf("\"%s\" passed %n", "Тест2");
        } catch (Throwable e){
            System.err.printf("\"%s\" fails with message \"%s\" %n", "Тест2", e.getMessage());
       }
        EventsService eventsService=new EventsService(new FakeEventsDB(), new ServiceLogger() {
            @Override
            public void log(String message) {

            }
        });
        try {
            ev1 = eventsService.mergeTwoCloseEvents(1, 2);
            System.out.printf("\"%s\" passed %n", "Тест3");
        } catch (Throwable e){
            System.err.printf("\"%s\" fails with message \"%s\" %n", "Тест3", e.getMessage());
        }
        try {
            Assertions.assertThrows(IllegalArgumentException.class,() ->eventsService.mergeTwoCloseEvents(7,8));
            System.out.printf("\"%s\" passed %n", "Тест4");
        } catch (Throwable e){
            System.err.printf("\"%s\" fails with message \"%s\" %n", "Тест4", e.getMessage());
        }
        try {
            Assertions.assertThrows(IllegalArgumentException.class,() ->eventsService.mergeTwoCloseEvents(-7,-8));
            System.out.printf("\"%s\" passed %n", "Тест5");
        } catch (Throwable e){
            System.err.printf("\"%s\" fails with message \"%s\" %n", "Тест5", e.getMessage());
        }
    }
    public void testMergeTwoCloseEventsCorrected(){
        Event ev1=null;
        try {
            Assertions.assertThrows(IllegalArgumentException.class,() ->eventsService.mergeTwoCloseEventsCorrected(1,1));
            System.out.printf("\"%s\" passed %n", "Тест1");
        } catch (Throwable e){
            System.err.printf("\"%s\" fails with message \"%s\" %n", "Тест1", e.getMessage());
        }
        try {
            Assertions.assertThrows(IllegalArgumentException.class,() ->eventsService.mergeTwoCloseEventsCorrected(1,8));
            System.out.printf("\"%s\" passed %n", "Тест2");
        } catch (Throwable e){
            System.err.printf("\"%s\" fails with message \"%s\" %n", "Тест2", e.getMessage());
        }
        try {
            ev1 = eventsService.mergeTwoCloseEventsCorrected(1, 2);
            System.out.printf("\"%s\" passed %n", "Тест3");
        } catch (Throwable e){
            System.err.printf("\"%s\" fails with message \"%s\" %n", "Тест3", e.getMessage());
        }
        try {
            Assertions.assertThrows(IllegalArgumentException.class,() ->eventsService.mergeTwoCloseEventsCorrected(7,8));
            System.out.printf("\"%s\" passed %n", "Тест4");
        } catch (Throwable e){
            System.err.printf("\"%s\" fails with message \"%s\" %n", "Тест4", e.getMessage());
        }
        try {
            Assertions.assertThrows(IllegalArgumentException.class,() ->eventsService.mergeTwoCloseEventsCorrected(-7,-8));
            System.out.printf("\"%s\" passed %n", "Тест5");
        } catch (Throwable e){
            System.err.printf("\"%s\" fails with message \"%s\" %n", "Тест5", e.getMessage());
        }

    }
}
