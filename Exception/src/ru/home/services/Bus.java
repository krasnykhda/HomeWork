package ru.home.services;

public class Bus implements Vehicles {
    private final int weight;
    private final int maxSpeed;
    private final int fuelVolume;
    private int currentSpeed = 0;
    private int fuelRemaining = 0;
    private final int maximumLoadPerson;
    private int currentLoadPerson=0;
    public Bus(int weight, int maxSpeed, int fuelVolume,int maximumLoadPerson) {
        this.weight = weight;
        this.maxSpeed = maxSpeed;
        this.fuelVolume = fuelVolume;
        this.maximumLoadPerson=maximumLoadPerson;
    }

    @Override
    public void move(int currentSpeed) {
        try {
            if (this.maxSpeed < currentSpeed) throw new Exception("Ops");
            this.currentSpeed = currentSpeed;
            System.out.println("Я автобус и я еду со скоростью " + currentSpeed);
        } catch (Exception e) {
            System.out.println("Автобусу нельзя превышать максимально допустимую скорость");
        }

    }

    @Override
    public void addFuel(int volume) throws Exception {
        if (this.fuelRemaining + volume > this.fuelVolume) throw new Exception();
        this.fuelRemaining += volume;

    }

    @Override
    public void drainFuel(int volume) {
        try{
            if(this.fuelRemaining-volume<0) throw new Exception();
        }catch (Exception e){
            throw new RuntimeException();
        }
    }

    @Override
    public int getfuelRemaining() {
         return this.fuelRemaining;
    }

    @Override
    public void writeLog(Exception e) {

    }

    @Override
    public void loading(int amount) throws Exception {
        try{
            if(this.currentLoadPerson+amount>this.maximumLoadPerson) throw new Exception();
            this.currentLoadPerson+=amount;

        }catch (Exception e){
            throw new Exception("Превышена максимальная загрузка автобуса",e);
        }
    }
}