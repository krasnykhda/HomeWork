package ru.home.services;

public interface Vehicles {
    void move(int currentSpeed);
    void addFuel(int volume) throws Exception;
    void drainFuel(int volume);
    void loading(int amount) throws Exception;
    int getfuelRemaining();
    void writeLog(Exception e);
}
