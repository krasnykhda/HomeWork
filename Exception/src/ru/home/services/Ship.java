package ru.home.services;

public class Ship implements Vehicles{
    private final int weight;
    private final int maxSpeed;
    private final int fuelVolume;
    private int currentSpeed=0;
    private int fuelRemaining=0;
    private final int maximumLoadTons;
    private int currentLoadTons=0;
    public Ship(int weight, int maxSpeed, int fuelVolume,int maximumLoadTons) {
        this.weight=weight;
        this.maxSpeed=maxSpeed;
        this.fuelVolume=fuelVolume;
        this.maximumLoadTons=maximumLoadTons;
    }

    @Override
    public void move(int currentSpeed)
    {
        try {
            if(this.maxSpeed<currentSpeed) throw new Exception();
            this.currentSpeed=currentSpeed;
            System.out.println("Я корабль и я плыву со скоростью "+currentSpeed);
        } catch (Exception e){
            System.out.println("Кораблю нельзя превышать максимально допустимую скорость");
        }

    }

    @Override
    public void addFuel(int volume) throws Exception {
        if(this.fuelRemaining+volume>this.fuelVolume) throw new Exception();
        this.fuelRemaining+=volume;
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
    public void writeLog(Exception e) {

    }



    @Override
    public void loading(int amount) throws Exception {
        try{
            if(this.currentLoadTons+amount>this.maximumLoadTons) throw new Exception();
            this.currentLoadTons+=amount;

        }catch (Exception e){
            throw new Exception("Превышена максимальная загрузка корабля",e);
        }
    }

    @Override
    public int getfuelRemaining() {
         return this.fuelRemaining;
    }

}
