package ru.otus.service;

import ru.otus.db.EventsDb;
import ru.otus.domain.Event;
import java.math.*;

public class EventsService {

    private final EventsDb db;
    private final ServiceLogger logger;

    public EventsService(EventsDb db, ServiceLogger logger) {
        //this.db = Objects.requireNonNull(db);//db;
        //this.logger = Objects.requireNonNull(logger);//logger;
        this.db = db;
        this.logger = logger;
    }

    public Event mergeTwoCloseEvents(long firstEventId, long secondEventId)  {
        logger.log("Загрузка событий из БД");
        Event firstEvent=null;
        firstEvent = db.findById(firstEventId);
        Event secondEvent=null;
           secondEvent =db.findById(secondEventId);

        logger.log(String.format("Событие #1: %s", firstEvent));
        logger.log(String.format("Событие #2: %s", secondEvent));

        logger.log("Объединение событий");
        Event mergedEvent = new Event(firstEvent.getId(),
                    firstEvent.getStart(),
                    secondEvent.getEnd(),
                    String.format("%s, %s", firstEvent.getName(), secondEvent.getName()));

        logger.log("Удаление старых событий");
        db.deleteEventById(firstEventId);
        db.deleteEventById(secondEventId);

        logger.log("Сохранение объединенного события");
        db.saveEvent(mergedEvent);
        return mergedEvent;
    }
    public Event mergeTwoCloseEventsCorrected(long firstEventId, long secondEventId) {

        if(firstEventId<0||secondEventId<0||secondEventId==firstEventId||firstEventId>6||secondEventId>6||Math.abs(firstEventId)-Math.abs(secondEventId)>1){
            throw new IllegalArgumentException();
        }
            logger.log("Загрузка событий из БД");
            Event firstEvent = null;
            firstEvent = db.findById(firstEventId);
            Event secondEvent = null;
            secondEvent = db.findById(secondEventId);

            logger.log(String.format("Событие #1: %s", firstEvent));
            logger.log(String.format("Событие #2: %s", secondEvent));

            logger.log("Объединение событий");
            Event mergedEvent = new Event(firstEvent.getId(),
                    firstEvent.getStart(),
                    secondEvent.getEnd(),
                    String.format("%s, %s", firstEvent.getName(), secondEvent.getName()));

            logger.log("Удаление старых событий");
            db.deleteEventById(firstEventId);
            db.deleteEventById(secondEventId);

            logger.log("Сохранение объединенного события");
            db.saveEvent(mergedEvent);
            return mergedEvent;
        }

}

