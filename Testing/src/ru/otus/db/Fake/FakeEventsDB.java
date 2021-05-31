package ru.otus.db.Fake;

import ru.otus.db.EventsDb;
import ru.otus.domain.Event;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class FakeEventsDB implements EventsDb {
    private Event[]events=new Event[6];
    public FakeEventsDB() {
        var startTime = LocalDateTime.of(2021, 2, 2, 6, 0);
        for (int i = 1; i < 6; i++) {
            var endTime = startTime.plus(30, ChronoUnit.MINUTES);
            var event = new Event(i, startTime, endTime, "Event" + i);
            events[i]=event;
            startTime = endTime;
        }
    }

    @Override
    public Event findById(long id) {
        if(id>6||id<0) return null;
        int i=(int)id;
        return events[i];
    }

    @Override
    public void saveEvent(Event event) {

    }

    @Override
    public void deleteEventById(long id) {

    }
}
